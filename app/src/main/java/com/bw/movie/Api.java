package com.bw.movie;


import com.bw.movie.model.bean.EmailCodeBean;
import com.bw.movie.model.bean.LoginBean;
import com.bw.movie.model.bean.RegisterBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("v2/login")
    Observable<LoginBean> login(@Field("email")String email,@Field("pwd")String pwd);

    @FormUrlEncoded
    @POST("v2/sendOutEmailCode")
    Observable<EmailCodeBean> emailcode(@Field("email")String email);

    @FormUrlEncoded
    @POST("v2/register")
    Observable<RegisterBean> register(@Field("nickName")String nickName,
                                      @Field("pwd")String pwd,
                                      @Field("email")String email,
                                      @Field("code")String code);
}
