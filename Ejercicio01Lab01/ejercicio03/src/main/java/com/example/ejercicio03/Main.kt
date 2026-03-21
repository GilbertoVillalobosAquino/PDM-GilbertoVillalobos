package com.example.ejercicio03

fun main() {
    val Ciclo01 = listOf(
        // Programación de Dispositivos Móviles //
        Estudiante("Ana Garcia", "AG45912", "Programación de Dispositivos Móviles"),
        Estudiante("Juan Perez", "JP12313", "Programación de Dispositivos Móviles"),
        Estudiante("Maria Rodriguez", "MR67812", "Programación de Dispositivos Móviles"),

        // Análisis Numérico //
        Estudiante("Pedro Martinez", "PM34512", "Análisis Numérico"),
        Estudiante("Laura Sanchez", "LS78912", "Análisis Numérico"),
        Estudiante("Carlos Lopez", "CL23412", "Análisis Numérico"),
        Estudiante("Ana Mercedes", "AM45912", "Análisis Numérico")
    )

    println("--- Estudiantes en Dispositivos Móviles ---")
    val dispositivosMoviles = Ciclo01.filter {
        it.asignatura == "Programación de Dispositivos Móviles"
    }

    dispositivosMoviles.forEach {
        println("Nombre: ${it.nombre} | Carnet: ${it.carnet}")
    }

    println("\nTotal: ${dispositivosMoviles.size} estudiantes")
}