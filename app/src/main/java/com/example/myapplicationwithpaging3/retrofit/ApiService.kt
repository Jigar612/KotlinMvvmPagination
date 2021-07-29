package com.example.myapplicationwithpaging3.retrofit

import com.example.myapplicationwithpaging3.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object{
        val BASE_URL = "https://reqres.in/api/"
    }
    @GET("users")
    suspend fun getList(@Query("page") page: Int, @Query("per_page") perPage: Int): UserResponse
}