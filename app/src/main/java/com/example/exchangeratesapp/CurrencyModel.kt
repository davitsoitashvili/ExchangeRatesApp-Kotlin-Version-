package com.example.exchangeratesapp

import com.google.gson.annotations.SerializedName

data class CurrencyModel(
    @SerializedName("sell_USD")
    var sellUSD: String,
    @SerializedName("buy_USD")
    var buyUSD: String,
    @SerializedName("sell_EUR")
    var sellEUR: String,
    @SerializedName("buy_EUR")
    var buyEUR: String
)