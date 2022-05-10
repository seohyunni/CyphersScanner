package com.seohyunni.cyphersscanner.model

import com.google.gson.annotations.SerializedName

data class Position(
    @SerializedName("name") val name: String,
    @SerializedName("explain") val explain: String,
    @SerializedName("attribute") val attribute: List<Attribute>,
)