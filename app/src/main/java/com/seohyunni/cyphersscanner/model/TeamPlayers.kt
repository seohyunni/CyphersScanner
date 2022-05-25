package com.seohyunni.cyphersscanner.model

import com.google.gson.annotations.SerializedName

class TeamPlayers(
    @SerializedName("playerId") val playerId: String,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("map") val map: Map,
    @SerializedName("playInfo") val playInfo: TeamPlayInfo,
    @SerializedName("position") val position: Position,
    @SerializedName("items") val items: List<Items>,
)
