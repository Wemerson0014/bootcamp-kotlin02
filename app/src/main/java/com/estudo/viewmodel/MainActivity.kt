package com.estudo.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var edit_values: EditText
    lateinit var button_data: Button
    lateinit var button_show: Button

    var accountant: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initAccountant()
        initCLick()
        validatorAccountant()
    }

    private fun validatorAccountant() {
        if (accountant > 5) {
            accountant = 0
        }
    }

    private fun initCLick() {
        button_data.setOnClickListener {
            accountant++
            validatorAccountant()
            initAccountant()
        }
        
        button_show.setOnClickListener {
            Toast.makeText(this, accountant.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun initAccountant() {
        edit_values.setText(accountant.toString())
    }

    private fun initData() {
        edit_values = findViewById(R.id.edit_values)
        button_data = findViewById(R.id.button_data)
        button_show = findViewById(R.id.button_show)
    }
}