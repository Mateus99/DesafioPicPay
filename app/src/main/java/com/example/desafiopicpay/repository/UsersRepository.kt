package com.example.desafiopicpay.repository

import androidx.lifecycle.MutableLiveData
import com.example.desafiopicpay.screens.network.PicPayApi
import com.example.desafiopicpay.screens.users.User

class UsersRepository {

    val properties = MutableLiveData<MutableList<User>>()

    suspend fun getPicPayUsers() {
        try {
            properties.value = PicPayApi.retrofitService.getProperties()

        } catch (e: Exception) {
            println("ERRO: $e")
        }

    }

}