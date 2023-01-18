package com.portugal1576.numbersinterestingfact.bd.repository

import androidx.lifecycle.LiveData
import com.portugal1576.numbersinterestingfact.bd.dao.NumbersDao
import com.portugal1576.numbersinterestingfact.model.NumberFact

class NumberFactRealization(private val numberDao: NumbersDao): NumbersFactRepository {

    override val allNumbers: LiveData<List<NumberFact>>
        get() = numberDao.getAllNotes()

    override suspend fun insertNumber(noteModel: NumberFact, Success: () -> Unit) {
        numberDao.insert(noteModel)
        Success()
    }

    override suspend fun deleteNumber(noteModel: NumberFact, Success: () -> Unit) {
        numberDao.delete(noteModel)
        Success()
    }
}