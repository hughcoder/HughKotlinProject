package com.hugh.hughlotlin.module.base

import com.hugh.hughlotlin.HughApplication
import com.hugh.hughlotlin.repository.UserRepository

/**
 * 基础用户显示
 * Created by {chenyouwei}
 * Date: {2019/1/28}
 */

abstract class BaseUserInfoComponent<T:BaseUserInfoViewModel > : BaseListFragment <>(){}

abstract class BaseUserInfoViewModel constructor(private val userRepository: UserRepository,private val application: HughApplication) : BaseViewModel(application){

}

