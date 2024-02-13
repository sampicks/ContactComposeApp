package com.peeyoosh.core.data.network

import com.peeyoosh.core.data.model.ContactDataItem
import retrofit2.http.GET

interface ApiInterface {
    companion object {
        val BASE_URL: String = "https://retoolapi.dev/"
    }

    @GET("7W0DK6/contactsData")
    suspend fun getContactList(): List<ContactDataItem>

}