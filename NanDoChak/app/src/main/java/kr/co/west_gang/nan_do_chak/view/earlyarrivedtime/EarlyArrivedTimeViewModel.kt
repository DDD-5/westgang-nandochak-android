package kr.co.west_gang.nan_do_chak.view.earlyarrivedtime

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EarlyArrivedTimeViewModel : ViewModel() {
    private val _buttonClickEvent = MutableLiveData<Unit>()
    val buttonClickEvent : LiveData<Unit> = _buttonClickEvent

    fun onButtonClick(){
        _buttonClickEvent.value = Unit
    }
}