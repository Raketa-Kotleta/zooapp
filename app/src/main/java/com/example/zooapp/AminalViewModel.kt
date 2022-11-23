package com.example.zooapp

class AminalViewModel{
    val animals: MutableList<Zoo>
    init {
        animals = mutableListOf();
    }
    fun add(){

    }
    fun remove(){

    }
    fun getById(id: Int): Zoo?{
        return animals.find { it->it.id == id };
    }
}