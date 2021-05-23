package kr.co.west_gang.nan_do_chak.view.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import kr.co.west_gang.nan_do_chak.R
import kr.co.west_gang.nan_do_chak.architecture.BaseActivity
import kr.co.west_gang.nan_do_chak.databinding.ActivityLoginBinding
import kr.co.west_gang.nan_do_chak.firebase.FirestoreConfig.UserExistCheck
import kr.co.west_gang.nan_do_chak.util.AppConfig.TAG_DEBUG
import kr.co.west_gang.nan_do_chak.util.logD
import kr.co.west_gang.nan_do_chak.view.main.MainActivity
import kr.co.west_gang.nan_do_chak.view.signup.SignUpActivity

class LoginActivity : BaseActivity() {

    private val binding by binding<ActivityLoginBinding>(R.layout.activity_login)
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logD(TAG_DEBUG, "Login Activity Start")
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        observeLiveData()
    }

    private fun observeLiveData() {
        with(viewModel) {
            isLoginButtonClicked.observe(this@LoginActivity, Observer { isClicked ->
                if (isClicked) {
                    loginSessionCheck(isClicked)
                }
            })

            isSignUpButtonClicked.observe(this@LoginActivity, Observer { isClicked ->
                if (isClicked) {
                    checkSignUpSession()
                }
            })

            userExistCheckWhenLogin.observe(this@LoginActivity, Observer { result ->
                when (result) {
                    UserExistCheck.ERROR -> {
                        //TODO : 알 수 없는 에러 모달창
                        logD(TAG_DEBUG, "Login Error")
                    }
                    UserExistCheck.NOT_EXIST -> {
                        Toast.makeText(
                            this@LoginActivity,
                            getString(R.string.login_toast_not_exist_user),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    UserExistCheck.EXIST -> {
                        Toast.makeText(
                            this@LoginActivity,
                            getString(R.string.login_toast_success),
                            Toast.LENGTH_SHORT
                        ).show()
                        startMainActivity()
                    }
                    else -> Unit
                }
            })

            userExistCheckWhenSignUp.observe(this@LoginActivity, Observer { result ->
                when (result) {
                    UserExistCheck.ERROR -> {
                        //TODO : 알 수 없는 에러 모달창
                        logD(TAG_DEBUG, "Sign Up Error")
                    }
                    UserExistCheck.NOT_EXIST -> {
                        startSignUpActivity()
                    }
                    UserExistCheck.EXIST -> {
                        Toast.makeText(
                            this@LoginActivity,
                            getString(R.string.login_toast_exist_user),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    else -> Unit
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
                //KaKao Login Success
                UserApiClient.instance.me { user, error ->
                    if (error != null) {
                        logD(TAG_DEBUG, "user information request fail : $error")
                        toastErrorMessage(LOGIN_FAIL)
                    } else {
                        logD(TAG_DEBUG, "user : ${user?.id}")
                        user?.let {
                            viewModel.checkUserExistInFirestoreWhenLogin(it.id.toString())
                        } ?: run {
                            toastErrorMessage(LOGIN_FAIL)
                        }
                    }
                }
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

    private fun checkSignUpSession() {
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                logD(TAG_DEBUG, "Sign up fail : $error")
                error.message?.let {
                    if (it.contains(getString(R.string.kakao_login_cancelled))) {
                        logD(TAG_DEBUG, "KaKao Login Cancelled.")
                    } else {
                        toastErrorMessage(SIGN_UP_FAIL)
                    }
                } ?: run {
                    toastErrorMessage(SIGN_UP_FAIL)
                }
            } else if (token != null) {
                logD(TAG_DEBUG, "token : $token")
                logD(TAG_DEBUG, "token accessToken : ${token.accessToken}")
                UserApiClient.instance.me { user, error ->
                    if (error != null) {
                        logD(TAG_DEBUG, "user information request fail : $error")
                        toastErrorMessage(SIGN_UP_FAIL)
                    } else {
                        logD(TAG_DEBUG, "user : ${user?.id}")
                        user?.let {
                            viewModel.checkUserExistInFirestoreWhenSignUp(it.id.toString())
                        } ?: run {
                            toastErrorMessage(SIGN_UP_FAIL)
                        }
                    }
                }
            }
        }
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

    private fun toastErrorMessage(type: String) {
        val errorMessage = if (type.equals(LOGIN_FAIL)) {
            getString(R.string.login_error)
        } else {
            getString(R.string.login_sign_up_error)
        }
        Toast.makeText(
            this,
            errorMessage,
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun startSignUpActivity() {
        startActivity(Intent(this, SignUpActivity::class.java))
    }

    companion object {
        const val LOGIN_FAIL = "loginFail"
        const val SIGN_UP_FAIL = "signUpFail"
    }
}