package com.example.ejercicio02

fun main(){
    val calc = Calculadora(
        marca = "Samsung",
        añosDeVida = 10,
        precio = 259.99
    )

    println("--- Calculadora ${calc.marca} ---")
    println("Años de vida: ${calc.añosDeVida}")
    println("Precio: ${calc.precio}")

    println("\n--- Operaciones ---")
    println("15 + 3 = ${calc.sumar(15.0, 3.0)}")
    println("15 - 3 = ${calc.restar(15.0, 3.0)}")
    println("15 * 3 = ${calc.multiplicar(15.0, 3.0)}")
    println("15 / 3 = ${calc.dividir(15.0, 3.0)}")
}