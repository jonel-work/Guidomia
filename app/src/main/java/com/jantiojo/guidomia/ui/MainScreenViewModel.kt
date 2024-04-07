package com.jantiojo.guidomia.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.jantiojo.guidomia.GuidomiaApplication
import com.jantiojo.guidomia.data.mapper.toCarUiModelList
import com.jantiojo.guidomia.data.repository.CarRepository
import com.jantiojo.guidomia.ui.model.CarItemUiModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainScreenViewModel(
    private val carRepository: CarRepository
) : ViewModel() {

    val carListUi: MutableStateFlow<List<CarItemUiModel>> =
        MutableStateFlow(carRepository.getCars().toCarUiModelList())

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