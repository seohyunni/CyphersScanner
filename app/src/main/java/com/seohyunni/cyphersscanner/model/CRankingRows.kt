package com.seohyunni.cyphersscanner.model

import com.google.gson.annotations.SerializedName

data class CRankingRows(
    @SerializedName("rank") val rank: Int,
    @SerializedName("playerId") val playerId: String,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("exp") val exp: Int
)