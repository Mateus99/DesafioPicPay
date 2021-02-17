package com.example.desafiopicpay.screens.payment

import androidx.lifecycle.ViewModel
import com.example.desafiopicpay.screens.network.RestApiService


class PaymentViewModel : ViewModel() {


    fun makePayment() {
        val apiService = RestApiService()
        val paymentInfo = Payment(
            cardNumber = "1111111111111111",
            cvv = 789,
            value = 79.9,
            expireDate = "01/18",
            userIdDestination = 1002
        )

        apiService.makePayment(paymentInfo) {}

    }

}