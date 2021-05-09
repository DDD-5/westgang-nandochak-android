package kr.co.west_gang.nan_do_chak.view.earlyarrivedtime

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EarlyArrivedTimeViewModel : ViewModel() {
    private val _buttonClickEvent = MutableLiveData<Unit>()
    val buttonClickEvent : LiveData<Unit> = _buttonClickEvent

    private val _earlyArrivedTimeHours = MutableLiveData<Int>()
    var earlyArrivedTimeHours = 0

    private val _earlyArrivedTimeMinutes = MutableLiveData<Int>()
    var earlyArrivedTimeMinutes = 0

    var userName = "임시 닉네임"

    fun onButtonClick(){
        _buttonClickEvent.value = Unit
    }
}