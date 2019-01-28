package com.hugh.hughlotlin.module.base

import android.databinding.ViewDataBinding
import android.widget.AdapterView
import com.shuyu.commonrecycler.listener.OnItemClickListener
import com.shuyu.commonrecycler.listener.OnLoadingListener

/**
 * 基础列表
 * Created by {chenyouwei}
 * Date: {2019/1/28}
 */
abstract class  BaseListFragment<T : ViewDataBinding,R : BaseViewModel> : BaseFragment<T>(), OnItemClickListener, OnLoadingListener{

}