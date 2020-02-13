package com.example.exchangeratesapp

import com.google.gson.annotations.SerializedName

//Bank-ის მოდელის შექმნა

data class BankModel (
    @SerializedName("bank_name")
    var bankName : String,
    @SerializedName("image_url")
    var image : String
)