package com.peeyoosh.contactapp.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peeyoosh.contactapp.presentation.stateholder.ContactStateHolder
import com.peeyoosh.core.common.NetworkResult
import com.peeyoosh.core.domain.usecase.ContactListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    val contactListUseCase: ContactListUseCase,
) : ViewModel() {


//    private val _mutableLiveData = MutableLiveData<NetworkResult<List<ContactDomainModel>>>()
//    val liveData = _mutableLiveData // can't use in jetpack compose ui

    val contactList = mutableStateOf(ContactStateHolder())  // use with jetpack compose ui

    init {
//        contactListData()
        getContactList()
    }

    private fun getContactList() = viewModelScope.launch {
        contactListUseCase.getContactList().collectLatest {
            when (it) {
                is NetworkResult.Loading -> {
                    contactList.value = ContactStateHolder(isLoading = true)
                }
                is NetworkResult.Success -> {
                    contactList.value = ContactStateHolder(data = it.data)
                }

                is NetworkResult.Failure -> {
                    contactList.value = ContactStateHolder(error = it.errorMsg)
                }
            }

        }



    }

 /*   private fun contactListData() {   // can be use with activity/fragments with xml layouts
        viewModelScope.launch(Dispatchers.IO) {
            contactListUseCase.getContactList().collectLatest {
                _mutableLiveData.postValue(it)
            }

        }

    }*/
}