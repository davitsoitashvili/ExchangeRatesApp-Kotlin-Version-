package com.example.exchangeratesapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



val BASE_URL = "https://currencyratesapi.herokuapp.com/"

private var retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var apiHolder: ApiHolder = retrofit.create(ApiHolder::class.java)




