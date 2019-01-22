package com.hugh.hughlotlin

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * 欢迎页
 * Created by {chenyouwei}
 * Date: {2019/1/22}
 */

class StartNavigationActivity : AppCompatActivity(),HasSupportFragmentInjector{

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
  //  一是用来标记需要依赖的变量，以此告诉Dagger2为它提供依赖；
    // 二是用来标记构造函数，Dagger2通过@Inject注解可以在需要这个类实例的时候来找到这个构造函数并把相关实例构造出来，以此来为被@Inject标记了的变量提供依赖，

    override fun supportFragmentInjector() = dispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.primaryNavigationFragment
      //  if(fragment is ){}
        super.onBackPressed()
    }


}