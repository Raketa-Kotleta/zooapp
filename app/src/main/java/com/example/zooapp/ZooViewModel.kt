package com.example.zooapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class ZooViewModel: ViewModel() {
    var zoos: MutableLiveData<MutableList<Zoo>>
    private var observer: Observer<MutableList<Zoo>>
    init {
        zoos = MutableLiveData()
        zoos.value = mutableListOf()
        observer = Observer<MutableList<Zoo>>
        {newList:MutableList<Zoo> ->
            newList?.let {
//            Log.d(TAG, "Получен список  StudentListVuewModel от StudentsRepository")
                this.zoos.postValue(newList as MutableList<Zoo>?)
            }
        }
        zoos.observeForever(observer)
    }
    fun add(zoo: Zoo){
        var zoosTmp = zoos.value
        zoosTmp?.add(zoo)
        zoos.postValue(zoosTmp)
    }
    fun remove(zoo: Zoo){

    }
//    fun getById(id: Int): Zoo?{
//        return zoos. { it->it.id == id };
//    }

}