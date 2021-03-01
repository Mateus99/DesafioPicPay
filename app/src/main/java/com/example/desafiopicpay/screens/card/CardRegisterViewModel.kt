package com.example.desafiopicpay.screens.card

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CardRegisterViewModel() : ViewModel() {

    var cardNumber = ""
    var cardName = ""
    var expireDate = ""
    var cvv = ""

    private val _btnVisibility = MutableLiveData<Boolean>()

    val btnVisibility: LiveData<Boolean>
        get() = _btnVisibility

    fun saveData(context: Activity) {

        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putString("cardNumber", cardNumber)
            putString("cardName", cardName)
            putString("expireDate", expireDate)
            putString("cvv", cvv)
        }.apply()

    }

    fun loadData(context: Activity): List<String?> {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)

        val savedCardNumber = sharedPreferences.getString("cardNumber", null)
        val savedCardName = sharedPreferences.getString("cardName", null)
        val savedExpireDate = sharedPreferences.getString("expireDate", null)
        val savedCvv = sharedPreferences.getString("cvv", null)

        return listOf(savedCardNumber, savedCardName, savedExpireDate, savedCvv)

    }

    fun verifyData() {
        _btnVisibility.value = (cardNumber.isNotEmpty() || cardNumber != "") && (cardName.isNotEmpty() || cardName != "") && (expireDate.isNotEmpty() || expireDate != "") && (cvv.isNotEmpty() || cvv != "")
    }

}