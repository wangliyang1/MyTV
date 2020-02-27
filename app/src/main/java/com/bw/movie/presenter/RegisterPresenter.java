package com.bw.movie.presenter;

import android.view.View;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.contract.RegisterContract;
import com.bw.movie.model.RegisterModel;
import com.bw.movie.model.bean.EmailCodeBean;
import com.bw.movie.model.bean.RegisterBean;

public class RegisterPresenter extends BasePresenter<RegisterContract.RegisterView>implements RegisterContract.RegisterPresenter {

    private RegisterModel registerModel;

    @Override
    protected void initModel() {
        registerModel = new RegisterModel();
    }

    @Override
    public void onGetEmail(String email) {
        registerModel.onGetEmail(email, new RegisterContract.RegisterModel.RegisterModelCall() {
            @Override
            public void onRegisterSuccess(RegisterBean registerBean) {

            }

            @Override
            public void onRegisterFailure(Throwable throwable) {

            }

            @Override
            public void onEmailSuccess(EmailCodeBean emailCodeBean) {
                view.onEmailSuccess(emailCodeBean);
            }

            @Override
            public void onEmailFailure(Throwable throwable) {
                view.onEmailFailure(throwable);
            }
        });
    }

    @Override
    public void onGetRegister(String nickName, String pwd, String email, String code) {
        registerModel.onGetRegister(nickName, pwd, email, code, new RegisterContract.RegisterModel.RegisterModelCall() {
            @Override
            public void onRegisterSuccess(RegisterBean registerBean) {
                view.onRegisterSuccess(registerBean);
            }

            @Override
            public void onRegisterFailure(Throwable throwable) {
                view.onRegisterFailure(throwable);
            }

            @Override
            public void onEmailSuccess(EmailCodeBean emailCodeBean) {

            }

            @Override
            public void onEmailFailure(Throwable throwable) {

            }
        });
    }
}
