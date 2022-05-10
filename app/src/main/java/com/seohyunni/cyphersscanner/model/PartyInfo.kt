package com.seohyunni.cyphersscanner.model

import com.google.gson.annotations.SerializedName

data class PartyInfo(
    @SerializedName("playerId") val playerId: String,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("characterId") val characterId: String,
    @SerializedName("characterName") val characterName: String
)