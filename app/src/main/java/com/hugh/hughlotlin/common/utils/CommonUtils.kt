package com.hugh.hughlotlin.common.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * 欢迎页
 * Created by {chenyouwei}
 * Date: {2019/1/24}
 */

object CommonUtils {

    fun getDateStr(date: Date?): String {
        if (date?.toString() == null) {
            return ""
        } else if (date.toString().length < 10) {
            return date.toString()
        }
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(date).substring(0, 10)
    }


}