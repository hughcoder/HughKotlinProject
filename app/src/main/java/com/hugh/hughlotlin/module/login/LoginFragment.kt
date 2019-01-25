package com.hugh.hughlotlin.module.login

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import com.hugh.hughlotlin.R
import com.hugh.hughlotlin.databinding.FragmentLoginBinding
import com.hugh.hughlotlin.module.base.BaseFragment
import javax.inject.Inject

/**
 * 欢迎页
 * Created by {chenyouwei}
 * Date: {2019/1/24}
 */

class LoginFragment:BaseFragment<FragmentLoginBinding>(){

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory  //延迟初始化属性与变量

    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        exitFull()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(mainView: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(LoginViewModel::class.java)


    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_login
    }
}