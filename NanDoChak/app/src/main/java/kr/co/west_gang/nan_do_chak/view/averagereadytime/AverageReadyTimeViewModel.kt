package kr.co.west_gang.nan_do_chak.view.averagereadytime

import android.widget.NumberPicker
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AverageReadyTimeViewModel : ViewModel() {

    private val _buttonClickEvent = MutableLiveData<Unit>()
    val buttonClickEvent : LiveData<Unit> = _buttonClickEvent

    var averageReadyTimeHours = 0
    var averageReadyTimeMinutes = 0

    fun onButtonClick(){
        _buttonClickEvent.value = Unit
    }
}