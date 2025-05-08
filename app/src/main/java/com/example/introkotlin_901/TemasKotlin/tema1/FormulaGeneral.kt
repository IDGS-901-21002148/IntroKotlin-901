fun main() {
    var continuar: Int

    do {
        println("\nIngrese los valores de las variables de la ecuación general (ax² + bx + c = 0)")
        println("Si desea salir, ingrese 0.")

        print("Ingrese por favor el valor de a: ")
        val a = readln().toDouble()
        if (a == 0.0) {
            println("Saliendo del programa...")
            break
        }

        print("Ingrese por favor el valor de b: ")
        val b = readln().toDouble()

        print("Ingresepor favor el valor de c: ")

        print("Ingrese  el valor de c: ")
        val c = readln().toDouble()

        val discriminante = b * b - 4 * a * c

        if (discriminante < 0) {
            println("La ecuación no tiene solucion")
        } else {
            val raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a)
            val raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a)

            println("Las soluciones de la ecuación son:")
            println("x1 = $raiz1")
            println("x2 = $raiz2")
        }

        println("\nSi desea calcular otra ecuación, ingrese cualquier número. Si desea salir, ingrese 0.")
        continuar = readln().toInt()
    } while (continuar != 0)
}