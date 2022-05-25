package com.seohyunni.cyphersscanner.model

import com.google.gson.annotations.SerializedName

data class RatingRows(
    @SerializedName("rank") val rank: Int,
    @SerializedName("playerId") val playerId: String,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("grade") val grade: Int,
    @SerializedName("ratingPoint") val ratingPoint: Int,
    @SerializedName("clanName") val clanName: String,
)