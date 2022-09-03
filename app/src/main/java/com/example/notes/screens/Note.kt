package com.example.notes.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notes.ui.theme.NotesTheme

@Composable
fun NoteScreen(navController: NavHostController) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment =Alignment.CenterHorizontally , verticalArrangement = Arrangement.Center) {
            Card(modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)) {
                Column(modifier = Modifier.padding(vertical = 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Title", modifier = Modifier.padding(top=32.dp))
                    Text(text = "SubTitle", modifier = Modifier.padding(top=32.dp))


                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun prevNoteScreen(){
    NotesTheme {
        NoteScreen(navController = rememberNavController())

    }
}