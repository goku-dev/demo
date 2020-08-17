package com.techja.demokotlin

import java.text.SimpleDateFormat
import java.util.*

object CommonUtils {
    val DATE_FULL: String = "dd/MM/yyy"
    val DATE_FULL_TIME: String = "dd/MM/yyy hh:mm:ss"


    fun getDateNow(t: String): String {
        var simpleDateFormat:SimpleDateFormat= SimpleDateFormat(t)
        return simpleDateFormat.format(Date())
    }
}