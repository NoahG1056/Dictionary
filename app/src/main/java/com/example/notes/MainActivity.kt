package com.example.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notes.navigation.NotesNavHost
import com.example.notes.ui.theme.NotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesTheme {
                Scaffold(topBar = {
                TopAppBar(title = { Text(text = "Notes APp")}, backgroundColor = Color.Cyan,
                    contentColor = Color.Gray,
                    elevation = 12.dp

                )
                                  },
                    content = {
                        Surface (
                            modifier = Modifier.fillMaxSize(),
                            color=MaterialTheme.colors.background
                        ){
                            NotesNavHost()
                        }
                    }
                )

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NotesTheme {

    }
}