package com.example.zooapp

class AviatyViewModel {
    val aviaries: MutableList<Zoo>
    init {
        aviaries = mutableListOf();
    }
    fun add(){

    }
    fun remove(){

    }
    fun getById(id: Int): Zoo?{
        return aviaries.find { it->it.id == id };
    }
}