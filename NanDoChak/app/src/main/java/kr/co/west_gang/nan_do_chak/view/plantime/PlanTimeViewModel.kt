package kr.co.west_gang.nan_do_chak.view.plantime

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlanTimeViewModel : ViewModel() {
    private val _buttonClickEvent = MutableLiveData<Unit>()
    val buttonClickEvent : LiveData<Unit> = _buttonClickEvent

    private val _planTimeHours =  MutableLiveData<Int>()
    var planTimeHours = 0

    private val _planTimeMinutes =  MutableLiveData<Int>()
    var planTimeMinutes = 0

    private val _planTimeMeridiem =  MutableLiveData<String>()
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