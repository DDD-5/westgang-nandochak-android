package kr.co.west_gang.nan_do_chak.view.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kr.co.west_gang.nan_do_chak.R
import kr.co.west_gang.nan_do_chak.architecture.BaseActivity
import kr.co.west_gang.nan_do_chak.databinding.ActivityMainBinding
import kr.co.west_gang.nan_do_chak.util.AppConfig.TAG_DEBUG
import kr.co.west_gang.nan_do_chak.util.logD
import kr.co.west_gang.nan_do_chak.view.averagereadytime.AverageReadyTimeActivity

class MainActivity : BaseActivity() {

    private val binding by binding<ActivityMainBinding>(R.layout.activity_main)
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        logD(TAG_DEBUG, "Main Activity onCreate")

        observeLiveData()
    }

    private fun observeLiveData(){
        viewModel.buttonClickEvent.observe(this, Observer {
            gotoAverageReadyTimeActivity()
        })
    }

    private fun gotoAverageReadyTimeActivity(){
        startActivity(
            Intent(this, AverageReadyTimeActivity::class.java)
        )
    }
}