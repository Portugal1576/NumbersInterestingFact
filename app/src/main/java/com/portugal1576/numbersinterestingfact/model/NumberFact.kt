package com.portugal1576.numbersinterestingfact.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "note_table")
class NumberFact(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo
    var number: String = "",

    @ColumnInfo
    var description: String =""
) : Serializable