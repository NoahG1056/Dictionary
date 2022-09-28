package com.example.notes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notes.MainViewModel
import com.example.notes.screens.*
import com.example.utils.Constants
import com.example.utils.Constants.Screens.ADD_SCREEN
import com.example.utils.Constants.Screens.LEARN_SCREEN
import com.example.utils.Constants.Screens.MAIN_SCREEN
import com.example.utils.Constants.Screens.NOTE_SCREEN
import com.example.utils.Constants.Screens.START_SCREEN

sealed class NavRoute(val route:String){
    object Start:NavRoute(START_SCREEN)
    object Main:NavRoute(MAIN_SCREEN)
    object Add:NavRoute(ADD_SCREEN)
    object Note:NavRoute(NOTE_SCREEN)
    object Learn:NavRoute(LEARN_SCREEN)



}
@Composable
fun NotesNavHost(mViewModel:MainViewModel) {
    val navController= rememberNavController()
    NavHost(navController=navController, startDestination = NavRoute.Start.route){
        composable(NavRoute.Start.route){

            StartScreen(navController= navController, viewModel=mViewModel )
        }
        composable(NavRoute.Add.route){
            AddScreen(navController= navController,viewModel=mViewModel)
        }
        composable(NavRoute.Main.route){
            MainScreen(navController= navController,viewModel=mViewModel)
        }
        composable(NavRoute.Note.route+"/{${Constants.Keys.ID}}"){backStackEntry->
            NoteScreen(navController= navController,viewModel=mViewModel,noteId=backStackEntry.arguments?.getString(Constants.Keys.ID))
        }
        composable(NavRoute.Learn.route +"/{${Constants.Keys.ID}}" ){backStackEntry->

            LearnScreen(navController= navController,viewModel=mViewModel,noteId=backStackEntry.arguments?.getString(Constants.Keys.ID))
        }
    }
}