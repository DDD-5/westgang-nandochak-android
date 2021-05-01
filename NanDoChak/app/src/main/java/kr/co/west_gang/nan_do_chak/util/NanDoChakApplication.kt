package kr.co.west_gang.nan_do_chak.util

import android.app.Application
import android.content.Context
import android.graphics.Typeface
import dagger.hilt.android.HiltAndroidApp

/*
* Created by JJJoonngg
*/

@HiltAndroidApp
class NanDoChakApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object {

        private lateinit var context: Context

        fun getAppContext() = context
        fun getColor(resId: Int): Int = context.getColor(resId)
        fun getString(resId: Int): String = context.resources.getString(resId)
        fun getBoolean(resId: Int): Boolean = context.resources.getBoolean(resId)
        fun getInt(resId: Int): Int = context.resources.getInteger(resId)
        fun getFont(resId: Int): Typeface = context.resources.getFont(resId)
        fun getStringArray(resId: Int): Array<String> = context.resources.getStringArray(resId)
    }
}