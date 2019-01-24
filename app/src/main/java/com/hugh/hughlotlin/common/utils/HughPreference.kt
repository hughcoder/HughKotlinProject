package com.hugh.hughlotlin.common.utils

import android.content.Context
import android.content.SharedPreferences
import com.hugh.hughlotlin.HughApplication
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 欢迎页
 * Created by {chenyouwei}
 * Date: {2019/1/23}
 */

class HughPreference<T>(private val keyname: String, private val default: T) {
    private val prefs: SharedPreferences by lazy { HughApplication.instance.getSharedPreferences(keyname, Context.MODE_PRIVATE) }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return getSharedPreferences(keyname, default)
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        return putSharedPreferences(keyname,value)
    }

    private fun putSharedPreferences(name: String, value: T) = with(prefs.edit()) {
        when (value) {
            is Long -> putLong(name, value)
            is String -> putString(name, value)
            is Int -> putInt(name, value)
            is Boolean -> putBoolean(name, value)
            is Float -> putFloat(name, value)
            else -> throw java.lang.IllegalArgumentException("Type Error, cannot be saved")
        }.apply()
    }


    @Suppress("UNCHECKED_CAST")
    private fun getSharedPreferences(name: String, default: T): T = with(prefs) {
        val res: Any = when (default) {
            is Long -> getLong(name, default)
            is String -> getString(name, default)
            is Int -> getInt(name, default)
            is Boolean -> getBoolean(name, default)
            is Float -> getFloat(name, default)
            else -> throw IllegalArgumentException("Type Error, cannot be saved!")
        }
        return res as T
    }
}