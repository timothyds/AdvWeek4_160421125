package com.nativepractice.advweek4160421125.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nativepractice.advweek4160421125.databinding.FragmentStudentDetailBinding
import com.nativepractice.advweek4160421125.viewmodel.DetailViewModel

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel:DetailViewModel
    private lateinit var binding:FragmentStudentDetailBinding
    fun observeStudent() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {

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