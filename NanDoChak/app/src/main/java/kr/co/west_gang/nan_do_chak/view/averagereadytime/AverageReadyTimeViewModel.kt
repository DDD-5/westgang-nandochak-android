package kr.co.west_gang.nan_do_chak.view.averagereadytime

import android.widget.NumberPicker
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.co.west_gang.nan_do_chak.R
import kr.co.west_gang.nan_do_chak.util.NanDoChakApplication.Companion.getString

class AverageReadyTimeViewModel : ViewModel() {

    private val _userNickName: MutableLiveData<String> = MutableLiveData()
    val userNickname: LiveData<String> = _userNickName

    private val _buttonClickEvent = MutableLiveData<Unit>()
    val buttonClickEvent: LiveData<Unit> = _buttonClickEvent

    private val _averageReadyTimeHours = MutableLiveData<Int>()
    var averageReadyTimeHours = 0

    private val _averageReadyTimeMinutes = MutableLiveData<Int>()
    var averageReadyTimeMinutes = 0


    fun onButtonClick() {
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