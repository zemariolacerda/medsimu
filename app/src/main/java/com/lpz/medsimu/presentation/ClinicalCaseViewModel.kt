package com.lpz.medsimu.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lpz.medsimu.data.model.ClinicalCase
import com.lpz.medsimu.domain.ListClinicalCaseUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ClinicalCaseViewModel(
    private val listClinicalCaseUseCase: ListClinicalCaseUseCase
) : ViewModel() {

    private val _clinicalCases = MutableLiveData<State>()
    val clinicalCases: LiveData<State> = _clinicalCases

        fun getClinicalCaseList(consulta: String) {
            viewModelScope.launch {
                listClinicalCaseUseCase(consulta)
                    .onStart {
                        _clinicalCases.postValue(State.Loading)
                    }
                    .catch {
                        _clinicalCases.postValue(State.Error(it))
                    }
                    .collect {
                        _clinicalCases.postValue(State.Success(it))
                    }
            }
        }

    sealed class State{
        object Loading : State()
        data class Success(val list: List<ClinicalCase>) : State()
        data class Error(val error: Throwable) : State()
    }
}