package kr.co.west_gang.nan_do_chak.view.signup

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kr.co.west_gang.nan_do_chak.R
import kr.co.west_gang.nan_do_chak.architecture.BaseActivity
import kr.co.west_gang.nan_do_chak.databinding.ActivitySignUpBinding
import kr.co.west_gang.nan_do_chak.util.AppConfig
import kr.co.west_gang.nan_do_chak.util.AppConfig.TAG_DEBUG
import kr.co.west_gang.nan_do_chak.util.logD
import kr.co.west_gang.nan_do_chak.view.averagereadytime.AverageReadyTimeActivity

class SignUpActivity : BaseActivity() {

    private val binding by binding<ActivitySignUpBinding>(R.layout.activity_sign_up)
    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        addNickNameTextChaneListener()
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
        val nickNameText = viewModel.nickNameInput.value
        if (nickNameText.isNullOrEmpty() || nickNameText.length < 2) {
            Toast.makeText(this, getString(R.string.sign_up_require_more_input_text), Toast.LENGTH_SHORT).show()
        } else {
            logD(TAG_DEBUG, "nickName : $nickNameText")
            startAverageActivity(nickNameText)
        }
    }

    private fun startAverageActivity(nickName: String) {
        Intent(this, AverageReadyTimeActivity::class.java).apply {
            putExtra(AppConfig.INTENT_PARAM_NICK_NAME, nickName)
        }.also {
            startActivity(it)
        }
    }

    private fun addNickNameTextChaneListener() {
        binding.signUpNickNameInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) = Unit
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) =
                Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val input =s?.trim().toString()
                viewModel.setNickName(input)
            }
        })
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