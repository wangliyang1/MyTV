package com.bw.movie.model;

import com.bw.movie.contract.LoginContract;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginModel implements LoginContract.LoginModel {
    @Override
    public void onGetLogin(String email, String pwd, LoginModelCall loginModelCall) {
        NetUtil.getInstance().getApi().login(email,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        loginModelCall.onLoginSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        loginModelCall.onLoginFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
