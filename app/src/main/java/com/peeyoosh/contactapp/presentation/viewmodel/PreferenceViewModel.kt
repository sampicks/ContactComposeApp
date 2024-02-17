package com.peeyoosh.contactapp.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peeyoosh.core.domain.usecase.PreferenceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PreferenceViewModel @Inject constructor(
    private val preferenceUseCase: PreferenceUseCase
) : ViewModel() {

    val nameMutableState = mutableStateOf("")
    val ageMutableState = mutableStateOf("")

    init {
        getProfileData()
    }

    private fun getProfileData() = viewModelScope.launch {
        nameMutableState.value = preferenceUseCase.getName().toString()
        ageMutableState.value = preferenceUseCase.getAge().toString()
    }

    fun saveDetails(name: String?, age: String?) {
        preferenceUseCase.saveDetails(name, age)
    }
}