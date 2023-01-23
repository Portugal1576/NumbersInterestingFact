package com.portugal1576.numbersinterestingfact.ui.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.portugal1576.numbersinterestingfact.REPOSITORY
import com.portugal1576.numbersinterestingfact.bd.dao.NumbersDatabase
import com.portugal1576.numbersinterestingfact.bd.repository.NumberFactRealization
import com.portugal1576.numbersinterestingfact.model.NumberFact

class StartViewModel(application: Application): AndroidViewModel(application) {

    private val context = application


    fun initDatabase(){
        val daoNumbers = NumbersDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NumberFactRealization(daoNumbers)
    }

    fun getAllNumbers(): LiveData<List<NumberFact>> {
        return REPOSITORY.allNumbers
    }

}