package kr.co.west_gang.nan_do_chak.view.earlyarrivedtime

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kr.co.west_gang.nan_do_chak.R
import kr.co.west_gang.nan_do_chak.data.UserInfo
import kr.co.west_gang.nan_do_chak.data.dto.UserInfoDto
import kr.co.west_gang.nan_do_chak.firebase.FirestoreAccessor.createUserInfoInFirestore
import kr.co.west_gang.nan_do_chak.util.NanDoChakApplication.Companion.getString

class EarlyArrivedTimeViewModel : ViewModel() {
    private val _buttonClickEvent = MutableLiveData<Unit>()
    val buttonClickEvent: LiveData<Unit> = _buttonClickEvent

    private val _signUpDone = MutableLiveData<Unit>()
    val signUpDone: LiveData<Unit> = _signUpDone

    var earlyArrivedTimeHours = 0
    var earlyArrivedTimeMinutes = 0

    private val _userNickName: MutableLiveData<String> = MutableLiveData()
    val userNickname: LiveData<String> = _userNickName

    fun onButtonClick() {
        UserInfo.earlyArrivedTime =
            (earlyArrivedTimeHours * 100 + earlyArrivedTimeMinutes).toString()

        if (earlyArrivedTimeHours < 10) {
            UserInfo.earlyArrivedTime = "0" + UserInfo.earlyArrivedTime
        }
        _buttonClickEvent.value = Unit
    }

    fun setUserNickName(input: String?) {
        _userNickName.value = if (input.isNullOrEmpty()) {
            getString(R.string.selectEarlyArrivedTimeDefault)
        } else {
            input + getString(R.string.selectEarlyArrivedTimePostfix)
        }
    }

    fun setUserInformationDone(isSignUp: Boolean) {
        UserInfo.printUserInfo()
        if (isSignUp) {
            //TODO : 유저 등록 (서버), db 수정
            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    createUserInfoInFirestore(
                        userInfoDto = UserInfoDto(
                            kakaoId = UserInfo.kakaoId,
                            nickname = UserInfo.nickname,
                            averageReadyTime = UserInfo.averageReadyTime,
                            earlyArrivedTime = UserInfo.earlyArrivedTime
                        )
                    )
                    _signUpDone.value = Unit
                }
            }
        } else {
            //TODO : 유저 정보 update (서버), db 수정
        }
    }
}