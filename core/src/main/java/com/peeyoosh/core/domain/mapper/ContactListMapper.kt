package com.peeyoosh.core.domain.mapper

import com.peeyoosh.core.data.model.ContactDataItem
import com.peeyoosh.core.domain.model.ContactDomainModel
import javax.inject.Inject

class ContactListMapper @Inject constructor() {

    fun convertDataToDomain(contactDataItem: ContactDataItem): ContactDomainModel {
        return ContactDomainModel(
            id = contactDataItem.id,
            contactName = contactDataItem.contactName,
            contactNo = contactDataItem.contactNo,
            isSync = contactDataItem.isSync
        )
    }

    fun convertDomainToData(contactDomainModel: ContactDomainModel): ContactDataItem {
        return ContactDataItem(
            id = contactDomainModel.id,
            contactName = contactDomainModel.contactName,
            contactNo = contactDomainModel.contactNo,
            isSync = contactDomainModel.isSync
        )
    }
}