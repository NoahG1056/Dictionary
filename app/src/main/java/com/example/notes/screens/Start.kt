package com.example.notes.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.notes.MainViewModel
import com.example.notes.MainViewModelFactory
import com.example.notes.navigation.NavRoute
import com.example.utils.TYPE_ROOM
import com.example.notes.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.ui.res.painterResource


@Composable
fun StartScreen(navController: NavHostController, viewModel: MainViewModel) {
    val context= LocalContext.current
    val mViewModel:MainViewModel=
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Image(
                painter = painterResource(R.drawable.fon),
                contentDescription = "Contact profile picture"

                )

        }
    )
    {

        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Button(onClick = {
                mViewModel.initDataBase(TYPE_ROOM){
                    navController.navigate(route = NavRoute.Main.route)
                }
                             },

                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 5.dp)
            ) {
                Text(text = "Add or delete cards")
            }
            Button(onClick = {
                mViewModel.initDataBase(TYPE_ROOM){
                    navController.navigate(route = NavRoute.Learn.route)

                }
            },
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 5.dp)
            ) {
                Text(text = "learn cards")
            }

        }
    }

}
