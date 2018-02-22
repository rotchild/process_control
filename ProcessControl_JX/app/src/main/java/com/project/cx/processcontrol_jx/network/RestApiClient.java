package com.project.cx.processcontrol_jx.network;

import com.project.cx.processcontrol_jx.MyApplication;
import com.project.cx.processcontrol_jx.context.AppConfig;
import com.project.cx.processcontrol_jx.network.service.AccountService;
import com.project.cx.processcontrol_jx.network.service.BusinessService;
import com.project.cx.processcontrol_jx.util.NetWorkUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/2/7 0007.
 */

public class RestApiClient {
    private static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR=new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response originalResponse=chain.proceed(chain.request());
            if(NetWorkUtil.isNetWorkAvailable(MyApplication.getContext())){
                int maxAge=60;//在线缓存在1分钟内可读取
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control","public,max-age="+maxAge)
                        .build();
            }else{
                int maxStale = 60 * 60 * 24 * 28; // 离线时缓存保存4周
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
        }
    };
    private static File httpCacheDirectory=new File(MyApplication.getContext().getCacheDir(),"restapi");
    private static int cachesize=10*1024*1024;//10MiB
    private static Cache cache=new Cache(httpCacheDirectory,cachesize);
    //private Context mContext;
    private Retrofit mRetrofit;
    public RestApiClient(){}
/*    public RestApiClient(Context context) {
        mContext=context;
    }*/
    private OkHttpClient newRetrofitClient(){
        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        builder.connectTimeout(AppConfig.CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        builder.readTimeout(AppConfig.READ_TIMEOUT_MILLIS,TimeUnit.MILLISECONDS);
        // 添加OkHttp日志打印器
        HttpLoggingInterceptor logging=new HttpLoggingInterceptor();
        logging.setLevel(true ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        builder.addInterceptor(logging)
                .addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                .addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                .cache(cache);
        return builder.build();
    }

    private Retrofit getRetrofit(){
        if(mRetrofit==null){
            Retrofit.Builder builder=new Retrofit.Builder();
            builder.client(newRetrofitClient());
            builder.baseUrl(AppConfig.SERVER_URL);
            builder.addConverterFactory(GsonConverterFactory.create());
            builder.addCallAdapterFactory(RxJavaCallAdapterFactory.create());
            mRetrofit=builder.build();
        }
        return mRetrofit;
    }

    public AccountService accountService(){
        return getRetrofit().create(AccountService.class);
    }
    public BusinessService businessService(){
        return getRetrofit().create(BusinessService.class);
    }

}
