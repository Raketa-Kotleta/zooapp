package com.example.zooapp

data class Aviary(
    val id: Int,
    val name: String,
    val zoo: String,
    val animals: MutableList<Animal> = mutableListOf(),
)
