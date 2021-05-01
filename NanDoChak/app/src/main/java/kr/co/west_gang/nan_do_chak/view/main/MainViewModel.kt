package kr.co.west_gang.nan_do_chak.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/*
* Created by JJJoonngg
*/

class MainViewModel : ViewModel() {
    private val _helloWorld: MutableLiveData<String> = MutableLiveData("Hello West Gang World!")
    val helloWorld: LiveData<String> = _helloWorld
}