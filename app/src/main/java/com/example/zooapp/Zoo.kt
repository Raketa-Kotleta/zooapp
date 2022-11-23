package com.example.zooapp

data class Zoo(
    val id: Int,
    val name: String,
    val count_workers: Number,
    val address: String,
    val aviary: MutableList<Aviary> = mutableListOf(),
){
}
