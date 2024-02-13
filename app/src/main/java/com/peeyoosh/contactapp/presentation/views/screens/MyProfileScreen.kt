package com.peeyoosh.contactapp.presentation.views.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey


@Composable
fun MyProfileDetailScreen(navController: NavController) {
    // on below line we are getting data from encrypted shared preferences.
    // creating a master key for encryption of shared preferences.
    val masterKey = MasterKey.Builder(LocalContext.current, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    // Initialize/open an instance of EncryptedSharedPreferences on below line.
    val sharedPreferences = EncryptedSharedPreferences.create(
        LocalContext.current,
        "preferences",
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    val nameStr = sharedPreferences.getString("name", "name")
    val ageStr = sharedPreferences.getString("age", "age")


    EncryptedSharedPrefs(LocalContext.current,navController, nameStr, ageStr)
}

@Composable
fun EncryptedSharedPrefs(context: Context,navController: NavController, nameStr: String?, ageStr: String?) {

    // on below line creating a variable for message.
    var name by remember {
        mutableStateOf(nameStr ?: "")
    }
    var age by remember {
        mutableStateOf(ageStr ?: "")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Text(
            text = "Encrypted Shared Preferences in Android",
            color = Color.Green.copy(0.36f),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            placeholder = { Text(text = "Enter your name") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = age,
            onValueChange = { age = it },
            placeholder = { Text(text = "Enter your age") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            singleLine = true,
        )

        // on below line adding a spacer.
        Button(
            onClick = {
                saveData(context, name, age)
//                navController.popBackStack()  // move back to previous screen
                navController.popBackStack(Screens.ContactListScreen.route,inclusive = false)   // inclusive related with target route
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(text = "Save data to encrypted shared preferences", textAlign = TextAlign.Center)
        }
    }
}

private fun saveData(context: Context, name: String, age: String) {
    val masterKey = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    val sharedPreferences = EncryptedSharedPreferences.create(
        context,
        "preferences",
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    sharedPreferences.edit().putString("name", name).apply()
    sharedPreferences.edit().putString("age", age).apply()
}