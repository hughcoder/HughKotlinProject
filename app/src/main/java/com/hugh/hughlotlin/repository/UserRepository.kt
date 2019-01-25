package com.hugh.hughlotlin.repository

import com.google.gson.Gson
import com.hugh.hughlotlin.HughApplication
import com.hugh.hughlotlin.common.net.FlatMapResponse2Result
import com.hugh.hughlotlin.common.net.GsonUtils
import com.hugh.hughlotlin.common.net.PageInfo
import com.hugh.hughlotlin.common.utils.HughPreference
import com.hugh.hughlotlin.model.AppGlobalModel
import com.hugh.hughlotlin.model.bean.User
import com.hugh.hughlotlin.module.login.dao.UserDao
import com.hugh.hughlotlin.service.RepoService
import com.hugh.hughlotlin.service.UserService
import com.shuyu.github.kotlin.common.config.AppConfig
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * 欢迎页
 * Created by {chenyouwei}
 * Date: {2019/1/25}
 */
class UserRepository @Inject constructor(private val retrofit: Retrofit, private val appGlobalModel: AppGlobalModel,
                                         private val application: HughApplication, private val userDao: UserDao) {
    /**
     * 登陆用户的sharedPreference
     */
    private var userInfoStorage: String by HughPreference(AppConfig.USER_INFO, "")

    /**
     * 获取用户详细信息
     */
    fun getPersonInfoObservable(userName: String? = null): Observable<User> {
        val isLoginUser = userName == null
        val userService = if (isLoginUser) {
            retrofit.create(UserService::class.java).getPersonInfo(true)
        } else {
            retrofit.create(UserService::class.java).getUser(true, userName!!)
        }

    }

    /**
     * 用户数据请求、组装、保存
     */
    private fun doUserInfoFlat(service: Observable<Response<User>>, isLoginUser: Boolean): Observable<User> {
        return service.flatMap {
            FlatMapResponse2Result(it)
        }.flatMap {
            //获取用户的star数
            val starredService = retrofit.create(RepoService::class.java).getStarredRepos(true,it.login!!,1,"updated",1)
            val hononrService = retrofit.create(RepoService::class.java).getUserRepository100StatusDao(true,it.login!!,1)
            val starResponse = starredService.blockingSingle()
            val honorResponse = hononrService.blockingSingle()
            val starPageString = starResponse.headers().get("page_info")
            if(starPageString !=null){
                val pageInfo = GsonUtils.parserJsonToBean(starPageString, PageInfo::class.java)
            }
            Observable.just(it)
        }.doOnNext {

        }
    }

}