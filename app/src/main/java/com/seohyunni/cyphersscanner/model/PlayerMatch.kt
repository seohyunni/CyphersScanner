package com.seohyunni.cyphersscanner.model

import com.google.gson.annotations.SerializedName

class PlayerMatch(
    @SerializedName("playerInfo") val playerInfo: PlayerInfo,
    @SerializedName("matches") val matches: MatchInfo,
)
