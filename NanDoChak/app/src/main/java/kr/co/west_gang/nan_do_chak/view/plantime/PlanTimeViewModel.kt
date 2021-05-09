package kr.co.west_gang.nan_do_chak.view.plantime

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlanTimeViewModel : ViewModel() {
    private val _buttonClickEvent = MutableLiveData<Unit>()
    val buttonClickEvent : LiveData<Unit> = _buttonClickEvent

    var planTimeHours = 0
    var planTimeMinutes = 0
    var planTimeMeridiem = ""

    fun onButtonClick(){
        _buttonClickEvent.value = Unit
    }

    fun onValueChange(_planTimeMeridiem : Int){
        when (_planTimeMeridiem) {
            0 -> planTimeMeridiem = "오전"
            1 -> planTimeMeridiem = "오후"
        }
    }
}