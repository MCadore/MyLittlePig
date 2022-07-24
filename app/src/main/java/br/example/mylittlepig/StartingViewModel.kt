package br.example.mylittlepig

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StartingViewModel : ViewModel() {

    private val _startingLiveData : MutableLiveData<Success<Boolean>> = MutableLiveData()
    val startingLiveData : LiveData<Success<Boolean>> = _startingLiveData

    fun onStartBtnPressed(){
        _startingLiveData.value = Success(true)
    }

}