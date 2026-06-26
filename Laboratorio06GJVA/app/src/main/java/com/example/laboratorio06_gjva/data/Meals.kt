package com.example.laboratorio06_gjva.data

data class MealsResponse(
    val meals: List<MealResponse>
)

data class MealResponse(
    val idMeal: String,
    val strMeal: String,
    val strCategory: String,
    val strArea: String,
    val strMealThumb: String,
    val strCountry: String
)