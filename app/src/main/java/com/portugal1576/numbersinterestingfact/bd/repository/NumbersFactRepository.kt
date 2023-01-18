package com.portugal1576.numbersinterestingfact.bd.repository

import androidx.lifecycle.LiveData
import com.portugal1576.numbersinterestingfact.model.NumberFact

interface NumbersFactRepository {

    val allNumbers: LiveData<List<NumberFact>>

    suspend fun insertNumber(noteModel: NumberFact, Success: () -> Unit)

    suspend fun deleteNumber(noteModel: NumberFact, Success: () -> Unit)
}