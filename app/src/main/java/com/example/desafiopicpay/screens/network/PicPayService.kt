package com.example.desafiopicpay.screens.network

import com.example.desafiopicpay.screens.payment.Payment
import com.example.desafiopicpay.screens.payment.Transaction
import com.example.desafiopicpay.screens.users.User
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

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
interface PicPayService {
    @GET("users")
    suspend fun getProperties(): MutableList<User>

    @Headers("Content-Type: application/json")
    @POST("paymentRequest")
    fun makePayment(@Body paymentData: Payment): Call<Transaction>

}

//Esqueci exatamente pra q serve isso
object PicPayApi {
    val retrofitService: PicPayService by lazy {
        retrofit.create(PicPayService::class.java)
    }
}