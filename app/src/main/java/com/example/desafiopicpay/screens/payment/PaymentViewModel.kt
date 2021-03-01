package com.example.desafiopicpay.screens.payment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiopicpay.repository.UsersRepository
import kotlinx.coroutines.launch


class PaymentViewModel(val repository: UsersRepository) : ViewModel() {

//    val transaction = MutableLiveData<Transaction>()
//
//    fun makePayment() {
//
//        val paymentInfo = Payment(
//            cardNumber = "1111111111111111",
//            cvv = 789,
//            value = 79.9,
//            expireDate = "01/18",
//            userIdDestination = 1002
//        )
//
//        viewModelScope.launch {
//            val transactionPayment = repository.makePayment(paymentInfo)
//
//            transactionPayment?.let {
//                transaction.value = it
//            }
//
//        }
//
//
//
//    }

}