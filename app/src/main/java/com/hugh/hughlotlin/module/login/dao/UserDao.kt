package com.hugh.hughlotlin.module.login.dao

import com.hugh.hughlotlin.HughApplication
import com.hugh.hughlotlin.model.bean.Event
import retrofit2.Response
import java.net.CacheResponse
import javax.inject.Inject

/**
 * 欢迎页
 * Created by {chenyouwei}
 * Date: {2019/1/24}
 */

class UserDao @Inject constructor(private val application: HughApplication){

    /**
     *  保存当前用户接收到的事件
     */

    fun saveReceivedRcentDao(response: Response<ArrayList<Event>>,needSave:Boolean){

    }
}