package com.peeyoosh.core.data.repository

import com.peeyoosh.core.data.network.ApiInterface
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ContactRepository @Inject constructor(val apiInterface: ApiInterface) {

//    suspend fun getContactList() = flow {
//        emit(apiInterface.getContactList())
//    }
    suspend fun getContactList() = apiInterface.getContactList()
}