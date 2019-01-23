package com.hugh.hughlotlin.module.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hugh.hughlotlin.di.Injectable


/**
 * 欢迎页
 * Created by {chenyouwei}
 * Date: {2019/1/22}
 */
abstract class BaseFragment<T : ViewDataBinding> : Fragment(),Injectable{

    /**
     * 根据Fragment动态清理和获取binding对象
     */

    var binding by autoCleared<T>()

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//      binding = DataBindingUtil.inflate(
//              inflater,
//              getLayoutId(),
//              container,
//              false,
//          HughDataBindingComponent()
//      )
//        onCreateView(binding?.root)
//        return binding?.root
//    }


    open fun actionOpenBrowser(){}

    open fun actionCopy(){}

    open fun actionShare(){

    }

    abstract fun onCreateView(mainView: View?)

    abstract fun getLayoutId(): Int

    /**
     * Navigation 页面跳转
     */
    fun navigationPopUpTo(view :View ,args: Bundle?,actionId: Int,finishTask:Boolean){

    }

}