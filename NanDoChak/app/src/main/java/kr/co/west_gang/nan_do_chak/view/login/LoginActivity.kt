package kr.co.west_gang.nan_do_chak.view.login

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.kakao.sdk.user.UserApiClient
import kr.co.west_gang.nan_do_chak.R
import kr.co.west_gang.nan_do_chak.architecture.BaseActivity
import kr.co.west_gang.nan_do_chak.databinding.ActivityLoginBinding
import kr.co.west_gang.nan_do_chak.util.AppConfig.TAG_DEBUG
import kr.co.west_gang.nan_do_chak.util.logD

class LoginActivity : BaseActivity() {

    private val binding by binding<ActivityLoginBinding>(R.layout.activity_login)
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.isLoginButtonClicked.observe(this, Observer { isClicked ->
            if (isClicked) {
                val isKakaoTalkLoginAvailable =
                    UserApiClient.instance.isKakaoTalkLoginAvailable(this)

                if (isKakaoTalkLoginAvailable) {
                    UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
                        if (error != null) {
                            logD(TAG_DEBUG, "로그인 실패 $error")
                        } else if (token != null) {
                            logD(TAG_DEBUG, "로그인 성공 ${token.accessToken}")
                        }
                    }
                } else {
                    Toast.makeText(this, "KaKao Talk 미설치 ", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }

}