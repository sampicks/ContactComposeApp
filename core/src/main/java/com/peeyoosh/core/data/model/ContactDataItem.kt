package com.peeyoosh.core.data.model

import com.google.gson.annotations.SerializedName

data class ContactDataItem(
    val id: Int,
    @SerializedName("contact_name")
    val contactName: String,
    @SerializedName("contact_no")
    val contactNo: String,
    @SerializedName("is_sync")
    val isSync: Boolean
)