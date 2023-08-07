package com.example.clean_architecture_with_mvvm.domain.repository

import com.example.clean_architecture_with_mvvm.data.model.MealsDTO


interface MealDetailsRepository {

    suspend fun getMealDetails(id:String): MealsDTO

}