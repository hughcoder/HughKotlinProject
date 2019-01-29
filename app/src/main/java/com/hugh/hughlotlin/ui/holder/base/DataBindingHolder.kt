package com.hugh.hughlotlin.ui.holder.base

import android.content.Context
import android.databinding.ViewDataBinding
import android.view.View
import com.shuyu.commonrecycler.BindRecyclerBaseHolder

/**
 * 欢迎页
 * Created by {chenyouwei}
 * Date: {2019/1/29}
 */

abstract class DataBindingHolder<T, D>(context: Context, v: View, private val dataBing: ViewDataBinding) : BindRecyclerBaseHolder(context, v) {

    override fun createView(v: View) {

    }

    @Suppress("UNCHECKED_CAST")
    override fun onBind(model: Any, position: Int) {
        onBind(model as T, position, dataBing as D)
    }

    abstract fun onBind(model: T, position: Int, dataBing: D)
}