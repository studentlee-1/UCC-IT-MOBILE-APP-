package com.android.uccstudent

import androidx.lifecycle.LiveData

class CourseRepository(private val courseAccessObject: CourseDoa) {

    val courseData: LiveData<List<Courses>> = courseAccessObject.getCourses()

    suspend fun addCourse(course: Courses) {
        courseAccessObject.addCourse(course)
    }


}