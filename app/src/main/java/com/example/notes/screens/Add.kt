package com.example.notes.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.notes.MainViewModel
import com.example.database.room.model.Note
import com.example.notes.R
import com.example.notes.navigation.NavRoute
import com.example.notes.ui.theme.NotesTheme
import com.example.utils.Constants.Keys.ADD_NEW_TERM


@Composable
fun AddScreen(navController: NavHostController, viewModel: MainViewModel) {
    var title by remember{ mutableStateOf("")}
    var subtitle by remember{ mutableStateOf("")}
    var isButtonEnabled by remember{ mutableStateOf(false)}
    Scaffold (topBar = {
        Image(
            painter = painterResource(R.drawable.fon),
            contentDescription = "Contact profile picture"

        )
    }){

        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center ) {
            Text(text = ADD_NEW_TERM, fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(8.dp))
            OutlinedTextField(value = title,
                onValueChange ={

                    title=it
                    isButtonEnabled
                               },
                label = { Text(text = "Term")
                },
                isError = title.isEmpty()
                )

            OutlinedTextField(value = subtitle,
                onValueChange ={

                    subtitle=it
                    isButtonEnabled=title.isNotEmpty()&& subtitle.isNotEmpty()
                               },
                label = { Text(text = "Definition")},
                isError = subtitle.isEmpty())
            Button(modifier = Modifier.padding(16.dp),
                enabled = isButtonEnabled,
                onClick = {
                viewModel.addNote(note= Note(title = title, subtitle = subtitle)){
                    navController.navigate(NavRoute.Main.route)
                }
                }) {
                Text(text = "Done")

            }
        }

    }
}
@Preview(showBackground = true)
@Composable
fun prevAddScreen(){
    NotesTheme() {

//        AddScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}