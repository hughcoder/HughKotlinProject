package com.hugh.hughlotlin.service

import io.reactivex.Observable
import com.hugh.hughlotlin.model.bean.AccessToken
import com.hugh.hughlotlin.model.bean.LoginRequestModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


/**
 * 欢迎页
 * Created by {chenyouwei}
 * Date: {2019/1/25}
 */

// 登陆服务

interface LoginService{
    @POST("authorizations")
    @Headers("Accept:application/json")
    fun authorizations(@Body authRequestModel: LoginRequestModel): Observable<Response<AccessToken>>
}