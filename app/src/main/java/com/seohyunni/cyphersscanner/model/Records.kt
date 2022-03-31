package com.seohyunni.cyphersscanner.model

import com.google.gson.annotations.SerializedName

data class Records(
    @SerializedName("gameTypeId") val gameTypeId: String = "",
    @SerializedName("winCount") val winCount: Int,
    @SerializedName("loseCount") val loseCount: Int,
    @SerializedName("stopCount") val stopCount: Int,
)
