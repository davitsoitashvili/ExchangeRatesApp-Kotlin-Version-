package com.example.exchangeratesapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiHolder {
    @GET("{id}")
    abstract fun getCurrency(@Path("id") id: Int?): Call<CurrencyModel>

    @GET("banknames/{id}")
    abstract fun getBankNames(@Path("id") id:Int?): Call<BankModel>

}