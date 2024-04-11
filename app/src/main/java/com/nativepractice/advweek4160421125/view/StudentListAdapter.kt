package com.nativepractice.advweek4160421125.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.nativepractice.advweek4160421125.R
import com.nativepractice.advweek4160421125.databinding.StudentListItemBinding
import com.nativepractice.advweek4160421125.model.Student
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.util.concurrent.Callable

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
        val picasso = Picasso.Builder(holder.itemView.context)
        picasso.listener { picasso, uri, exception ->
            exception.printStackTrace()
        }
        picasso.build().load(studentList[position].photoUrl).into(holder.binding.imageView)
        picasso.build().load(studentList[position].photoUrl)
            .into(holder.binding.imageView, object:Callback {
                override fun onSuccess() {
                    holder.binding.progressImage.visibility = View.INVISIBLE
                    holder.binding.imageView.visibility = View.VISIBLE
                }

                override fun onError(e: Exception?) {
                    Log.e("picasso_error", e.toString())
                }
            })

//        val url = studentList[position].photoUrl
//        val builder = Picasso.Builder(holder.itemView.context)
//        builder.listener { picasso, uri, exception ->  exception.printStackTrace() }
//        Picasso.get().load(url).into(holder.binding.imageView)
        holder.binding.btnDetail.setOnClickListener {
            val studentId = studentList[position].id
            val action = StudentListFragmentDirections.actionStudentDetail(studentId.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }
}