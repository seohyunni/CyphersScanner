package com.seohyunni.cyphersscanner.model

import com.google.gson.annotations.SerializedName

class PlayerMatch(
    @SerializedName("playerId") val playerId: String = "",
    @SerializedName("nickname") val nickname: String = "",
    @SerializedName("grade") val grade: Int,
    @SerializedName("clanName") val clanName: String = "",
    @SerializedName("ratingPoint") val ratingPoint: Int,
    @SerializedName("maxRatingPoint") val maxRatingPoint: Int,
    @SerializedName("tierName") val tierName: String = "",
    @SerializedName("records") val records: List<Records>,
    @SerializedName("matches") val matches: MatchInfo,
    @SerializedName("playInfo") val play: PlayInfo,
)
