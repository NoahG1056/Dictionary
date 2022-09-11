package com.example.notes

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.database.room.AppRoomDataBase
import com.example.database.room.repository.RoomRepository
import com.example.notes.model.Note
import com.example.utils.REPOSITORY
import com.example.utils.TYPE_FIREBASE
import com.example.utils.TYPE_ROOM

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
}

class MainViewModelFactory(private val application:Application):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(application=application) as T

        }
        throw IllegalAccessException("Unknown ViewModel Class")
    }
}