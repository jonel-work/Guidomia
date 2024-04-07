package com.jantiojo.guidomia.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.jantiojo.guidomia.GuidomiaApplication
import com.jantiojo.guidomia.data.mapper.toCarUiModelList
import com.jantiojo.guidomia.data.repository.CarRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class MainScreenViewModel(
    private val carRepository: CarRepository
) : ViewModel() {

    private val _carListUiState = MutableStateFlow(carRepository.getCars())
    val makeDropDownUiState = MutableStateFlow(carRepository.getCarMakeFilterList())
    val modelDropDownUiState = MutableStateFlow(carRepository.getCarModelFilterList())

    private val _makeFilterText = MutableStateFlow("")
    private val _modelFilterText = MutableStateFlow("")

    val carListUiState = combine(
        _makeFilterText,
        _modelFilterText,
        _carListUiState

    ) { makeText, modelText, cars ->
        if (makeText.isBlank() && modelText.isBlank()) {
            cars
        } else {
            cars.filter {
                it.doesMatchSearchQuery(makeText, modelText)
            }
        }.toCarUiModelList()
    }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _carListUiState.value.toCarUiModelList()
        )

    fun onFilterByMake(make: String) {
        _makeFilterText.value = if (make.equals("Any make", ignoreCase = true)) {
            ""
        } else {
            make
        }
    }

    fun onFilterByModel(model: String) {
        _modelFilterText.value = if (model.equals("Any model", ignoreCase = true)) {
            ""
        } else {
            model
        }
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                MainScreenViewModel(
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as GuidomiaApplication).appContainer.carRepository
                )
            }
        }
    }
}