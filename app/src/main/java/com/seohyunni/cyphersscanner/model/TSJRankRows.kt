package com.seohyunni.cyphersscanner.model

import com.google.gson.annotations.SerializedName

data class TSJRankRows(
    @SerializedName("rank") val rank: Int,
    @SerializedName("playerId") val playerId: String,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("ratingPoint") val ratingPoint: Int,
    @SerializedName("winCount") val winCount: Int,
    @SerializedName("loseCount") val loseCount: Int,
    @SerializedName("winningStreak") val winningStreak: Int,
)