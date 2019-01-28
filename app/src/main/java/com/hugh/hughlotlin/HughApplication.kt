package com.hugh.hughlotlin

import android.app.Activity
import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.hugh.hughlotlin.common.style.CYWIconfont
import com.mikepenz.iconics.Iconics
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * 欢迎页
 * Created by {chenyouwei}
 * Date: {2019/1/22}
 */

class HughApplication : Application(), HasActivityInjector {

    companion object {
        var instance: HughApplication by Delegates.notNull()
    }

    /**
     * 分发Activity的注入
     */
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
//新增了一个针对 lateinit 标记的变量的判断，判断变量是否已经完成初始化

    override fun activityInjector(): AndroidInjector<Activity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        //初始化路由
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)

        //Application级别注入
       // AppInjector.init()

        ///初始化图标库
        Iconics.init(applicationContext)
        Iconics.registerFont(CYWIconfont())
    }
}