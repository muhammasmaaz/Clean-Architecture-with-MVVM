package com.example.clean_architecture_with_mvvm.presentation.meal_search

import com.example.clean_architecture_with_mvvm.domain.model.Meal


data class MealSearchState(
    val isLoading: Boolean = false,
    val data: List<Meal>? = null,
    val error: String = ""
)