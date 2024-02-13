package com.peeyoosh.contactapp.presentation.views.screens

sealed class Screens(val route: String){
    object ContactListScreen : Screens("contact_list")
    object MyProfileScreen : Screens("my_profile")
}
