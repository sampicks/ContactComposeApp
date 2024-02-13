package com.peeyoosh.core.domain.usecase

import com.peeyoosh.core.common.NetworkResult
import com.peeyoosh.core.data.repository.ContactRepository
import com.peeyoosh.core.domain.mapper.ContactListMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ContactListUseCase @Inject constructor(
    val contactRepository: ContactRepository,
    val contactListMapper: ContactListMapper
) {

    // without flow
    //    suspend fun getContactList(): List<ContactDomainModel> =contactRepository.getContactList().map {
//        contactListMapper.convertDataToDomain(it)
//    }

    // with flow but repository without flow
    suspend fun getContactList() = flow {
        //loading state
        emit(NetworkResult.Loading(true))

        val list = contactRepository.getContactList().map {
            contactListMapper.convertDataToDomain(it)
        }
        // result state
        emit(NetworkResult.Success(list))

    }.flowOn(Dispatchers.IO)
        .catch {
        // error state
        emit(NetworkResult.Failure(it.message ?: "Unknown Error"))
    }

}