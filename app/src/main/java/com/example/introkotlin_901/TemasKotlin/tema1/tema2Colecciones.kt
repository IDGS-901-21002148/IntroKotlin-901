package com.example.introkotlin_901.TemasKotlin.tema1

fun main(){
    val readOnlyList: List<String> = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes")

    println("El primer dia es ${readOnlyList[0]}")
    println("El primer dia es ${readOnlyList.first() }")
    println("El primer dia es ${readOnlyList.count() }")
    println("El primer dia es ${readOnlyList.size}")

    println("Maetes" in readOnlyList)

    var figuras:MutableList<String> = mutableListOf("Circulo", "Cuadrado", "Triangulo")
    println(figuras)
    figuras.add("Pentagono")
    println(figuras)
    figuras.removeAt(index = 0)
    println(figuras)

    figuras.remove("Cuadrado")


    val readOnlyFrutas = mapOf("manzana" to 1500, "platano" to 2000, "sandia" to 2500)

    println(readOnlyFrutas)

    println(readOnlyFrutas["manzana"])
    println(readOnlyFrutas.keys)
    println(readOnlyFrutas.values)



}