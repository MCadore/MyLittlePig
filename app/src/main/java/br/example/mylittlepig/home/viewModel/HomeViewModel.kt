package br.example.mylittlepig.home.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.example.mylittlepig.Success
import br.example.mylittlepig.home.data.IncomeRepository

class HomeViewModel(app: Application) : AndroidViewModel(app)  {

    private val repository = IncomeRepository(app.applicationContext)

    //Livedata
    private val _incomeLiveData : MutableLiveData<Result<Success<Boolean>>> = MutableLiveData()
    val  incomeLiveData : LiveData<Result<Success<Boolean>>> = _incomeLiveData



}