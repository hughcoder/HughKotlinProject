package com.hugh.hughlotlin.repository

import com.hugh.hughlotlin.HughApplication
import com.hugh.hughlotlin.common.utils.HughPreference
import com.hugh.hughlotlin.model.AppGlobalModel
import com.hugh.hughlotlin.module.login.dao.UserDao
import com.shuyu.github.kotlin.common.config.AppConfig
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * 欢迎页
 * Created by {chenyouwei}
 * Date: {2019/1/25}
 */
class UserRepository @Inject constructor(private val retrofit: Retrofit,private val appGlobalModel:AppGlobalModel,
                                         private val application: HughApplication,private val userDao: UserDao){
    /**
     * 登陆用户的sharedPreference
     */
    private var userInfoStorage : String by HughPreference(AppConfig.USER_INFO,"")

    /**
     * 获取用户详细信息
     */

}