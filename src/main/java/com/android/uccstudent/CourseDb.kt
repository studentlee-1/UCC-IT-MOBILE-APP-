package com.android.uccstudent

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.time.Instant


@Database(entities = [Courses::class], version=1, exportSchema = false)

abstract class CourseDb : RoomDatabase() {

    abstract fun courseDoa() : CourseDoa

    companion object {

        @Volatile
        private var INSTANCE: CourseDb? = null

        fun launchCourseData(context: Context) : CourseDb {

            val tempInstance = INSTANCE

            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CourseDb::class.java,
                    "courseDatabase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}