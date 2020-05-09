package com.example.myfirstapp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitRequest{

    private val baseURL = "http://13.209.144.115:3333/"

    var retrofit = Retrofit.Builder().baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service : RequestInterface = retrofit.create(
        RequestInterface::class.java)

}