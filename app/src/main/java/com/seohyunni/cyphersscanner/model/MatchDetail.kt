package com.seohyunni.cyphersscanner.model

import com.google.gson.annotations.SerializedName

class MatchDetail(
    @SerializedName("date") val date: String,
    @SerializedName("gameTypeId") val gameTypeId: String,
    @SerializedName("map") val map: Map,
    @SerializedName("teams") val teams: List<Teams>,
    @SerializedName("players") val players: List<TeamPlayers>
)