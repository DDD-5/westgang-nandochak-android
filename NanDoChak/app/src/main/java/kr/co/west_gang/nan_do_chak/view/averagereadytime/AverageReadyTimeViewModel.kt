package kr.co.west_gang.nan_do_chak.view.averagereadytime

import android.widget.NumberPicker
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.co.west_gang.nan_do_chak.R
import kr.co.west_gang.nan_do_chak.data.dto.UserInfoDto
import kr.co.west_gang.nan_do_chak.util.NanDoChakApplication.Companion.getString
import kr.co.west_gang.nan_do_chak.util.logD

class AverageReadyTimeViewModel : ViewModel() {

    private val _userNickName: MutableLiveData<String> = MutableLiveData()
    val userNickname: LiveData<String> = _userNickName

    private val _buttonClickEvent = MutableLiveData<Unit>()
    val buttonClickEvent: LiveData<Unit> = _buttonClickEvent

    var averageReadyTimeHours: Int = 0
    var averageReadyTimeMinutes: Int = 0


    fun onButtonClick() {
        UserInfoDto.averageReadyTime =
            (averageReadyTimeHours * 100 + averageReadyTimeMinutes).toString()

        if (averageReadyTimeHours < 10) {
            UserInfoDto.averageReadyTime = "0" + UserInfoDto.averageReadyTime
        }

        _buttonClickEvent.value = Unit
    }

    fun setUserNickName(nickName: String?, isSignUp: Boolean) {
        nickName?.let {
            if (isSignUp) {
                _userNickName.value =
                    getString(R.string.selectAverageReadyTimeWhenSignUpPrefix) + " " + it + " " +
                            getString(R.string.selectAverageReadyTimeWhenSignUpPostfix)
            } else {
                _userNickName.value = it + getString(R.string.selectAverageReadyTime)
            }
        } ?: run {
            _userNickName.value = getString(R.string.selectAverageReadyTimeWhenNoNickName)
        }
    }
}