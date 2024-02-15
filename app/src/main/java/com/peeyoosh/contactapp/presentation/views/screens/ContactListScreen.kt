package com.peeyoosh.contactapp.presentation.views.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.peeyoosh.contactapp.presentation.viewmodel.ContactViewModel
import com.peeyoosh.core.domain.model.ContactDomainModel

@Composable
fun LoadContactsData(navController: NavController, viewModel: ContactViewModel = hiltViewModel()) {
    val result = viewModel.contactList.value

    if (result.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    if(result.error.isNotEmpty()){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = result.error, style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
    if (result.data != null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
            result.data?.let {
                LazyColumn(modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 40.dp)) {
                    items(result.data) {
                        ListItem(contactDomainModel = it)
                    }
                }
            }
            Button(
                onClick = { navController.navigate(Screens.MyProfileScreen.route) },
                modifier = Modifier
                    .height(40.dp)
                    .padding(end = 10.dp),
                contentPadding = PaddingValues(horizontal = 15.dp)
            ) {
                Text(text = "Profile")  // padding = margin from parent, contentpadding = internal content padding from xml layout
            }
        }
    }
}

@Composable
fun ListItem(contactDomainModel: ContactDomainModel) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(6.dp),
        elevation = 5.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = contactDomainModel.contactName, style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Text(
                text = contactDomainModel.contactNo,
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.End
                ),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}
