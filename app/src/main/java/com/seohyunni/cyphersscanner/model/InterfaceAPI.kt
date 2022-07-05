package com.seohyunni.cyphersscanner.model

import android.media.Rating
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
        @Query("wordType")wordType : String?
    ): Call<Players>

    @GET("/players/:playerId")
    @Headers("Content-Type: application/json")
    fun searchPlayerInfo(
        @Path("playerId")playerId : String
    ): Call<PlayerInfo>

    @GET("/players/:playerId/matches")
    @Headers("Content-Type: application/json")
    fun searchMatching(
        @Path("playerId")playerId: String,
        @Query("gameTypeId")gameTypeId: String,
        @Query("startDate")startDate: String,
        @Query("endDate")endDate: String,
        @Query("limit")limit: Int,
        @Query("next")next: String
    ): Call<PlayerMatch>

    @GET("/matches/:matchId")
    @Headers("Content-Type: application/json")
    fun matchDetailInfo(
        @Path("matchId") matchId: String
    ) : Call<MatchDetail>

    @GET("/ranking/ratingpoint")
    @Headers("Content-Type: application/json")
    fun checkRatingPoint(
        @Query("rows") rows: List<RatingRows>
    )

    @GET("/ranking/characters/:characterId/:rankingType")
    @Headers("Content-Type: application/json")
    fun getCharacterRanking(
        @Query("rows") rows: List<CRankingRows>
    )

    @GET("/ranking/tsj/:tsjType")
    @Headers("Content-Type: application/json")
    fun getTsjRanking(
        @Query("rows") rows: List<TSJRankRows>
    )

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