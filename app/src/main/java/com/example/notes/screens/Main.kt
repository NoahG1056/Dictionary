package com.example.notes.screens

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notes.MainViewModel
import com.example.notes.MainViewModelFactory
import com.example.notes.R
import com.example.database.room.model.Note
import com.example.notes.navigation.NavRoute
import com.example.notes.ui.theme.NotesTheme

@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel) {
    val notes= viewModel.readAllNotes().observeAsState(listOf()).value
    Scaffold(topBar = {
        Image(
        painter = painterResource(R.drawable.fon),
        contentDescription = "Contact profile picture"

    )
    },
        floatingActionButton = {
        FloatingActionButton(
            onClick = { navController.navigate(NavRoute.Add.route)}
        ) {
            Icon(tint = Color.White, imageVector = Icons.Filled.Add, contentDescription = "Add Icons")
        }
    }) {
//        Column() {
//            NoteItem(title = "any", subtitle = "any",navController=navController)
//            NoteItem(title = "any", subtitle = "any",navController=navController)
//            NoteItem(title = "any", subtitle = "any",navController=navController)
//            NoteItem(title = "any", subtitle = "any",navController=navController)
//        }
        LazyColumn{
            items(notes){note->
                NoteItem(note = note, navController = navController)
            }
        }


    }
}
@Composable
fun NoteItem(note:Note,navController:NavHostController){
    Card(shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .clickable { navController.navigate(NavRoute.Note.route+"/${note.id}") },
        elevation = 6.dp
    ) {
        Column(modifier = Modifier.padding(vertical = 8.dp), horizontalAlignment =Alignment.CenterHorizontally ) {
            Text(text = note.title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = note.subtitle)
        }

    }
}
@Preview(showBackground = true)
@Composable
fun prevMainScreen(){
    NotesTheme {
        val context= LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        MainScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}