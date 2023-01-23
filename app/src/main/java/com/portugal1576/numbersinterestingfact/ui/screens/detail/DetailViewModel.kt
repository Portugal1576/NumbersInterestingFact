package com.portugal1576.numbersinterestingfact.ui.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.portugal1576.numbersinterestingfact.REPOSITORY
import com.portugal1576.numbersinterestingfact.model.NumberFact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {
    fun delete(numberFact: NumberFact, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteNumber(numberFact){
                onSuccess()
            }
        }
    fun insert(numberFact: NumberFact, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insertNumber(numberFact){
                onSuccess()
            }
        }
}