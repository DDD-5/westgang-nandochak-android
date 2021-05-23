package kr.co.west_gang.nan_do_chak.view.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.co.west_gang.nan_do_chak.data.UserInfo

/*
* Created by JJJoonngg
*/

class SignUpViewModel : ViewModel() {

    private val _signUpDoneButtonClicked: MutableLiveData<Boolean> = MutableLiveData(false)
    val signUpDoneButtonClicked: LiveData<Boolean> = _signUpDoneButtonClicked

    private val _nickNameInput: MutableLiveData<String> = MutableLiveData()
    val nickNameInput: LiveData<String> = _nickNameInput

    fun setNickName(input: String) {
        _nickNameInput.value = input
        UserInfo.nickname = _nickNameInput.value.toString()
    }

    fun signUpDoneButtonClick() {
        _signUpDoneButtonClicked.value = true
    }

}