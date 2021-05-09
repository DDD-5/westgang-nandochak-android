package kr.co.west_gang.nan_do_chak.util

import android.app.Application
import android.content.Context
import android.graphics.Typeface
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import dagger.hilt.android.HiltAndroidApp

/*
* Created by JJJoonngg
*/

@HiltAndroidApp
class NanDoChakApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        context = applicationContext

        /**
         * Logger
         * showThreadInfo(true) = Thread showing or not showing
         * methodCount = print line , default 2
         * methodOffset = method offset, default 5
         * logStrategy = logStrategy change, default logcat
         * tag = Global Tag, default PRETTY_LOGGER
         */
        Logger.addLogAdapter(object : AndroidLogAdapter(
            PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)
                .methodCount(3)
                .methodOffset(3)
                .tag("App")
                .build()
        ) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return AppConfig.isDebugMode
            }
        })

        if (!AppConfig.isDebugMode) {
            setCrashHandler()
        }
    }

    private fun setCrashHandler() {
        Thread.setDefaultUncaughtExceptionHandler(
            NanDoChakExceptionHandler(this, Thread.getDefaultUncaughtExceptionHandler())
        )
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