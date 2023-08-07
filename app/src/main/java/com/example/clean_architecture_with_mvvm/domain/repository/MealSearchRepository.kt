package com.example.clean_architecture_with_mvvm.domain.repository

import com.example.clean_architecture_with_mvvm.data.model.MealsDTO


interface MealSearchRepository {

    suspend fun getMealSearch(s:String): MealsDTO



}