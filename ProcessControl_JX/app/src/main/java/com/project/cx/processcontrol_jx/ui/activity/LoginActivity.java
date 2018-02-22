package com.project.cx.processcontrol_jx.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.project.cx.processcontrol_jx.MainActivity;
import com.project.cx.processcontrol_jx.R;
import com.project.cx.processcontrol_jx.presenter.PLogin;
import com.project.cx.processcontrol_jx.presenter.PLoginImp;
import com.project.cx.processcontrol_jx.util.MD5;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/2/19 0019.
 */

public class LoginActivity extends AppCompatActivity implements ILogin{
    @BindView(R.id.progressbar)
    ProgressBar progressBar;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login)
    Button login;

    PLogin mLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mLoginPresenter=new PLoginImp(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onLoginSuccess() {
        login.setClickable(true);
        username.setFocusable(true);
        password.setFocusable(true);
        setProgressBar(View.GONE);
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void onLoginFail(String errMsg) {
        login.setClickable(true);
        username.setEnabled(true);
        password.setEnabled(true);
        setProgressBar(View.GONE);
        Toast.makeText(this,errMsg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInvalidInput() {
        Toast.makeText(this,"用户名或密码不能为空",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStartRequest() {
        login.setClickable(false);
        username.setEnabled(false);
        password.setEnabled(false);
        setProgressBar(View.VISIBLE);
    }

    @Override
    public void setProgressBar(int visibility) {
        progressBar.setVisibility(visibility);
    }

    @OnClick(R.id.login)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.login:
                String usernameStr=username.getText().toString().trim();
                String passwordStr=password.getText().toString().trim();
                if(TextUtils.isEmpty(usernameStr) || TextUtils.isEmpty(passwordStr)){
                    onInvalidInput();
                    return;
                }
                mLoginPresenter.startRequest();
                passwordStr=new MD5().toMd5(passwordStr);
                mLoginPresenter.doLogin(usernameStr,passwordStr);
                break;
        }
    }
}
