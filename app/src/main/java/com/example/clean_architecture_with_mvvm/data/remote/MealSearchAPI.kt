package com.example.clean_architecture_with_mvvm.data.remote

import com.example.clean_architecture_with_mvvm.data.model.MealsDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface MealSearchAPI {


    @GET("api/json/v1/1/search.php")
    suspend fun getSearchMealList(
        @Query("s") query: String
    ): MealsDTO


    @GET("api/json/v1/1/lookup.php")
    suspend fun getMealDetails(
        @Query("i") i: String
    ): MealsDTO


}