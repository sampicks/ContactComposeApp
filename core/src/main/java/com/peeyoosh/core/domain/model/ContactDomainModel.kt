package com.peeyoosh.core.domain.model

data class ContactDomainModel(
    val id: Int,
    val contactName: String,
    val contactNo: String,
    val isSync: Boolean
)
