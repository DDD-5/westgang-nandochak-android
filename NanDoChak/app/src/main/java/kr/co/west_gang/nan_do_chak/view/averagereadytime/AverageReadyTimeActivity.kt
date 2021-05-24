package kr.co.west_gang.nan_do_chak.view.averagereadytime

import android.content.Intent
import android.os.Bundle
import android.widget.NumberPicker
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kr.co.west_gang.nan_do_chak.R
import kr.co.west_gang.nan_do_chak.architecture.BaseActivity
import kr.co.west_gang.nan_do_chak.databinding.ActivityAverageReadyTimeBinding
import kr.co.west_gang.nan_do_chak.util.AppConfig
import kr.co.west_gang.nan_do_chak.util.logD
import kr.co.west_gang.nan_do_chak.view.earlyarrivedtime.EarlyArrivedTimeActivity

class AverageReadyTimeActivity : BaseActivity() {

    private val binding by binding<ActivityAverageReadyTimeBinding>(R.layout.activity_average_ready_time)
    private val viewModel: AverageReadyTimeViewModel by viewModels()

    private var isFromSignUp = false
    private var nickName: String? = null
    private lateinit var startForResult: ActivityResultLauncher<Intent>

    private fun NumberPicker.formatter() = this.setFormatter { i -> String.format("%02d", i) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        
        startForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == AppConfig.ACTIVITY_RESULT_SIGN_UP) {
                    setResult(AppConfig.ACTIVITY_RESULT_SIGN_UP)
                    finish()
                }
            }


        logD(AppConfig.TAG_DEBUG, "AverageReadyTime Activity onCreate")

        isFromSignUp = intent.extras?.get(AppConfig.INTENT_PARAM_FLAG_FROM_SIGN_UP) as Boolean
        nickName = intent.extras?.get(AppConfig.INTENT_PARAM_NICK_NAME)?.toString()

        initNumberPicker()
        initUserNickName()
        observeLiveData()
    }

    private fun initNumberPicker() {
        with(binding) {
            averageReadyTimeHoursPicker.minValue = 0
            averageReadyTimeHoursPicker.maxValue = 12
            averageReadyTimeMinutesPicker.minValue = 0
            averageReadyTimeMinutesPicker.maxValue = 59

            averageReadyTimeHoursPicker.wrapSelectorWheel = false
            averageReadyTimeMinutesPicker.wrapSelectorWheel = false

            averageReadyTimeHoursPicker.descendantFocusability =
                NumberPicker.FOCUS_BLOCK_DESCENDANTS
            averageReadyTimeMinutesPicker.descendantFocusability =
                NumberPicker.FOCUS_BLOCK_DESCENDANTS

            averageReadyTimeMinutesPicker.formatter()
            averageReadyTimeHoursPicker.formatter()
        }
    }

    private fun initUserNickName() {
        viewModel.setUserNickName(nickName, isFromSignUp)
    }

    private fun observeLiveData() {
        viewModel.buttonClickEvent.observe(this, Observer {
            gotoEarlyArrivedTime()
        })
    }

    private fun gotoEarlyArrivedTime() {
        Intent(this, EarlyArrivedTimeActivity::class.java).apply {
            putExtra(AppConfig.INTENT_PARAM_NICK_NAME, nickName)
            putExtra(AppConfig.INTENT_PARAM_FLAG_FROM_SIGN_UP, true)
        }.also {
            startForResult.launch(it)
        }
    }
}