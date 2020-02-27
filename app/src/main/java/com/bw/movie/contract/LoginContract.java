package com.bw.movie.contract;

import com.bw.movie.model.bean.LoginBean;

public interface LoginContract {
    interface LoginView{
        void onLoginSuccess(LoginBean loginBean);
        void onLoginFailure(Throwable throwable);
    }
    interface LoginPresenter{
        void onGetLogin(String email,String pwd);
    }
    interface LoginModel{
        void onGetLogin(String email,String pwd,LoginModelCall loginModelCall);
        interface LoginModelCall{
            void onLoginSuccess(LoginBean loginBean);
            void onLoginFailure(Throwable throwable);
        }
    }
}
