package com.example.introkotlin_901.TemasKotlin.tema1

fun main(){
    for(number in 1..5){

        println(number)

    }

    val nombres = listOf("Alejandro", "Juan", "Yolanda", "Arturo")

    for(number in nombres){
        println(number)

    }

    var x = 0
    while (x < 5){
        println(x)

        x++
    }

    do{
        println(x)
        x++
    }while (x < 5)
}