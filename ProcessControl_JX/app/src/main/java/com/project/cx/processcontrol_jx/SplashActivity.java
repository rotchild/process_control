package com.project.cx.processcontrol_jx;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.project.cx.processcontrol_jx.ui.activity.LoginActivity;
import com.project.cx.processcontrol_jx.util.UserManager;

/**
 * Created by Administrator on 2018/2/23 0023.
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //skipActivity();
        startActivity(new Intent(this,LoginActivity.class));
        this.finish();
    }

    private void skipActivity() {
        if(UserManager.getInstance().isLogin()){
            startActivity(new Intent(this,MainActivity.class));
        }else{
            startActivity(new Intent(this,LoginActivity.class));
        }
    }
}
