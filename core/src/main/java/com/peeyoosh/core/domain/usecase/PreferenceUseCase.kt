package com.peeyoosh.core.domain.usecase

import android.content.Context
import android.content.SharedPreferences
import com.peeyoosh.core.data.preferences.SecurePref
import javax.inject.Inject

class PreferenceUseCase @Inject constructor(context: Context) {

    private val sharedPreferences: SharedPreferences by lazy {
        SecurePref.getSecurePreference(context = context)
    }

    fun saveDetails(name: String?, age: String?) {
        sharedPreferences.edit().putString(SecurePref.PREF_KEY_NAME, name).apply()
        sharedPreferences.edit().putString(SecurePref.PREF_KEY_AGE, age).apply()
    }

    fun getName(): String? {
        return sharedPreferences.getString(SecurePref.PREF_KEY_NAME, "")
    }

    fun getAge(): String? {
        return sharedPreferences.getString(SecurePref.PREF_KEY_AGE, "")
    }
}