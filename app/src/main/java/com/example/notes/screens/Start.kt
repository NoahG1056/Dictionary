package com.example.notes.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notes.navigation.NavRoute
import com.example.notes.ui.theme.NotesTheme

@Composable
fun StartScreen(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    )
    {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Text(text = "Choose what u want")
            Button(onClick = {
                             navController.navigate(route = NavRoute.Main.route)
                             },
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 5.dp)
            ) {
                Text(text = "Room")
            }
            Button(onClick = {
                navController.navigate(route = NavRoute.Add.route)
            },
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 5.dp)
            ) {
                Text(text = "firebase")
            }

        }
    }
    
}
@Preview(showBackground = true)
@Composable
fun prevStartScreen(){
    NotesTheme() {
        StartScreen(navController = rememberNavController())
    }
}