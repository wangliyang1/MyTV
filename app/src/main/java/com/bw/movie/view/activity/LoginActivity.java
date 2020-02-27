package com.bw.movie.view.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.LoginContract;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.presenter.LoginPresenter;
import com.bw.movie.util.EncryptUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.LoginView {


    @BindView(R.id.login_phone)
    EditText loginPhone;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.login_check)
    CheckBox loginCheck;
    @BindView(R.id.login_register)
    Button loginRegister;
    @BindView(R.id.login_login)
    Button loginLogin;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected LoginPresenter provitePresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailure(Throwable throwable) {
        Toast.makeText(this, "失败"+throwable, Toast.LENGTH_SHORT).show();
    }


    @OnClick({R.id.login_register, R.id.login_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_register:
                break;
            case R.id.login_login:
                String email = loginPhone.getText().toString();
                String pwd = loginPwd.getText().toString();
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (TextUtils.isEmpty(pwd)){
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                String encrypt = EncryptUtil.encrypt(pwd);
                mPresenter.onGetLogin(email,encrypt);
                break;
        }
    }
}
