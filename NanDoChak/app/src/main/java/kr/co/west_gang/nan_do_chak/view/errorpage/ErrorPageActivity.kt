package kr.co.west_gang.nan_do_chak.view.errorpage

import android.os.Bundle
import kr.co.west_gang.nan_do_chak.R
import kr.co.west_gang.nan_do_chak.architecture.BaseActivity
import kr.co.west_gang.nan_do_chak.databinding.ActivityErrorPageBinding
import kr.co.west_gang.nan_do_chak.firebase.FirebaseCrashlyticsAccessor
import kr.co.west_gang.nan_do_chak.util.AppConfig.UNCAUGHT_EXCEPTION

class ErrorPageActivity : BaseActivity() {

    private val binding by binding<ActivityErrorPageBinding>(R.layout.activity_error_page)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this

        intent.getStringExtra(UNCAUGHT_EXCEPTION)?.let {
            val exception = Exception(it)
            FirebaseCrashlyticsAccessor.reportWithException(exception)
        }
    }
}