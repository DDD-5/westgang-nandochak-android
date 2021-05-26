package kr.co.west_gang.nan_do_chak.util.dialog

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import kr.co.west_gang.nan_do_chak.R
import kr.co.west_gang.nan_do_chak.firebase.FirebaseCrashlyticsAccessor

/*
* Created by JJJoonngg
*/

abstract class BaseDialog : DialogFragment() {
    protected val contentView: View by lazy {
        View.inflate(context, R.layout.view_dialog_base, null)
    }

    @SuppressLint("ClickableViewAccessibility")
    protected var runAfterDecide = View.OnTouchListener { _, motionEvent ->
        if (motionEvent.action == MotionEvent.ACTION_UP) {
            Handler(Looper.getMainLooper()).postDelayed({
                dismiss()
            }, 10)
        }
        false
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val dialog = AlertDialog.Builder(it)
                .setView(contentView)
                .create()

            with(dialog.window!!) {
                requestFeature(Window.FEATURE_NO_TITLE)
                setBackgroundDrawableResource(R.drawable.ui_background_white_radius_8)
            }

            setTitle()
            setContent()
            setControlButtons()

            return dialog
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    @Suppress("DEPRECATION")
    override fun onResume() {
        super.onResume()
        dialog?.window?.let {
            val params: ViewGroup.LayoutParams = it.attributes ?: return
            val windowManager = activity?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                val windowMetrics = windowManager.currentWindowMetrics
                val windowInsets: WindowInsets = windowMetrics.windowInsets

                val insets = windowInsets.getInsetsIgnoringVisibility(
                    WindowInsets.Type.navigationBars() or WindowInsets.Type.displayCutout()
                )
                val insetsWidth = insets.right + insets.left
                val insetsHeight = insets.bottom + insets.top

                val bounds = windowMetrics.bounds
                params.width = ((bounds.width() - insetsWidth) * 0.8f).toInt()
                params.height = ViewGroup.LayoutParams.WRAP_CONTENT
            } else {
                val size = Point()
                val display = windowManager.defaultDisplay // deprecated in API 30
                display?.getSize(size) // deprecated in API 30
                params.width = (size.x * 0.8f).toInt()
                params.height = ViewGroup.LayoutParams.WRAP_CONTENT
            }

            it.attributes = params as WindowManager.LayoutParams
        }
    }

    override fun show(manager: FragmentManager, tag: String?) {
        try {
            val ft = manager.beginTransaction()
            ft.add(this, tag)
            ft.commitAllowingStateLoss()
        } catch (e: Exception) {
            FirebaseCrashlyticsAccessor.reportWithException(e)
        }
    }


    protected abstract fun setTitle()
    protected abstract fun setContent()
    protected abstract fun setControlButtons()
}