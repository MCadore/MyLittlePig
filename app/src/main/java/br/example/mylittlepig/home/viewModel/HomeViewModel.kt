package br.example.mylittlepig.home.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.example.mylittlepig.Error
import br.example.mylittlepig.Result
import br.example.mylittlepig.Success
import br.example.mylittlepig.home.data.Income
import br.example.mylittlepig.home.data.IncomeRepository
import br.example.mylittlepig.home.view.IncomeVO
import kotlinx.coroutines.launch

class HomeViewModel(app: Application) : AndroidViewModel(app) {

    private val repository = IncomeRepository(app.applicationContext)

    //Livedata
    private val _onUpdateIncome: MutableLiveData<Success<Boolean>> = MutableLiveData()
    val onUpdateIncome: LiveData<Success<Boolean>> = _onUpdateIncome
    private val _onFetchIncome: MutableLiveData<Result<List<IncomeVO>>> = MutableLiveData()
    val onFetchIncome: LiveData<Result<List<IncomeVO>>> = _onFetchIncome

    fun addIncome(income: Income) {
        try {
            viewModelScope.launch {
                repository.insertIncome(income)
                _onUpdateIncome.value = Success(true)
            }
        } catch (ex: Exception) {
            _onUpdateIncome.value = Success(false)
        }
    }

    fun deleteIncome(income: Income) {
        try {
            viewModelScope.launch {
                repository.deleteIncome(income)
                _onUpdateIncome.value = Success(true)
            }
        } catch (ex: Exception) {
            _onUpdateIncome.value = Success(false)
        }
    }

    fun update(income: Income){
        try {
            viewModelScope.launch {
                repository.updateIncome(income)
                _onUpdateIncome.value = Success(true)
            }
        }catch (ex: Exception){
            _onUpdateIncome.value = Success(false)
        }
    }

    fun fetchAllIncome() {
        try {
            viewModelScope.launch {
                val incomeList: List<Income> = repository.fetchAllIncome()
                val incomeVO: List<IncomeVO> = incomeList.map {
                    IncomeVO(
                        uid = it.uid,
                        income_tittle = it.income_tittle,
                        income_value = it.income_value,
                    )
                }
                _onFetchIncome.value = Success(incomeVO)
            }
        }catch (ex: Exception){
            _onFetchIncome.value = Error()
        }
    }


}