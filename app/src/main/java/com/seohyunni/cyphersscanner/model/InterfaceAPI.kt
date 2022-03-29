package com.seohyunni.cyphersscanner.model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface InterfaceAPI {

    @GET("/players")
    @Headers("Content-Type: application/json")
    fun searchPlayer(
        @Query("nickname")nickname : String,
        @Query("wordType")wordType : String
    ): Call<Players>

    companion object{
        fun create(): InterfaceAPI {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.neople.co.kr/cy")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(InterfaceAPI::class.java)
        }

    }
}