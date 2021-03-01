package com.example.desafiopicpay.repository

import androidx.lifecycle.MutableLiveData
import com.example.desafiopicpay.screens.network.PicPayApi
import com.example.desafiopicpay.screens.payment.Payment
import com.example.desafiopicpay.screens.payment.Transaction
import com.example.desafiopicpay.screens.users.User
import retrofit2.Call

class UsersRepository {

    val properties = MutableLiveData<MutableList<User>>()

    suspend fun getPicPayUsers() {
        try {
            properties.value = PicPayApi.retrofitService.getProperties()

        } catch (e: Exception) {
            println("ERRO: $e")
        }

    }

//    suspend fun makePayment(
//        paymentInfo: Payment
//    ): Transaction? {
//
//        try{
//
//            val transaction = PicPayApi.retrofitService.makePayment(paymentInfo)
//            transaction.enqueue()
//
//        } catch(e: Exception){
//            println("Erro: $e")
//        }
//        return null
//    }

}