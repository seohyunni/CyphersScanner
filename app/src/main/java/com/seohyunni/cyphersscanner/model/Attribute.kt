package com.seohyunni.cyphersscanner.model

import com.google.gson.annotations.SerializedName

data class Attribute(
    @SerializedName("level") val level: Int,
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String
)