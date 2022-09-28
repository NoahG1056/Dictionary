package com.example.utils

import com.example.database.DataBaseRepository

const val TYPE_DATABASE="type_database"
const val TYPE_ROOM="type_room"
const val TYPE_FIREBASE="type_firebase"

lateinit var REPOSITORY:DataBaseRepository

object Constants{
    object Keys{
        const val ID="Id"

        const val NOTE_DATABASE="notes_database"
        const val NOTE_TABLE="notes table"
        const val ADD_NEW_TERM="Add new term"
        const val NONE="none"
    }
    object Screens{
        const val START_SCREEN="start screen"
        const val MAIN_SCREEN="main screen"
        const val ADD_SCREEN="add screen"
        const val NOTE_SCREEN="note screen"
        const val LEARN_SCREEN="learn screen"
    }
}