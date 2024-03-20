package com.nativepractice.advweek4160421125.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.nativepractice.advweek4160421125.R
import com.nativepractice.advweek4160421125.databinding.StudentListItemBinding
import com.nativepractice.advweek4160421125.model.Student

class StudentListAdapter (val studentList:ArrayList<Student>) :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(){
//    class StudentViewHolder (val view: View) :RecyclerView.ViewHolder(view)
    class StudentViewHolder(var binding: StudentListItemBinding) :RecyclerView.ViewHolder(binding.root)

    fun updateStudentList(newStudentList:ArrayList<Student>){
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
//        val inflater =LayoutInflater.from(parent.context)
//        val v = inflater.inflate(R.layout.student_list_item,parent,false)
//        return StudentViewHolder(v)
        val binding = StudentListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.binding.txtId.text = studentList[position].id
        holder.binding.txtName.text = studentList[position].name
        holder.binding.btnDetail.setOnClickListener {
            val action = StudentListFragmentDirections.actionStudentDetail()
            Navigation.findNavController(it).navigate(action)
        }
    }
}