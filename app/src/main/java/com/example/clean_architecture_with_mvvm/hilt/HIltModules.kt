package com.example.clean_architecture_with_mvvm.hilt

import com.example.clean_architecture_with_mvvm.common.Constants
import com.example.clean_architecture_with_mvvm.data.remote.MealSearchAPI
import com.example.clean_architecture_with_mvvm.data.repository.MealDetailsRepositoryImpl
import com.example.clean_architecture_with_mvvm.data.repository.MealSearchRepistoryImpl
import com.example.clean_architecture_with_mvvm.domain.repository.MealDetailsRepository
import com.example.clean_architecture_with_mvvm.domain.repository.MealSearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object HIltModules {


    @Provides
    @Singleton
    fun provideMealSearchAPI(): MealSearchAPI {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(MealSearchAPI::class.java)
    }


    @Provides
    fun provideMealSearchRepository(mealSearchAPI: MealSearchAPI): MealSearchRepository {
        return MealSearchRepistoryImpl(mealSearchAPI)
    }


    @Provides
    fun provideMealDetails(searchMealSearchAPI: MealSearchAPI): MealDetailsRepository {
        return MealDetailsRepositoryImpl(searchMealSearchAPI)
    }


}