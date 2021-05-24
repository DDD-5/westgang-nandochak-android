package kr.co.west_gang.nan_do_chak.util.dialog

import android.view.View
import kotlinx.android.synthetic.main.view_dialog_base.view.*

/*
* Created by JJJoonngg
*/

abstract class ConfirmAndCancelDialog : BaseDialog() {
    private var titleId: Int = 0
    private var contentId: Int = 0

    private var onOkayButtonClick: View.OnClickListener? = null
    private var onCancelButtonClick: View.OnClickListener? = null

    fun setTitle(resourceId: Int) {
        titleId = resourceId
    }

    fun setContent(resourceId: Int) {
        contentId = resourceId
    }

    fun setOkayButton(listener: View.OnClickListener) {
        onOkayButtonClick = listener
    }

    fun setCancelButton(listener: View.OnClickListener) {
        onCancelButtonClick = listener
    }

    override fun setTitle() {
        contentView.dialogTitleText.setText(titleId)
    }

    override fun setContent() {
        contentView.dialogContentText.setText(contentId)
    }

    override fun setControlButtons() {
        with(contentView) {
            dialogOkayButton.visibility = View.VISIBLE
            dialogOkayButton.setOnTouchListener(runAfterDecide)
            dialogOkayButton.setOnClickListener { onOkayButtonClick }

            dialogCancelButton.visibility = View.VISIBLE
            dialogCancelButton.setOnTouchListener(runAfterDecide)
            dialogCancelButton.setOnClickListener { onCancelButtonClick }


            dialogCloseButton.setOnTouchListener(runAfterDecide)
            dialogCloseButton.setOnClickListener { dismiss() }

            dialogNeutralButton.visibility = View.GONE
        }
    }
}