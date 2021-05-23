package kr.co.west_gang.nan_do_chak.view.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kakao.sdk.user.UserApiClient

/*
* Created by JJJoonngg
*/

class LoginViewModel : ViewModel() {

    private val _isLoginButtonClicked: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoginButtonClicked: LiveData<Boolean> = _isLoginButtonClicked

    private val _isSignUpButtonClicked: MutableLiveData<Boolean> = MutableLiveData(false)
    val isSignUpButtonClicked: MutableLiveData<Boolean> = _isSignUpButtonClicked


    fun loginButtonClicked() {
        _isLoginButtonClicked.value = true
    }

    fun signUpButtonClicked() {
        _isSignUpButtonClicked.value = true
    }
}