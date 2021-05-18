package kr.co.west_gang.nan_do_chak.view.earlyarrivedtime

import android.content.Intent
import android.os.Bundle
import android.widget.NumberPicker
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kr.co.west_gang.nan_do_chak.R
import kr.co.west_gang.nan_do_chak.architecture.BaseActivity
import kr.co.west_gang.nan_do_chak.databinding.ActivityEarlyArrivedTimeBinding
import kr.co.west_gang.nan_do_chak.util.AppConfig
import kr.co.west_gang.nan_do_chak.util.logD
import kr.co.west_gang.nan_do_chak.view.plantime.PlanTimeActivity

class EarlyArrivedTimeActivity : BaseActivity()  {

    private val binding by binding<ActivityEarlyArrivedTimeBinding>(R.layout.activity_early_arrived_time)
    private val viewModel: EarlyArrivedTimeViewModel by viewModels()

    private fun NumberPicker.formatter() = this.setFormatter { i -> String.format("%02d", i) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        logD(AppConfig.TAG_DEBUG, "EarlyArrivedTime Activity onCreate")

        observeLiveData()
        initNumberPicker()
    }

    private fun initNumberPicker(){
        binding.earlyArrivedTimeHoursPicker.minValue = 0
        binding.earlyArrivedTimeHoursPicker.maxValue = 12
        binding.earlyArrivedTimeMinutesPicker.minValue = 0
        binding.earlyArrivedTimeMinutesPicker.maxValue = 59

        binding.earlyArrivedTimeHoursPicker.wrapSelectorWheel = false
        binding.earlyArrivedTimeMinutesPicker.wrapSelectorWheel = false

        binding.earlyArrivedTimeHoursPicker.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
        binding.earlyArrivedTimeMinutesPicker.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS

        binding.earlyArrivedTimeHoursPicker.formatter()
        binding.earlyArrivedTimeMinutesPicker.formatter()
    }

    private fun observeLiveData(){
        viewModel.buttonClickEvent.observe(this, Observer {
            gotoPlansTime()
        })

        binding.earlyArrivedTimeTitle.text = getString(R.string.selectEarlyArrivedTime, viewModel.userName)
    }

    private fun gotoPlansTime(){
        startActivity(
            Intent(this, PlanTimeActivity::class.java)
        )
    }
}