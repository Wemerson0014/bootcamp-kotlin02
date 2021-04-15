package com.estudo.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var editValues: EditText
    lateinit var buttonData: Button
    lateinit var buttonShow: Button

    lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initCLick()
    }

    private fun initData() {
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        editValues = findViewById(R.id.edit_values)
        buttonData = findViewById(R.id.button_data)
        buttonShow = findViewById(R.id.button_show)

        mViewModel.mAccountant.observe(this, Observer { value ->
            editValues.setText(value)
        })
    }

    private fun initCLick() {
        buttonData.setOnClickListener {
            mViewModel.Accountant()
        }

        buttonShow.setOnClickListener {
            Toast.makeText(applicationContext, "${mViewModel.mAccountant.value}", Toast.LENGTH_SHORT).show()
        }
    }
}