package com.seohyunni.cyphersscanner.model

import com.google.gson.annotations.SerializedName

data class DateInfo(
    @SerializedName("start") val start: String,
    @SerializedName("end") val end: String,
)