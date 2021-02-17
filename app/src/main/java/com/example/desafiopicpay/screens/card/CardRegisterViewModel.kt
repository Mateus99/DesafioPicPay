package com.example.desafiopicpay.screens.card

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModel

class CardRegisterViewModel : ViewModel() {

    fun saveData(
        context: Activity,
        cardNumber: String,
        cardName: String,
        expireDate: String,
        cvv: String
    ) {

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

    fun loadData(
        context: Activity,
        cardNumber: EditText,
        cardName: EditText,
        expireDate: EditText,
        cvv: EditText
    ) {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)

        val savedCardNumber = sharedPreferences.getString("cardNumber", null)
        val savedCardName = sharedPreferences.getString("cardName", null)
        val savedExpireDate = sharedPreferences.getString("expireDate", null)
        val savedCvv = sharedPreferences.getString("cvv", null)

        cardNumber.setText(savedCardNumber)
        cardName.setText(savedCardName)
        expireDate.setText(savedExpireDate)
        cvv.setText(savedCvv)

    }

    fun checkEdits(
        cardNumber: String,
        cardName: String,
        expireDate: String,
        cvv: String,
        finishRegister: Button
    ) {
        if (cardNumber != "" && cardName != "" && expireDate != "" && cvv != "") {
            finishRegister.visibility = View.VISIBLE
        } else {
            finishRegister.visibility = View.GONE
        }
    }


}