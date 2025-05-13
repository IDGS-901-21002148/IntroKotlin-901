package com.example.introkotlin_901.TemasKotlin.tema1

class Clases {
    fun calcularAreaCirculo(radio: Double): Double {
        return 3.1416 * radio * radio
    }

    fun calcularAreaCuadrado(lado: Double): Double {
        return lado * lado
    }

    fun calcularAreaTriangulo(base: Double, altura: Double): Double {
        return (base * altura) / 2
    }

    fun calcularAreaPentagono(lado: Double, apotema: Double): Double {
        return (5 * lado * apotema) / 2
    }
}

fun main() {
    val figuras = Clases()
    var opcion: Int

    do {
        println("\nSeleccione una figura para calcular su área:v")
        println("1. Círculo")
        println("2. Cuadrado")
        println("3. Triángulo Rectángulo")
        println("4. Pentágono")
        println("5. Salir")

        print("Ingrese su opción: ")
        opcion = readln().toIntOrNull() ?: -1

        when (opcion) {
            1 -> {
                print("Ingrese el radio del círculo: ")
                val radio = readln().toDoubleOrNull()
                if (radio != null && radio > 0) {
                    println("El área del círculo es: ${figuras.calcularAreaCirculo(radio)}")
                } else {
                    println("Datos inválidos. Ingrese un número positivo.")
                }
            }
            2 -> {
                print("Ingrese el lado del cuadrado: ")
                val lado = readln().toDoubleOrNull()
                if (lado != null && lado > 0) {
                    println("El área del cuadrado es: ${figuras.calcularAreaCuadrado(lado)}")
                } else {
                    println("Datos inválidos. Ingrese un número positivo.")
                }
            }
            3 -> {
                print("Ingrese la base del triángulo rectángulo: ")
                val base = readln().toDoubleOrNull()
                print("Ingrese la altura del triángulo rectángulo: ")
                val altura = readln().toDoubleOrNull()
                if (base != null && base > 0 && altura != null && altura > 0) {
                    println("El área del triángulo rectángulo es: ${figuras.calcularAreaTriangulo(base, altura)}")
                } else {
                    println("Datos inválidos. Ingrese números positivos.")
                }
            }
            4 -> {
                print("Ingrese el lado del pentágono: ")
                val lado = readln().toDoubleOrNull()
                print("Ingrese la apotema del pentágono: ")
                val apotema = readln().toDoubleOrNull()
                if (lado != null && lado > 0 && apotema != null && apotema > 0) {
                    println("El área del pentágono es: ${figuras.calcularAreaPentagono(lado, apotema)}")
                } else {
                    println("Datos inválidos. Ingrese números positivos.")
                }
            }
            5 -> println("Hasta pronto :V")
            else -> println("Opción no válida. Por favor, intente nuevamente.")
        }

    } while (opcion != 5)
}