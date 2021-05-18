package kr.co.west_gang.nan_do_chak.view.alarm

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import kr.co.west_gang.nan_do_chak.R
import kr.co.west_gang.nan_do_chak.architecture.BaseFragment
import kr.co.west_gang.nan_do_chak.databinding.FragmentAlarmBinding

class AlarmFragment : BaseFragment<FragmentAlarmBinding>() {

    override val layoutResourceId: Int = R.layout.fragment_alarm

    val viewModel by lazy {
        ViewModelProvider(this).get(AlarmViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

    companion object {
        fun create() = AlarmFragment()
    }
}