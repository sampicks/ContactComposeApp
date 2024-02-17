package com.peeyoosh.contactapp.presentation.views.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.peeyoosh.contactapp.presentation.views.screens.LoadContactsData
import com.peeyoosh.contactapp.presentation.views.screens.MyProfileDetailScreen
import com.peeyoosh.contactapp.presentation.views.screens.Screens

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screens.ContactListScreen.route) {
        composable(Screens.ContactListScreen.route) {
            LoadContactsData(navHostController)
        }
        composable(Screens.MyProfileScreen.route) {
            MyProfileDetailScreen(navHostController)
        }
    }
}