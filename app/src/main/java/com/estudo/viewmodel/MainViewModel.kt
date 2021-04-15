package com.estudo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var mAccountant = MutableLiveData<String>().apply { value = accountant.toString() }
    private var accountant: Int = 0

    private fun setmAccountant() {
        mAccountant.value = accountant.toString()
    }

    private fun validatorAccountant() {
        accountant++
        if (accountant > 5) {
            accountant = 0
        }

        setmAccountant()
    }

    fun Accountant() {
        validatorAccountant()
    }
}