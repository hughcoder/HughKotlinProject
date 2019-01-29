package com.hugh.hughlotlin.ui.holder

import android.content.Context
import android.databinding.ViewDataBinding
import android.view.View
import com.hugh.hughlotlin.R
import com.hugh.hughlotlin.databinding.LayoutEmptyBinding
import com.hugh.hughlotlin.model.ui.EmptyUIModel
import com.hugh.hughlotlin.ui.holder.base.DataBindingHolder

/**
 * 欢迎页
 * Created by {chenyouwei}
 * Date: {2019/1/29}
 */

class EmptyHolder(context: Context,private val v:View,dataBing:ViewDataBinding) : DataBindingHolder<EmptyUIModel, LayoutEmptyBinding>(context,v,dataBing){

    override fun createView(v: View) {
        super.createView(v)
    }

    override fun onBind(model: EmptyUIModel, position: Int, dataBing: LayoutEmptyBinding) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // 伴生对象 ，类内部的对象声明可以用 companion 关键字标记：
    companion object {
        const val ID = R.layout.layout_empty
    }

}