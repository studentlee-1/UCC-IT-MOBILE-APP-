package com.android.uccstudent

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CourseDoa {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCourse(course: Courses)

    @Query("SELECT * FROM CourseData")
    fun getCourses(): LiveData<List<Courses>>

}