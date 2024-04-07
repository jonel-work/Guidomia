package com.jantiojo.guidomia.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.jantiojo.guidomia.GuidomiaApplication
import com.jantiojo.guidomia.data.mapper.toCarUiModelList
import com.jantiojo.guidomia.data.model.Car
import com.jantiojo.guidomia.data.repository.CarRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val carRepository: CarRepository
) : ViewModel() {

    private val _carListUiState: MutableStateFlow<List<Car>> = MutableStateFlow(emptyList())
    private val _makeDropDownUiState: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    val makeDropDownUiState = _makeDropDownUiState.asStateFlow()
    private val _modelDropDownUiState: MutableStateFlow<List<String>> =
        MutableStateFlow(emptyList())
    val modelDropDownUiState = _modelDropDownUiState.asStateFlow()

    private val _makeFilterText = MutableStateFlow("")
    private val _modelFilterText = MutableStateFlow("")

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getMakeDropDownMenu()
            getModelDropDownMenu()
            getCars()
        }
    }

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

    suspend fun getCars() {
        carRepository.getCars().collectLatest {
            _carListUiState.value = it
        }
    }

    suspend fun getMakeDropDownMenu() {
        carRepository.getCarMakeFilterList().collect {
            _makeDropDownUiState.value = it
        }
    }

    suspend fun getModelDropDownMenu() {
        carRepository.getCarModelFilterList().collect {
            _modelDropDownUiState.value = it
        }
    }

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