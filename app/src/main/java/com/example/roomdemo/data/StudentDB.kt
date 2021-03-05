package com.example.roomdemo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1)
abstract  class StudentDB: RoomDatabase() {
    abstract fun studentDao(): StudentDAO

    //static
    companion object{
        private var INSTANCE : StudentDB? = null

        fun getDatabase(context: Context):StudentDB{
            synchronized(lock = this){
                var instance = INSTANCE

                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        StudentDB::class.java,
                        "Student_Database"
                    ).allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
        }
    }
}