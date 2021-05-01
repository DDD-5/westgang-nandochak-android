package kr.co.west_gang.nan_do_chak.util

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Bundle
import kr.co.west_gang.nan_do_chak.view.main.MainActivity
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
            //TODO : If you when report Exception log or the other, print or report Error here
            logE(stringWriter.toString())
            restartActivity(this)
        } ?: defaultExceptionHandler?.uncaughtException(thread, throwable)
    }

    private fun restartActivity(activity: Activity) {
        activity.run {
            //TODO : Change Activity which you want to show activity when exception caught
            val restartIntent = Intent(this, MainActivity::class.java)
            finish()
            startActivity(restartIntent)
        }
    }

}