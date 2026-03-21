package com.example.ejercicio01_lab01

import android.util.Log

class Computadora(
    var ram: Int,
    var almacenamiento: Int,
    var sistemasOperativo: String,
    var programasInstalados: List<String>
){

    fun encenderComputadora(){
        Log.d("Prueba", "Computadora encendida")
    }

    fun apagarComputadora(){
        Log.d("Prueba", "Computadora apagada")
    }

    fun actualizar(nuevaRam: Int, nuevoAlma: Int, nuevoSO: String){
        ram = nuevaRam
        almacenamiento = nuevoAlma
        sistemasOperativo = nuevoSO
        Log.d("Prueba", "Computadora actualizada")
    }

    fun obtenerProgramas(): List<String> {
        return programasInstalados.filter { it.contains("2026") }
    }
}