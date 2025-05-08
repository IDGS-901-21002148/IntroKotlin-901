package com.example.introkotlin_901.TemasKotlin.tema1

fun main() {
    var opcion: Int

    do {
        println("\nSelecciona una opcion")
        println("1. Círculo")
        println("2. Cuadrado")
        println("3. Triángulo")
        println("4. Pentágono")
        println("5. Salir")

        print("Ingrese la opcion: ")
        opcion = readln().toInt()


        //Circulo --------------------------------------------------------------------------------
        when (opcion) {
            1 -> {
                print("Ingrese el radio del círculo: ")
                val radio = readln().toDouble()
                val area = 3.1416 * radio * radio
                println("El área del círculo es: $area")
            }

            //Cuadrado---------------------------------------------------------------------------
            2 -> {
                print("Ingrese el lado del cuadrado: ")
                val lado = readln().toDouble()
                val area = lado * lado
                println("El área del cuadrado es: $area")
            }

            //Trialgulo------------------------------------------------------------------------
            3 -> {
                print("Ingrese la base del triángulo: ")
                val base = readln().toDouble()
                print("Ingrese la altura del triángulo: ")
                val altura = readln().toDouble()
                val area = (base * altura) / 2
                println("El área del triángulo es: $area")
            }

            //Pentagono-----------------------------------------------------------------------
            4 -> {
                print("Ingrese el lado del pentágono: ")
                val lado = readln().toDouble()
                print("Ingrese la apotema del pentágono: ")
                val apotema = readln().toDouble()
                val area = (5 * lado * apotema) / 2
                println("El área del pentágono es: $area")
            }

            //Salir--------------------------------------------------------------------------
            5 -> println("Adios :-)")
            else -> println("Opción no válida. Seleccione otra")
        }

    } while (opcion != 5)
}