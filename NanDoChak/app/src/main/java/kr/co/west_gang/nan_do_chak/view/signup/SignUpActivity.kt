package kr.co.west_gang.nan_do_chak.view.signup

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kr.co.west_gang.nan_do_chak.R
import kr.co.west_gang.nan_do_chak.architecture.BaseActivity
import kr.co.west_gang.nan_do_chak.databinding.ActivitySignUpBinding
import kr.co.west_gang.nan_do_chak.util.AppConfig
import kr.co.west_gang.nan_do_chak.util.AppConfig.ACTIVITY_RESULT_SIGN_UP
import kr.co.west_gang.nan_do_chak.util.AppConfig.TAG_DEBUG
import kr.co.west_gang.nan_do_chak.util.logD
import kr.co.west_gang.nan_do_chak.view.averagereadytime.AverageReadyTimeActivity

class SignUpActivity : BaseActivity() {

    private val binding by binding<ActivitySignUpBinding>(R.layout.activity_sign_up)
    private val viewModel: SignUpViewModel by viewModels()
    private lateinit var startForResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        startForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == ACTIVITY_RESULT_SIGN_UP) {
                    finish()
                }
            }

        addNickNameTextEnter()
        observeLiveData()
    }

    private fun observeLiveData() {
        with(viewModel) {
            signUpDoneButtonClicked.observe(this@SignUpActivity, Observer { isClicked ->
                if (isClicked) {
                    goToNextStep()
                }
            })
        }
    }

    private fun goToNextStep() {
        val nickNameText = viewModel.nickNameInput
        if (nickNameText.isEmpty() || nickNameText.length < 2) {
            Toast.makeText(
                this,
                getString(R.string.sign_up_require_more_input_text),
                Toast.LENGTH_SHORT
            ).show()
        } else {
            logD(TAG_DEBUG, "nickName : $nickNameText")
            startAverageActivity(nickNameText)
        }
    }

    private fun startAverageActivity(nickName: String) {


        Intent(this, AverageReadyTimeActivity::class.java).apply {
            putExtra(AppConfig.INTENT_PARAM_NICK_NAME, nickName)
            putExtra(AppConfig.INTENT_PARAM_FLAG_FROM_SIGN_UP, true)
        }.also {
            startForResult.launch(it)
        }
    }

    private fun addNickNameTextEnter() {
        binding.signUpNickNameInput.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                goToNextStep()
                return@setOnKeyListener false
            }
            false
        }
    }
}