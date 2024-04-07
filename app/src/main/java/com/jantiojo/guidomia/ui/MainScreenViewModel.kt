package com.jantiojo.guidomia.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.jantiojo.guidomia.GuidomiaApplication
import com.jantiojo.guidomia.data.mapper.toCarUiModelList
import com.jantiojo.guidomia.data.repository.CarRepository
import kotlinx.coroutines.flow.MutableStateFlow

class MainScreenViewModel(
    private val carRepository: CarRepository
) : ViewModel() {

     val carListUiState = MutableStateFlow(carRepository.getCars().toCarUiModelList())
     val makeDropDownUiState = MutableStateFlow(carRepository.getCarMakeFilterList())
     val modelDropDownUiState = MutableStateFlow(carRepository.getCarModelFilterList())

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