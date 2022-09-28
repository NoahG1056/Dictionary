package com.example.notes.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.notes.MainViewModel
import com.example.database.room.model.Note
import com.example.utils.Constants

@Composable
fun LearnScreen (navController: NavHostController, viewModel: MainViewModel, noteId: String?) {
    val notes = viewModel.readAllNotes().observeAsState(listOf()).value
    val note =notes.firstOrNull{it.id==noteId?.toInt()} ?: Note(title=Constants.Keys.NONE, subtitle = Constants.Keys.NONE)
    Scaffold {
        var visible by remember {
            mutableStateOf(true)
        }
        Column {
            Button(onClick = {visible=!visible}){
                Text("Click")
            }
            if (visible){
                Text(text ="visible")
            }
        }

    }
}