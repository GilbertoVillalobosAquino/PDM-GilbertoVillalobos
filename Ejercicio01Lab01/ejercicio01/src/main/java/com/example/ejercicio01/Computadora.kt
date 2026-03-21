package com.example.ejercicio01

class Computadora(
    var ram: Int,
    var almacenamiento: Int,
    var sistemasOperativo: String,
    var programasInstalados: List<String>
){

    fun encenderComputadora(){
        println("Computadora encendida")
    }

    fun apagarComputadora(){
        println("Computadora apagada")
    }

    fun actualizar(nuevaRam: Int, nuevoAlma: Int, nuevoSO: String){
        ram = nuevaRam
        almacenamiento = nuevoAlma
        sistemasOperativo = nuevoSO
        println("Computadora actualizada")
    }

    fun obtenerProgramas(): List<String> {
        return programasInstalados.filter { it.contains("2026") }
    }
}