package com.seohyunni.cyphersscanner.model

import com.google.gson.annotations.SerializedName

data class MatchInfo(
    @SerializedName("date") val date: DateInfo,
    @SerializedName("gameTypeId") val gameTypeId: String,
)
