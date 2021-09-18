package kr.co.west_gang.nan_do_chak.view.login

import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kr.co.west_gang.nan_do_chak.data.UserInfo
import kr.co.west_gang.nan_do_chak.firebase.FirestoreAccessor.isExistUserTokenInFireStore
import kr.co.west_gang.nan_do_chak.firebase.FirestoreConfig.UserExistCheck
import kr.co.west_gang.nan_do_chak.util.NanDoChakApplication
import kr.co.west_gang.nan_do_chak.util.NetworkStatusChecker

/*
* Created by JJJoonngg
*/

class LoginViewModel : ViewModel() {

    private val _isLoginButtonClicked: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoginButtonClicked: LiveData<Boolean> = _isLoginButtonClicked

    private val _isSignUpButtonClicked: MutableLiveData<Boolean> = MutableLiveData(false)
    val isSignUpButtonClicked: MutableLiveData<Boolean> = _isSignUpButtonClicked

    private val _isNetworkAvailable: MutableLiveData<Boolean> = MutableLiveData()
    val isNetworkAvailable: LiveData<Boolean> = _isNetworkAvailable

    private val _userExistCheckWhenLogin: MutableLiveData<UserExistCheck> =
        MutableLiveData(UserExistCheck.NONE)
    val userExistCheckWhenLogin: LiveData<UserExistCheck> = _userExistCheckWhenLogin

    private val _userExistCheckWhenSignUp: MutableLiveData<UserExistCheck> =
        MutableLiveData(UserExistCheck.NONE)
    val userExistCheckWhenSignUp: LiveData<UserExistCheck> = _userExistCheckWhenSignUp

    fun loginButtonClicked() {
        if (!NanDoChakApplication.isOnline()) {
            _isNetworkAvailable.value = false
            return
        }
        _isLoginButtonClicked.value = true
    }

    fun signUpButtonClicked() {
        if (!NanDoChakApplication.isOnline()) {
            _isNetworkAvailable.value = false
            return
        }
        _isSignUpButtonClicked.value = true
    }

    fun checkUserExistInFirestoreWhenLogin(kakaoId: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = isExistUserTokenInFireStore(kakaoId)
                CoroutineScope(Dispatchers.Main).launch {
                    _userExistCheckWhenLogin.value = result
                }
            }
        }
    }

    fun checkUserExistInFirestoreWhenSignUp(kakaoId: String) {
        UserInfo.kakaoId = kakaoId
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = isExistUserTokenInFireStore(kakaoId)
                CoroutineScope(Dispatchers.Main).launch {
                    _userExistCheckWhenSignUp.value = result
                }
            }
        }
    }
}