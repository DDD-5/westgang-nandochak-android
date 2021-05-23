package kr.co.west_gang.nan_do_chak.view.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient
import kr.co.west_gang.nan_do_chak.R
import kr.co.west_gang.nan_do_chak.architecture.BaseActivity
import kr.co.west_gang.nan_do_chak.databinding.ActivityLoginBinding
import kr.co.west_gang.nan_do_chak.util.AppConfig.TAG_DEBUG
import kr.co.west_gang.nan_do_chak.util.logD
import kr.co.west_gang.nan_do_chak.view.main.MainActivity

class LoginActivity : BaseActivity() {

    private val binding by binding<ActivityLoginBinding>(R.layout.activity_login)
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        observeLiveData()

        val keyHash = Utility.getKeyHash(this)
        logD("Hash", "keyHash : $keyHash")
    }

    private fun observeLiveData() {
        with(viewModel) {
            isLoginButtonClicked.observe(this@LoginActivity, Observer { isClicked ->
                loginSessionCheck(isClicked)
            })

            isSignUpButtonClicked.observe(this@LoginActivity, Observer { isClicked ->
                if (isClicked) {
                    startSignUpActivity()
                }
            })
        }
    }

    private fun loginSessionCheck(isClicked: Boolean) {
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                //Login Fail
                logD(TAG_DEBUG, "Login Fail : $error")
                //TODO : login 실패 모달 창
            } else if (token != null) {
                //Login Success
                logD(TAG_DEBUG, "token : ${token.accessToken}")
                //TODO : 회원 정보 확인
                //token 을 이용해서 firebase 에 유저가 존재하는지 check
                startMainActivity()
            }
        }
        if (isClicked) {
            val isKakaoTalkLoginAvailable =
                UserApiClient.instance.isKakaoTalkLoginAvailable(this)

            if (isKakaoTalkLoginAvailable) {
                UserApiClient.instance.loginWithKakaoTalk(
                    context = this,
                    callback = callback
                )
            } else {
                UserApiClient.instance.loginWithKakaoAccount(
                    context = this,
                    callback = callback
                )
            }
        }
    }

    private fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun startSignUpActivity() {
        //TODO : 회원 가입 로직 진행
    }
}