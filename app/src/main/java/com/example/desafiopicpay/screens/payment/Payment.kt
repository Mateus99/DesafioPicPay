package com.example.desafiopicpay.screens.payment

import com.google.gson.annotations.SerializedName

data class Payment(
    @SerializedName("card_number") val cardNumber: String,
    @SerializedName("cvv") val cvv: Int,
    @SerializedName("value") val value: Double,
    @SerializedName("expiry_date") val expireDate: String,
    @SerializedName("destination_user_id") val userIdDestination: Int
)