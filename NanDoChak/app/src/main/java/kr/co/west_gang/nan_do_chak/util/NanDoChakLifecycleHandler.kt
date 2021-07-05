package kr.co.west_gang.nan_do_chak.util

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import kr.co.west_gang.nan_do_chak.R
import kr.co.west_gang.nan_do_chak.util.dialog.NeutralDialog

/*
* Created by JJJoonngg
*/

class NanDoChakLifecycleHandler(application: Application) {
    init {
        application.registerActivityLifecycleCallbacks(
            object : Application.ActivityLifecycleCallbacks {
                override fun onActivityPaused(activity: Activity) = Unit

                override fun onActivityStarted(activity: Activity) = Unit

                override fun onActivityDestroyed(activity: Activity) = Unit

                override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) =
                    Unit

                override fun onActivityStopped(activity: Activity) = Unit

                override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) =
                    Unit

                override fun onActivityResumed(activity: Activity) {
                    if (!NanDoChakApplication.isOnline()) {
                        val fragmentManager: FragmentManager =
                            (activity as FragmentActivity).supportFragmentManager
                        val listener = View.OnClickListener { }

                        NeutralDialog().apply {
                            setTitle(R.string.network_not_available_title)
                            setContent(R.string.network_not_available_content)
                            setNeutralButton(listener)
                        }.also {
                            it.show(fragmentManager, "Network Available")
                        }
                    }
                }

            }
        )
    }
}