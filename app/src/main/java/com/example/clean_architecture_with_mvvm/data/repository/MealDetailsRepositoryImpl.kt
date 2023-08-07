package com.example.clean_architecture_with_mvvm.data.repository

import com.example.clean_architecture_with_mvvm.data.model.MealsDTO
import com.example.clean_architecture_with_mvvm.data.remote.MealSearchAPI
import com.example.clean_architecture_with_mvvm.domain.repository.MealDetailsRepository

class MealDetailsRepositoryImpl(private val mealSearchAPI: MealSearchAPI) : MealDetailsRepository {

    override suspend fun getMealDetails(id: String): MealsDTO {
        return mealSearchAPI.getMealDetails(id)
    }
}