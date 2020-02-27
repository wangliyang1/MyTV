package com.bw.movie.view.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.contract.RegisterContract;
import com.bw.movie.model.bean.EmailCodeBean;
import com.bw.movie.model.bean.RegisterBean;
import com.bw.movie.presenter.RegisterPresenter;
import com.bw.movie.util.EncryptUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.RegisterView {


    @BindView(R.id.register_name)
    EditText registerName;
    @BindView(R.id.register_pwd)
    EditText registerPwd;
    @BindView(R.id.register_email)
    EditText registerEmail;
    @BindView(R.id.register_send)
    Button registerSend;
    @BindView(R.id.register_code)
    EditText registerCode;
    @BindView(R.id.register_button)
    Button registerButton;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected RegisterPresenter provitePresenter() {
        return new RegisterPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void onRegisterSuccess(RegisterBean registerBean) {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterFailure(Throwable throwable) {
        Toast.makeText(this, "注册失败"+throwable, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmailSuccess(EmailCodeBean emailCodeBean) {
        Toast.makeText(this, "邮箱发送成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmailFailure(Throwable throwable) {
        Toast.makeText(this, "邮箱发送失败", Toast.LENGTH_SHORT).show();
    }


    @OnClick({R.id.register_send, R.id.register_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_send:
                String email = registerEmail.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                mPresenter.onGetEmail(email);
                break;
            case R.id.register_button:
                String name = registerName.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(this, "名字不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String pwd = registerPwd.getText().toString();
                String encrypt = EncryptUtil.encrypt(pwd);
                if (TextUtils.isEmpty(pwd)) {
                    Toast.makeText(this, "姓名不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String email1 = registerEmail.getText().toString();
                if (TextUtils.isEmpty(email1)) {
                    Toast.makeText(this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String code = registerCode.getText().toString();
                if (TextUtils.isEmpty(code)) {
                    Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                mPresenter.onGetRegister(name,encrypt,email1,code);
                break;
        }
    }
}
