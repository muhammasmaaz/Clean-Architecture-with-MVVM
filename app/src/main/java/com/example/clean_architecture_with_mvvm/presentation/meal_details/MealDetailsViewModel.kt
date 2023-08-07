package com.example.clean_architecture_with_mvvm.presentation.meal_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean_architecture_with_mvvm.domain.use_case.GetMealDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MealDetailsViewModel @Inject constructor(private val mealDetailsUseCase: GetMealDetailsUseCase) :
    ViewModel() {

    private val _mealDetails = MutableStateFlow<MealDetailsState>(MealDetailsState())
    val mealDetails: StateFlow<MealDetailsState> = _mealDetails


    fun getMealDetails(id: String) {
        mealDetailsUseCase(id).onEach {
            when (it) {

                is com.example.clean_architecture_with_mvvm.common.Resource.Loading -> {
                    _mealDetails.value = MealDetailsState(isLoading = true)
                }
                is com.example.clean_architecture_with_mvvm.common.Resource.Error -> {
                    _mealDetails.value = MealDetailsState(error = it.message ?: "")
                }
                is com.example.clean_architecture_with_mvvm.common.Resource.Success -> {
                    _mealDetails.value = MealDetailsState(data = it.data?.get(0))
                }
            }
        }.launchIn(viewModelScope)
    }


}