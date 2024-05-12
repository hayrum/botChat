package com.example.botmessages.utils

import android.annotation.SuppressLint
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

/**
 * This class is used to get the current time
 */
object Time {

    @SuppressLint("SimpleDateFormat")
    fun timeStamp(): String {
        val timeStamps = Timestamp(System.currentTimeMillis())
        val sdf = SimpleDateFormat("HH:mm")
        val time = sdf.format(Date(timeStamps.time))
        return time.toString()
    }
}