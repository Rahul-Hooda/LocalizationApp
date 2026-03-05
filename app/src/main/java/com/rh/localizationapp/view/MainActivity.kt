package com.rh.localizationapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rh.localizationapp.R
import com.rh.localizationapp.viewModel.LocalizationViewModel
import com.rh.localizationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mViewModel: LocalizationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initViewModel()
        initObservers()
    }

    private fun initObservers() {
        mViewModel.helloWorldText.observe(this, Observer {
            binding.tvHelloWorld.text = it
        })
    }

    private fun initViewModel() {
        mViewModel = ViewModelProvider(this).get(LocalizationViewModel::class.java)
        binding.viewModel = mViewModel
    }
}