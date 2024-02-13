package com.peeyoosh.core.data.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

/**
 **  Secure shared preferences
 **/
object SecurePref {

    const val PREF_KEY_NAME = "pref_name"
    const val PREF_KEY_AGE = "pref_age"
    const val PREFERENCE_NAME = "preference_name"

    fun getSecurePreference(context: Context) : SharedPreferences{
        // on below line we are getting data from encrypted shared preferences.
        // creating a master key for encryption of shared preferences.
        val masterKey = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        // Initialize/open an instance of EncryptedSharedPreferences on below line.
        return EncryptedSharedPreferences.create(
            context,
            PREFERENCE_NAME,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }
}