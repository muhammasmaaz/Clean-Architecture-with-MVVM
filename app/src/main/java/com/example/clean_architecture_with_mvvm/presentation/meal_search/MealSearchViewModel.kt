package com.example.clean_architecture_with_mvvm.presentation.meal_search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean_architecture_with_mvvm.common.Resource
import com.example.clean_architecture_with_mvvm.domain.use_case.SearchMealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MealSearchViewModel @Inject constructor(
    private val mealSearchMealsUseCase: SearchMealsUseCase
) : ViewModel() {


    private val _mealSearchList = MutableStateFlow<MealSearchState>(MealSearchState())
    val mealSearchList: StateFlow<MealSearchState> = _mealSearchList


    fun getSearchMeals(s: String) {
        mealSearchMealsUseCase(s).onEach {
            when (it) {
                is Resource.Loading -> {
                    _mealSearchList.value = MealSearchState(isLoading = true)
                }
                is Resource.Success -> {
                    _mealSearchList.value = MealSearchState(data = it.data)
                }
                is Resource.Error -> {
                    _mealSearchList.value = MealSearchState(error = it.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }


}