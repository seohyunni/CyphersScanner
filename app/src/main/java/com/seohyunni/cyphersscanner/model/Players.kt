package com.seohyunni.cyphersscanner.model

import com.google.gson.annotations.SerializedName

class Players (
    @SerializedName("rows") val rows: List<PlayerResult>
)