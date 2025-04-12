package com.android.uccstudent

import androidx.room.Entity
import androidx.room.PrimaryKey

//course data class
@Entity(tableName = "CourseData")
data class Courses (
    @PrimaryKey val courseId: String,
    val courseName: String,
    val preRequisite: String,
    val description: String
)