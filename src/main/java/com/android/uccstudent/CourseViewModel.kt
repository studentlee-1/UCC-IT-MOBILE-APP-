package com.android.uccstudent

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CourseViewModel(application: Application) : AndroidViewModel(application) {

    val courseData: LiveData<List<Courses>>
    private val courseRepository: CourseRepository

    init {
        val courseAccessObject = CourseDb.launchCourseData(application).courseDoa()
        courseRepository = CourseRepository(courseAccessObject)
        courseData = courseRepository.courseData
    }

    fun addCourse(course: Courses){
        viewModelScope.launch(Dispatchers.IO) { courseRepository.addCourse(course) }
    }
}