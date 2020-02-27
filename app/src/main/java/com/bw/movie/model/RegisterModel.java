package com.bw.movie.model;

import com.bw.movie.contract.RegisterContract;
import com.bw.movie.model.bean.EmailCodeBean;
import com.bw.movie.model.bean.RegisterBean;
import com.bw.movie.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RegisterModel implements RegisterContract.RegisterModel {
    @Override
    public void onGetEmail(String email, RegisterModelCall registerModelCall) {
        NetUtil.getInstance().getApi().emailcode(email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<EmailCodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(EmailCodeBean emailCodeBean) {
                        registerModelCall.onEmailSuccess(emailCodeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        registerModelCall.onEmailFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onGetRegister(String nickName, String pwd, String email, String code, RegisterModelCall registerModelCall) {
        NetUtil.getInstance().getApi().register(nickName,pwd,email,code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        if ("0000".equals(registerBean.getStatus())){
                            registerModelCall.onRegisterSuccess(registerBean);
                        }else {
                            registerModelCall.onRegisterFailure(new Exception(registerBean.getMessage()));
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        registerModelCall.onRegisterFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
