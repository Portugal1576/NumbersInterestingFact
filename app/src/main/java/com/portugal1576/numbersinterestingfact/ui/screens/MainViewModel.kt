package com.portugal1576.numbersinterestingfact.ui.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.portugal1576.numbersinterestingfact.data.repository.NumbersRepository
import com.portugal1576.numbersinterestingfact.model.NumberFact
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val numberFactResult = MutableLiveData<String>()
    val numberOfList = MutableLiveData<Boolean>()
    val numberFact = MutableLiveData<NumberFact>()
    private val repo = NumbersRepository()
    val number: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getNumberFact(number: String) {
        viewModelScope.launch {
            numberFactResult.value = repo.getFact(number)
        }
    }
}

