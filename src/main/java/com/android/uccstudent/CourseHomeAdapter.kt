package com.android.uccstudent

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CourseAdapter : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    private var courseList = emptyList<Courses>()

    class CourseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        return CourseViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.content_courses, parent, false))
    }

    //returns size of course array
    override fun getItemCount(): Int {
        return courseList.size
    }

    //function that checks each course ID and updates the recycle view with pictured for each
    //courses
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val currentItem = courseList[position]
        val courseImageView = holder.itemView.findViewById<ImageView>(R.id.courseImage)

        if(currentItem.courseId == "ITT200"){
            courseImageView.setImageResource(R.drawable.ic_cpp)

        }else if(currentItem.courseId == "ITT210"){
            courseImageView.setImageResource(R.drawable.database)

        }else if(currentItem.courseId == "ITT211"){
            courseImageView.setImageResource(R.drawable.dataanalysis)

        }else if(currentItem.courseId == "ITT208"){
            courseImageView.setImageResource(R.drawable.internetauth1)

        }else if(currentItem.courseId == "ITT303"){
            courseImageView.setImageResource(R.drawable.internetauth2)
        }else if(currentItem.courseId == "ITT116"){
            courseImageView.setImageResource(R.drawable.troubleshooting1)

        }else if(currentItem.courseId == "ITT101") {
            courseImageView.setImageResource(R.drawable.cis)

        }else if(currentItem.courseId == "ITT403") {
            courseImageView.setImageResource((R.drawable.datacommunications))

        }else if(currentItem.courseId =="ITT215"){
            courseImageView.setImageResource((R.drawable.digitalmedia))
        }else{
            courseImageView.setImageResource(R.drawable.troubleshooting2)
        }

        //pass data to each textview with the data stored in the database

        holder.itemView.findViewById<TextView>(R.id.code).text = "Course Code: "+currentItem.courseId
        holder.itemView.findViewById<TextView>(R.id.name).text = "Course Name: "+currentItem.courseName
        holder.itemView.findViewById<TextView>(R.id.preReq).text = "Prerequisite: "+currentItem.preRequisite
        holder.itemView.findViewById<TextView>(R.id.desc).text = "Description: "+currentItem.description
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(course: List<Courses>){
        this.courseList = course
        notifyDataSetChanged()
    }

}