package com.portugal1576.numbersinterestingfact.data.repository

import com.portugal1576.numbersinterestingfact.data.api.RetrofitInstance

class NumbersRepository {
    suspend fun getFact(number: String): String {
        return RetrofitInstance.api.getFactNumber(number)
    }
}