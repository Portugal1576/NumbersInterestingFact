package com.portugal1576.numbersinterestingfact.data.api

import retrofit2.http.GET
import retrofit2.http.Path

interface NumbersService {

    @GET("/{number}/math")
    suspend fun getFactNumber(
        @Path("number") number: String
    ): String

}