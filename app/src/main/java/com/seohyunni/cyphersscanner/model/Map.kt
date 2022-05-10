package com.seohyunni.cyphersscanner.model

import com.google.gson.annotations.SerializedName

data class Map(
    @SerializedName("mapId") val mapId: String,
    @SerializedName("name") val name: String,
)