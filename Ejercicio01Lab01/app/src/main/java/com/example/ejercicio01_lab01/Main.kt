package com.example.ejercicio01_lab01

import android.util.Log

fun main(){
    val programas = listOf("Notion 2026", "Facebook 2024", "Spotify 2026", "Chrome 2026")

    val compu = Computadora(
        ram = 16,
        almacenamiento = 256,
        sistemasOperativo = "Windows",
        programasInstalados = programas
    )

    // Encender //
    compu.encenderComputadora()

    // Datos iniciales //
    Log.d("Prueba", "--- Datos iniciales ---")
    Log.d("Prueba", "RAM: ${compu.ram} GB")
    Log.d("Prueba", "Almacenamiento: ${compu.almacenamiento} GB")
    Log.d("Prueba", "Sistema Operativo: ${compu.sistemasOperativo}")
    Log.d("Prueba", "Programas del 2026: ${compu.obtenerProgramas()}")

    // Actualizar //
    compu.actualizar(nuevaRam = 32, nuevoAlma = 512, nuevoSO = "Ubuntu")
    Log.d("Prueba", "--- Datos actualizados ---")
    Log.d("Prueba", "Nueva RAM: ${compu.ram} GB")
    Log.d("Prueba", "Nuevo almacenamiento: ${compu.almacenamiento} GB")
    Log.d("Prueba", "Nuevo SO: ${compu.sistemasOperativo}")

    // Apagar //
    compu.apagarComputadora()
}