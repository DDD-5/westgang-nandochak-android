package kr.co.west_gang.nan_do_chak.util.dialog

import android.view.View
import kotlinx.android.synthetic.main.view_dialog_base.view.*

/*
* Created by JJJoonngg
*/

abstract class NeutralDialog : BaseDialog() {
    private var titleId: Int = 0
    private var contentId: Int = 0

    private var onNeutralButtonClick: View.OnClickListener? = null

    fun setTitle(resourceId: Int) {
        titleId = resourceId
    }

    fun setContent(resourceId: Int) {
        contentId = resourceId
    }

    fun setNeutralButton(listener: View.OnClickListener) {
        onNeutralButtonClick = listener
    }

    override fun setTitle() {
        contentView.dialogTitleText.setText(titleId)
    }

    override fun setContent() {
        contentView.dialogContentText.setText(contentId)
    }

    override fun setControlButtons() {
        with(contentView) {
            dialogOkayButton.visibility = View.GONE
            dialogCancelButton.visibility = View.GONE

            dialogNeutralButton.visibility = View.VISIBLE
            dialogNeutralButton.setOnTouchListener(runAfterDecide)
            dialogNeutralButton.setOnClickListener { onNeutralButtonClick }

            dialogCloseButton.setOnTouchListener(runAfterDecide)
            dialogCloseButton.setOnClickListener { dismiss() }
        }
    }
}
