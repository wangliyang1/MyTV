package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.LoginContract;
import com.bw.movie.model.LoginModel;
import com.bw.movie.model.bean.LoginBean;

public class LoginPresenter extends BasePresenter<LoginContract.LoginView>implements LoginContract.LoginPresenter {

    private LoginModel loginModel;

    @Override
    protected void initModel() {
        loginModel = new LoginModel();
    }

    @Override
    public void onGetLogin(String email, String pwd) {
        loginModel.onGetLogin(email, pwd, new LoginContract.LoginModel.LoginModelCall() {
            @Override
            public void onLoginSuccess(LoginBean loginBean) {
                view.onLoginSuccess(loginBean);
            }

            @Override
            public void onLoginFailure(Throwable throwable) {
                view.onLoginFailure(throwable);
            }
        });
    }
}
