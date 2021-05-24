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

    var nickNameInput: String = ""

    fun signUpDoneButtonClick() {
        nickNameInput = nickNameInput.replace(" ", "")
        UserInfo.nickname = nickNameInput

        _signUpDoneButtonClicked.value = true
    }

}