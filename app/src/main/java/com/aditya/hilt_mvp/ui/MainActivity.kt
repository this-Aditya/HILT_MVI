package com.aditya.hilt_mvp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.aditya.hilt_mvp.MainStateEvent
import com.aditya.hilt_mvp.MainViewModel
import com.aditya.hilt_mvp.databinding.ActivityMainBinding
import com.aditya.hilt_mvp.model.User
import com.aditya.hilt_mvp.utils.DataState
import dagger.hilt.android.AndroidEntryPoint
import java.lang.StringBuilder

private const val TAG = "MainActivity"
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textview.visibility = View.INVISIBLE
        viewModel.setStateEvent(MainStateEvent.GetUserEvent)
    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(this, Observer { dataState ->
            when (dataState) {
                is DataState.Success<List<User>> -> {
                    showProgressBar(false)
                    appendUserNames(dataState.data)
                }
                is DataState.Error -> {
                    showProgressBar(false)
                    displayError(dataState.ex.message)
                }
                is DataState.Loading -> {
                    showProgressBar(true)
                }
            }
        })
    }

    private fun displayError(message: String?) {
       binding.textview.text = message ?: "Unknown Error "
    }

    private fun showProgressBar(shouldShow: Boolean) {
        binding.progressBar.visibility = if (shouldShow) View.VISIBLE else View.GONE
    }

    private fun appendUserNames(users: List<User>) {
        val sb = StringBuilder()
        for(user in users) {
            sb.append("${user.name}\n")
        }
        binding.textview.visibility = View.VISIBLE
        binding.textview.text = sb.toString()
    }

}