package kr.co.west_gang.nan_do_chak.architecture

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner

/*
* Created by JJJoonngg
*/

abstract class BaseCustomView<T : ViewDataBinding>(
    context: Context,
    attributeSet: AttributeSet? = null
) : ConstraintLayout(context, attributeSet) {

    abstract val layoutResourceId: Int
    private val lifecycleOwner by lazy { context as LifecycleOwner }

    protected val binding: T by lazy {
        DataBindingUtil.inflate(
            LayoutInflater.from(context), layoutResourceId, this, true
        ) as T
    }

    open fun initDataBinding() {
        binding.lifecycleOwner = lifecycleOwner
    }
}