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

class DetailViewModel(application: Application) : AndroidViewModel(application) {
    val studentLD = MutableLiveData<Student>()
    fun fetch(studentId: String) {
        val url = "http://adv.jitusolution.com/student.php?id=$studentId"
        val requestQueue = Volley.newRequestQueue(getApplication() as Context)
        val request = StringRequest(Request.Method.GET, url,
            { response ->
                val gson = Gson()
                val student = gson.fromJson(response, Student::class.java)
                studentLD.postValue(student)
            },
            { error ->
                error.printStackTrace()
            })

        // Add the request to the RequestQueue.
        Volley.newRequestQueue(getApplication<Application>().applicationContext).add(request)
    }

}