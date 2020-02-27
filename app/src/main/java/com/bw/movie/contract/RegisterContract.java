package com.bw.movie.contract;

import com.bw.movie.model.bean.EmailCodeBean;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.bean.RegisterBean;

public interface RegisterContract {
    interface RegisterView{
        void onRegisterSuccess(RegisterBean registerBean);
        void onRegisterFailure(Throwable throwable);

        void onEmailSuccess(EmailCodeBean emailCodeBean);
        void onEmailFailure(Throwable throwable);
    }
    interface RegisterPresenter{
        void onGetEmail(String email);
        void onGetRegister(String nickName, String pwd,String email,String code);
    }
    interface RegisterModel{
        void onGetEmail(String email,RegisterModelCall registerModelCall);
        void onGetRegister(String nickName, String pwd,String email,String code, RegisterModelCall registerModelCall);
        interface RegisterModelCall{
            void onRegisterSuccess(RegisterBean registerBean);
            void onRegisterFailure(Throwable throwable);
            void onEmailSuccess(EmailCodeBean emailCodeBean);
            void onEmailFailure(Throwable throwable);
        }
    }
}
