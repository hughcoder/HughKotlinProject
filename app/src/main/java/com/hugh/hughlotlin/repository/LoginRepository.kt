package com.hugh.hughlotlin.repository

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.content.Context
import android.util.Base64
import com.hugh.hughlotlin.common.utils.Debuger
import com.hugh.hughlotlin.common.utils.HughPreference
import com.shuyu.github.kotlin.common.config.AppConfig
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * 登陆数据仓库对象
 * Created by {chenyouwei}
 * Date: {2019/1/24}
 */

class LoginRepository @Inject constructor(private val retrofit: Retrofit, private val userRepository: UserRepository) {

    private var usernameStorage: String by HughPreference(AppConfig.USER_NAME, "")

    private var passwordStorage: String by HughPreference(AppConfig.PASSWORD, "")

    private var accessTokenStorage: String by HughPreference(AppConfig.ACCESS_TOKEN, "")

    private var userBasicCodeStorage: String by HughPreference(AppConfig.USER_BASIC_CODE, "")

    private var userInfoStorage: String by HughPreference(AppConfig.USER_INFO, "")


    /**
     * 获取token
     */
    fun getTokenObservable(): Observer<String>{
    return retrofit.create()
    }

    /**
     * 登陆
     */
    fun login(context: Context, username: String, password: String, token: MutableLiveData<Boolean>) {
        clearTokenStorage()
        val type = "$username:$password"
        val base64 = Base64.encodeToString(type.toByteArray(), Base64.NO_WRAP).replace("\\+", "%2B")

        Debuger.printfLog("base64Str login $base64")
        usernameStorage = username
        userBasicCodeStorage =base64

        val loginService =
    }


    /**
     * 清除token
     */
    fun clearTokenStorage() {
        accessTokenStorage = ""
        userBasicCodeStorage = ""
    }
}