package com.example.ejercicio02

class Calculadora(
    val marca: String,
    val añosDeVida: Int
) {
    var precio: Double

    init {
        precio = 0.0
    }

    constructor(marca: String, añosDeVida: Int, precio: Double) : this(marca, añosDeVida) {
        this.precio = precio
    }

    fun sumar(a: Double, b: Double): Double {
        return a + b
    }

    fun restar(a: Double, b: Double): Double {
        return a - b
    }

    fun multiplicar(a: Double, b: Double): Double {
        return a * b
    }

    fun dividir(a: Double, b: Double): Double {
        if (b == 0.0) {
            println("ERROR: No se puede dividir entre cero")
            return 0.0
        }
        return a / b
    }

}