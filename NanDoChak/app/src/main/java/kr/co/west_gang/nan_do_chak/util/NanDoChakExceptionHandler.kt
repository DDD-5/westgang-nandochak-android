package kr.co.west_gang.nan_do_chak.util

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Bundle
import kr.co.west_gang.nan_do_chak.util.AppConfig.UNCAUGHT_EXCEPTION
import kr.co.west_gang.nan_do_chak.view.errorpage.ErrorPageActivity
import java.io.PrintWriter
import java.io.StringWriter

/*
* Created by JJJoonngg
*/

class NanDoChakExceptionHandler(
    application: Application,
    private val defaultExceptionHandler: Thread.UncaughtExceptionHandler?
) : Thread.UncaughtExceptionHandler {

    private var lastActivity: Activity? = null
    private lateinit var bundle: Bundle
    private var activityCount = 0

    init {
        application.registerActivityLifecycleCallbacks(
            object : Application.ActivityLifecycleCallbacks {
                override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                    if (savedInstanceState != null) {
                        bundle = savedInstanceState
                    }
                    lastActivity = activity
                }

                override fun onActivityStarted(activity: Activity) {
                    activityCount++
                    lastActivity = activity
                }

                override fun onActivityStopped(activity: Activity) {
                    activityCount--
                    if (activityCount < 0) {
                        lastActivity = null
                    }
                }

                override fun onActivityResumed(activity: Activity) = Unit

                override fun onActivityPaused(activity: Activity) = Unit

                override fun onActivityDestroyed(activity: Activity) = Unit

                override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) = Unit
            }
        )
    }

    override fun uncaughtException(thread: Thread, throwable: Throwable) {
        val stringWriter = StringWriter()
        throwable.printStackTrace(PrintWriter(stringWriter))

        lastActivity?.run {
            val errorString = stringWriter.toString()
            logE(errorString)
            restartActivity(errorString, this)
        } ?: defaultExceptionHandler?.uncaughtException(thread, throwable)
    }

    private fun restartActivity(error: String, activity: Activity) {
        activity.run {
            val restartIntent = Intent(this, ErrorPageActivity::class.java).apply {
                putExtra(UNCAUGHT_EXCEPTION, error)
            }
            finish()
            startActivity(restartIntent)
        }
    }

}