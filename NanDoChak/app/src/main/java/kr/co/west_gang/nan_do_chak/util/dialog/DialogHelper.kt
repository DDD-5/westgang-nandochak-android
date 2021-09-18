package kr.co.west_gang.nan_do_chak.util.dialog

import android.content.Context
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import kr.co.west_gang.nan_do_chak.R

/*
* Created by JJJoonngg
*/

fun showNetworkNotAvailableDialog(context: Context) {
    val fragmentManager: FragmentManager =
        (context as FragmentActivity).supportFragmentManager
    val listener = View.OnClickListener { }
    NeutralDialog().apply {
        setTitle(R.string.network_not_available_title)
        setContent(R.string.network_not_available_content)
        setNeutralButton(listener)
    }.also {
        it.show(fragmentManager, "Network Available")
    }
}