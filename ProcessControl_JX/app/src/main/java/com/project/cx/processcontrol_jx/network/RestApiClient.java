package com.project.cx.processcontrol_jx.network;

import com.project.cx.processcontrol_jx.context.AppConfig;
import com.project.cx.processcontrol_jx.network.service.AccountService;
import com.project.cx.processcontrol_jx.network.service.BusinessService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/2/7 0007.
 */

public class RestApiClient {
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
        builder.addInterceptor(logging);
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
