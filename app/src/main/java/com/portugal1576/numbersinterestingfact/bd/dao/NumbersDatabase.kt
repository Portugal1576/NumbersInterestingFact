package com.portugal1576.numbersinterestingfact.bd.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.portugal1576.numbersinterestingfact.model.NumberFact

@Database(entities = [NumberFact::class], version = 1)
abstract class NumbersDatabase: RoomDatabase() {
    abstract fun getNoteDao(): NumbersDao

    companion object {
        private var database: NumbersDatabase ?= null

        @Synchronized
        fun getInstance(context: Context): NumbersDatabase{
            return if (database == null){
                database = Room.databaseBuilder(context, NumbersDatabase::class.java, "db").build()
                database as NumbersDatabase
            }
            else  database as NumbersDatabase
        }
    }
}