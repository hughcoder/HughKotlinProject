package com.hugh.hughlotlin.module.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.support.v4.app.Fragment
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 欢迎页
 * Created by {chenyouwei}
 * Date: {2019/1/22}
 */

class AutoCleardValue<T : Any?>(val fragment: Fragment) : ReadWriteProperty<Fragment,T?>{

    private var _value: T? = null
    init {
        fragment.lifecycle.addObserver(object : LifecycleObserver{
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy(){
                _value = null
            }
        })
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T? {
        return _value
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setValue(thisRef: Fragment, property: KProperty<*>, value: T?) {
        _value = value
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

fun <T : Any?> Fragment.autoCleared() = AutoCleardValue<T?>(this)