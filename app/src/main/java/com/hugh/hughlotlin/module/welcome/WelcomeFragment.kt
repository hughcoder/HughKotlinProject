package com.hugh.hughlotlin.module.welcome

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.View
import com.hugh.hughlotlin.R
import com.hugh.hughlotlin.common.utils.HughPreference
import com.hugh.hughlotlin.databinding.FragmentWelcomeBinding
import com.hugh.hughlotlin.model.AppGlobalModel
import com.hugh.hughlotlin.model.bean.User
import com.hugh.hughlotlin.model.conversion.UserConversion
import com.hugh.hughlotlin.model.net.GsonUtils
import com.hugh.hughlotlin.module.base.BaseFragment
import com.shuyu.github.kotlin.common.config.AppConfig
import kotlinx.android.synthetic.main.fragment_welcome.*
import javax.inject.Inject

/**
 * 欢迎页
 * Created by {chenyouwei}
 * Date: {2019/1/22}
 */
class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>(){

    private var userInfoStorage: String by HughPreference(AppConfig.USER_INFO,"")

    @Inject
    lateinit var appGlobalModel: AppGlobalModel

    /**
     *  委托属性，sharedpreference把取值和存值的操作代理给 accessTokenStoreage
     *  后续的赋值和取值最终是操作的pre得set 和 get函数
     */
    private var accessTokenStorage by HughPreference(AppConfig.ACCESS_TOKEN,"")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(mainView: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayoutId(): Int {
       return  R.layout.fragment_welcome
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //lottie动画速度
        welcome_animation.speed = 5.0f

        //两秒后跳转下一页
        Handler().postDelayed({},2000)
    }


    private fun goNext(view : View){
        if (accessTokenStorage.isEmpty()){
            ///去登陆页
            navigationPopUpTo(view,null,R.id.action_nav_wel_to_login,false)
        }else{
            if(userInfoStorage.isEmpty()){
                navigationPopUpTo(view,null,R.id.action_nav_wel_to_login,false)
            }else{
                //读取用户数据
                val user = GsonUtils.parserJsonToBean(userInfoStorage, User::class.java)
               // UserConversion.cloneDataFromUser(context,user,appGlobalModel.userObservable)
                //去主页
                navigationPopUpTo(view, null, R.id.action_nav_wel_to_main, true)
            }
        }
    }
}