package com.seohyunni.cyphersscanner.model

import com.google.gson.annotations.SerializedName

class Items(
    @SerializedName("itemId") val itemId: String,
    @SerializedName("itemName") val itemName: String,
    @SerializedName("slotCode") val slotCode: String,
    @SerializedName("slotName") val slotName: String,
    @SerializedName("rarityCode") val rarityCode: String,
    @SerializedName("rarityName") val rarityName: String,
    @SerializedName("equipSlotCode") val equipSlotCode: String,
    @SerializedName("equipSlotName") val equipSlotName: String,
)
