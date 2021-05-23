package kr.co.west_gang.nan_do_chak.view.earlyarrivedtime

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.co.west_gang.nan_do_chak.R
import kr.co.west_gang.nan_do_chak.data.dto.UserInfoDto
import kr.co.west_gang.nan_do_chak.util.NanDoChakApplication.Companion.getString
import kr.co.west_gang.nan_do_chak.util.logD

class EarlyArrivedTimeViewModel : ViewModel() {
    private val _buttonClickEvent = MutableLiveData<Unit>()
    val buttonClickEvent: LiveData<Unit> = _buttonClickEvent

    var earlyArrivedTimeHours = 0
    var earlyArrivedTimeMinutes = 0

    private val _userNickName: MutableLiveData<String> = MutableLiveData()
    val userNickname: LiveData<String> = _userNickName

    fun onButtonClick() {
        UserInfoDto.earlyArrivedTime =
            (earlyArrivedTimeHours * 100 + earlyArrivedTimeMinutes).toString()

        if (earlyArrivedTimeHours < 10) {
            UserInfoDto.earlyArrivedTime = "0" + UserInfoDto.earlyArrivedTime
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
        UserInfoDto.printUserInfo()
        if (isSignUp) {
            //TODO : 유저 등록 (서버), db 수정
        } else {
            //TODO : 유저 정보 update (서버), db 수정
        }
    }
}