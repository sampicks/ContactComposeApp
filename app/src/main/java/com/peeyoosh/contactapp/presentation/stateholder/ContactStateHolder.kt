package com.peeyoosh.contactapp.presentation.stateholder

import com.peeyoosh.core.domain.model.ContactDomainModel

data class ContactStateHolder(
    val isLoading: Boolean = false,
    val data: List<ContactDomainModel>? = null,
    val error: String = ""
)
