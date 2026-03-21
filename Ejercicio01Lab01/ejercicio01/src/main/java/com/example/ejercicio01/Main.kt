package com.example.ejercicio01

fun main() {
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
    println("--- Datos iniciales ---")
    println("RAM: ${compu.ram} GB")
    println("Almacenamiento: ${compu.almacenamiento} GB")
    println("Sistema Operativo: ${compu.sistemasOperativo}")
    println("Programas del 2026: ${compu.obtenerProgramas()}")

    // Actualizar //
    compu.actualizar(nuevaRam = 32, nuevoAlma = 512, nuevoSO = "Ubuntu")
    println("--- Datos actualizados ---")
    println("Nueva RAM: ${compu.ram} GB")
    println("Nuevo almacenamiento: ${compu.almacenamiento} GB")
    println("Nuevo SO: ${compu.sistemasOperativo}")

    // Apagar //
    compu.apagarComputadora()
}