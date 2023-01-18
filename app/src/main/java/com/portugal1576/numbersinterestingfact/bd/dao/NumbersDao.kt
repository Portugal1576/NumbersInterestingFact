package com.portugal1576.numbersinterestingfact.bd.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.portugal1576.numbersinterestingfact.model.NumberFact

@Dao
interface NumbersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(noteModel: NumberFact)

    @Delete
    suspend fun delete(noteModel: NumberFact)

    @Query("SELECT * from note_table")
    fun getAllNotes(): LiveData<List<NumberFact>>
}