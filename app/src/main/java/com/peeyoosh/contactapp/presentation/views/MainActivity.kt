package com.peeyoosh.contactapp.presentation.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.peeyoosh.contactapp.presentation.ui.theme.ContactAppTheme
import com.peeyoosh.contactapp.presentation.viewmodel.ContactViewModel
import com.peeyoosh.contactapp.presentation.views.navigation.NavGraph
import com.peeyoosh.core.domain.model.ContactDomainModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
//    private val viewModel: ContactViewModel by viewModels()
    private val mutableState = mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ContactAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navHostController = rememberNavController()
                    NavGraph(navHostController = navHostController)
                }
            }
        }
    }



    /*   fun loadListData() {  // use with activity/fragment with xml layouts
           viewModel.liveData.observe(
               this,
               object : Observer<NetworkResult<List<ContactDomainModel>>> {
                   override fun onChanged(value: NetworkResult<List<ContactDomainModel>>) {
                       value.let {
                           when (it) {
                               is NetworkResult.Loading -> Log.e("======", "========= Loading started")
                               is NetworkResult.Success -> {
                                   it.data.forEach {
                                       mutableList.add( it)
                                   }
   //                                mutableList = it.data as MutableList<ContactDomainModel>
                                   Log.e("======", "========= Data Loaded =========")
                                   mutableState.value = "list update with ${it.data.size}"
                                   Log.e("========","======== list item size : ${mutableList.size}")
                               }
                               is NetworkResult.Failure -> Log.e("======", "========= result failure")
                           }
                       }
                   }
               })
       }*/


}

