package com.example.roomdemo.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDAO {
    @Insert
    //suspend to work as a background
    suspend fun addStudent(student: Student)

    @Query("Select * from student_table")
    suspend fun getAllStudent(): Array<Student>
}