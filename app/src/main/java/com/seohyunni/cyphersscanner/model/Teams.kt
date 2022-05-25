package com.seohyunni.cyphersscanner.model

import com.google.gson.annotations.SerializedName

class Teams(
    @SerializedName("result") val result: String,
    @SerializedName("players") val players: List<String>,
)
