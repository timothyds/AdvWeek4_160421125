package com.nativepractice.advweek4160421125.viewmodel
import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.nativepractice.advweek4160421125.model.Student

class DetailViewModel:ViewModel() {
    val studentLD = MutableLiveData<Student>()
    fun fetch(studentId: String, context: Context) {
        val url = "http://adv.jitusolution.com/student.php?id=$studentId"
        val stringRequest = StringRequest(Request.Method.GET, url,
            {
                response ->
                val student = Gson().fromJson<Student>(response, Student::class.java)
                studentLD.postValue(student)
            },
            {
                error->
                error.printStackTrace()
            })
        Volley.newRequestQueue(context).add(stringRequest)
    }

}