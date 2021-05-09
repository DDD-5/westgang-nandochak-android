package kr.co.west_gang.nan_do_chak.view.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import kr.co.west_gang.nan_do_chak.R
import kr.co.west_gang.nan_do_chak.architecture.BaseActivity
import kr.co.west_gang.nan_do_chak.databinding.ActivitySplashBinding
import kr.co.west_gang.nan_do_chak.util.AppConfig.TAG_DEBUG
import kr.co.west_gang.nan_do_chak.util.logD
import kr.co.west_gang.nan_do_chak.view.main.MainActivity

class SplashActivity : BaseActivity() {

    private val binding by binding<ActivitySplashBinding>(R.layout.activity_splash)
    private val viewModel: SplashViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this

        logD(TAG_DEBUG, "Splash Activity onCreate")
    }

    override fun onResume() {
        super.onResume()

        //TODO : Remove This Code
        CoroutineScope(Dispatchers.IO).launch {
            delay(3000L)
            startMainActivity()
        }
    }

    private fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onBackPressed() = Unit
}