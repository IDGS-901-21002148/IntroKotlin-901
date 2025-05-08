package com.example.introkotlin_901.TemasKotlin.tema1

fun main(){

    val d:Int
    val e=true
    if(e){
       d=1
    }else{
        d=2
    }

    println(d)

    val numero=if (e) 1 else 2

    println(numero)

    print("Ingrese el sueldo del empleado:")
    val sueldo= readln().toDouble()
    if (sueldo > 3000){
        println("Debe pagar inpuestas")
    }else{
        println("no debe pagar impuestos")
    }


    val objeto:Any="Hola"
    when(objeto){
        "1"-> println("Es un saludo")
        is String-> println("Es un String")
        else -> println("No se que es")
    }





}