package com.hugh.hughlotlin.module.login

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.databinding.ObservableField
import com.hugh.hughlotlin.common.utils.HughPreference
import com.hugh.hughlotlin.repository.LoginRepository
import com.shuyu.github.kotlin.common.config.AppConfig
import javax.inject.Inject

/**
 * 登陆模块的vm
 * Created by {chenyouwei}
 * Date: {2019/1/24}
 */
class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository):ViewModel(){

    private var usernameStorage : String by HughPreference(AppConfig.USER_NAME,"")

    private var passwordStorage : String by HughPreference(AppConfig.PASSWORD,"")

    /**
     * 用户名
     */
    val  username = ObservableField<String>()

    /**
     * 密码
     */
    val password = ObservableField<String>()

    /**
     * login result
     */
    val loginResult = MutableLiveData<Boolean>()

    init {
        //读取本地存储的用户名和密码
        username.set(usernameStorage)
        password.set(passwordStorage)
    }

    /**
     *
     */
    fun login(context: Context){
        loginRepository
    }
}
