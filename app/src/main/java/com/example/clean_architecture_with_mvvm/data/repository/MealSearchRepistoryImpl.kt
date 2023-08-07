package com.example.clean_architecture_with_mvvm.data.repository

import com.example.clean_architecture_with_mvvm.data.model.MealsDTO
import com.example.clean_architecture_with_mvvm.data.remote.MealSearchAPI
import com.example.clean_architecture_with_mvvm.domain.repository.MealSearchRepository

class MealSearchRepistoryImpl(private val mealSearchAPI: MealSearchAPI) : MealSearchRepository {

    override suspend fun getMealSearch(s: String): MealsDTO {
        return mealSearchAPI.getSearchMealList(s)
    }
}