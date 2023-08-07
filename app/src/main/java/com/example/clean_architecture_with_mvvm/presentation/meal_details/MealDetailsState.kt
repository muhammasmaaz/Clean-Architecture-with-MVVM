package com.example.clean_architecture_with_mvvm.presentation.meal_details

import com.example.clean_architecture_with_mvvm.domain.model.MealDetails


data class MealDetailsState(
    val isLoading: Boolean = false,
    val data: MealDetails? = null,
    val error: String = ""
) {
}