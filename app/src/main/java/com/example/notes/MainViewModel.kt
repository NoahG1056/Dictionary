package com.example.notes

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.database.room.AppRoomDataBase
import com.example.database.room.repository.RoomRepository
import com.example.database.room.model.Note
import com.example.utils.REPOSITORY
import com.example.utils.TYPE_ROOM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application):AndroidViewModel(application) {

    val context=application

    fun initDataBase(type:String,onSuccess:()->Unit){
        Log.d("checkData","MainViewModel initDataBase with type: $type")
        when(type){
            TYPE_ROOM->{
                val dao=AppRoomDataBase.getInstance(context = context).getRoomDao()
                REPOSITORY=RoomRepository(dao)
                onSuccess()
            }
        }
    }

    fun addNote(note:Note,onSuccess: () -> Unit){

        viewModelScope.launch ( Dispatchers.IO ){
            REPOSITORY.create(note=note){
                viewModelScope.launch (Dispatchers.Main){
                    onSuccess()
                }
            }

        }
    }
    fun readAllNotes()= REPOSITORY.readAll
}

class MainViewModelFactory(private val application:Application):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(application=application) as T

        }
        throw IllegalAccessException("Unknown ViewModel Class")
    }
}