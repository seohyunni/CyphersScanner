package com.seohyunni.cyphersscanner.model

import com.google.gson.annotations.SerializedName

class PlayerResult(
    @SerializedName("playerId") val playerId: String = "",
    @SerializedName("nickname") val nickname: String = "",
    @SerializedName("grade") val grade: Int
)