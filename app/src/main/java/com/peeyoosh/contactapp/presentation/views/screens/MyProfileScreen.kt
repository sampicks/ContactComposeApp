package com.peeyoosh.contactapp.presentation.views.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.peeyoosh.contactapp.presentation.viewmodel.PreferenceViewModel


@Composable
fun MyProfileDetailScreen(navController: NavController, preferenceViewModel: PreferenceViewModel = hiltViewModel()) {

//    LocalContext.current
    EncryptedSharedPrefs(navController,preferenceViewModel)
}

@Composable
fun EncryptedSharedPrefs(navController: NavController, preferenceViewModel: PreferenceViewModel) {

    // on below line creating a variable for message.
    var name by remember {
        mutableStateOf(preferenceViewModel.nameMutableState.value)
    }
    var age by remember {
        mutableStateOf(preferenceViewModel.ageMutableState.value)
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
                preferenceViewModel.saveDetails(name, age)
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
