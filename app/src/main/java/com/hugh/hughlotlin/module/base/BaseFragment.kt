package com.hugh.hughlotlin.module.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.hugh.hughlotlin.di.Injectable



/**
 * 欢迎页
 * Created by {chenyouwei}
 * Date: {2019/1/22}
 */
abstract class BaseFragment<T : ViewDataBinding> : Fragment(), Injectable {

    /**
     * 根据Fragment动态清理和获取binding对象
     */

    var binding by autoCleared<T>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        binding = DataBindingUtil.inflate(
//                inflater,
//                getLayoutId(),
//                container,
//                false,
//                HughDataBindingComponent()
//        )
        onCreateView(binding?.root)
        return binding?.root
    }


    open fun actionOpenBrowser() {}

    open fun actionCopy() {}

    open fun actionShare() {

    }

    abstract fun onCreateView(mainView: View?)

    abstract fun getLayoutId(): Int

    /**
     * Navigation 页面跳转
     */
    fun navigationPopUpTo(view: View, args: Bundle?, actionId: Int, finishTask: Boolean) {
        val controller = Navigation.findNavController(view) //这个方法将定位与这个视图关联的
        controller.navigate(actionId, args, NavOptions.Builder().setPopUpTo(controller.graph.id, true).build())
        if (finishTask) {
            activity?.finish() // ？先做null检查，不为空的话在执行
        }
    }

    fun enterFull() {
        //不显示状态栏
        activity?.window?.setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
    }


    fun exitFull() {
        activity?.window?.setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
    }


}