package com.nativepractice.advweek4160421125.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.vectordrawable.animated.R
import com.nativepractice.advweek4160421125.databinding.FragmentStudentDetailBinding
import com.nativepractice.advweek4160421125.viewmodel.DetailViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel:DetailViewModel
    private lateinit var binding:FragmentStudentDetailBinding
    fun observeStudent() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            var student = it
            binding.btnUpdate?.setOnClickListener {
                Observable.timer(5, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        Log.d("Messages", "five seconds")
                        MainActivity.showNotification(student.name.toString(),
                            "A new notification created",
                            R.drawable.notification_icon_background)
                    }
            }
            binding.txtId.setText(viewModel.studentLD.value?.id)
            binding.txtStudentName.setText(viewModel.studentLD.value?.name)
            binding.txtBoD.setText(viewModel.studentLD.value?.dob)
            binding.txtPhone.setText(viewModel.studentLD.value?.phone)
        })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentDetailBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()

        observeStudent()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}