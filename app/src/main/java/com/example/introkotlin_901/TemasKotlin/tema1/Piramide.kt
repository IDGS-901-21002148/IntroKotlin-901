package com.example.introkotlin_901.TemasKotlin.tema1

fun main() {
    var cantidad: Int?

    do {
        print("Ingrese el número de niveles de la pirámide o ingrese 0 para salir: ")
        cantidad = readln().toIntOrNull()

        if (cantidad == null || cantidad < 0) {
            println("Datos incorrectos. Por favor ingrese un número entero positivo.")
        } else if (cantidad == 0) {
            println("adios :-)")
            break
        } else {
            var i = 1
            do {
                println("*".repeat(i))
                i++
            } while (i <= cantidad)
        }

    } while (cantidad != 0)
}