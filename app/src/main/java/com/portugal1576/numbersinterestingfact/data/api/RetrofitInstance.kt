package com.portugal1576.numbersinterestingfact.data.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


object RetrofitInstance {
    private val gson = GsonBuilder()
        .setLenient()
        .create()
    private val retrofit by lazy {
        Retrofit
            .Builder()
            .baseUrl("http://numbersapi.com/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
    val api: NumbersService by lazy {
        retrofit.create(NumbersService::class.java)
    }
}
