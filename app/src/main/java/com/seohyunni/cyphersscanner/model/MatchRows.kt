package com.seohyunni.cyphersscanner.model

import com.google.gson.annotations.SerializedName

data class MatchRows(
    @SerializedName("date") val date: String,
    @SerializedName("matchId") val matchId: String,
    @SerializedName("map") val map: Map,
    @SerializedName("position") val position: Position
)