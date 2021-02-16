package com.example.desafiopicpay.screens.payment

import com.google.gson.annotations.SerializedName

data class Card (
        @SerializedName("card_number") val cardNumber: Int?,
        @SerializedName("cvv") val cvv: Int?,
        @SerializedName("value") val value: Int?,
        @SerializedName("expiry_date") val expireDate: Int?,
        @SerializedName("destination_user_id") val userIdDestination: Int?
)