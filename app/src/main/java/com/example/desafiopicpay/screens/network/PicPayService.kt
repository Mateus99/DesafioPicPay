package com.example.desafiopicpay.screens.network

import com.example.desafiopicpay.screens.users.User
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://careers.picpay.com/tests/mobdev/"

//Cria um objeto "Moshi"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//Instanciando e criando o objeto do retrofit
private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

//Fazendo a requisição na API e salvando o resultado em uma lista de usuários
interface PicPayService{
    @GET("users")
    suspend fun getProperties(): MutableList<User>
}

//Esqueci exatamente pra q serve isso
object PicPayApi{
    val retrofitService: PicPayService by lazy {
        retrofit.create(PicPayService::class.java)
    }
}