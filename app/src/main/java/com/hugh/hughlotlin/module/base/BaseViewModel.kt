package com.hugh.hughlotlin.module.base

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.hugh.hughlotlin.common.net.ResultCallBack


/**
 * 基类列表vm
 * Created by {chenyouwei}
 * Date: {2019/1/28}
 */
abstract class BaseViewModel (private val application: Application) : ViewModel(),ResultCallBack<ArrayList<Any>>{
    val dataList = MutableLiveData<ArrayList<Any>>()
    val loading = MutableLiveData<LoadState>()
    val needMore = MutableLiveData<Boolean>()

    var lastPage : Int = -1
    var page =1

    init {
        needMore.value = true
        loading.value = LoadState.NONE
        dataList.value = arrayListOf()
    }

    open fun refresh(){
        if(isLoading()){
            return
        }
        page = 1
        loading.value = LoadState.Refresh
        loadDataByRefresh()
    }

    open fun loadMore(){
        if(isLoading()){
            return
        }
        page ++
        loading.value = LoadState.LoadMore
        loadDataByLoadMore()
    }

    open fun completeLoadDate(){
        when(loading.value){
            LoadState.Refresh -> {
                loading.value = LoadState.RefreshDone
            }
            LoadState.LoadMore ->{
                loading.value = LoadState.LoadMoreDone
            }
            LoadState.NONE -> {
                loading.value = LoadState.NONE
            }
        }
    }

    open fun isLoading(): Boolean =
            loading.value == LoadState.Refresh && loading.value == LoadState.LoadMore

    abstract fun loadDataByRefresh()

    abstract fun loadDataByLoadMore()
}