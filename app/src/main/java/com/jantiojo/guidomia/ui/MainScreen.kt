package com.jantiojo.guidomia.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.jantiojo.guidomia.ui.car.TopCarImageSection
import com.jantiojo.guidomia.ui.car.carListSection
import com.jantiojo.guidomia.ui.filter.DropdownFilterSection
import com.jantiojo.guidomia.ui.model.CarItemUiModel
import com.jantiojo.guidomia.ui.theme.Sizes

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = MainScreenViewModel.factory)
) {

    val carUiState by viewModel.carListUiState.collectAsState()
    val makeMenuUiState by viewModel.makeDropDownUiState.collectAsState()
    val modelMenuUiState by viewModel.modelDropDownUiState.collectAsState()

    MainScreenBody(
        carUIList = carUiState,
        makeDropdownMenu = makeMenuUiState,
        modelDropdownMenu = modelMenuUiState,
        onMakeDropdownMenuChange = {},
        onModelDropdownMenuChange = {},
        modifier = modifier
    )

}


@Composable
private fun MainScreenBody(
    carUIList: List<CarItemUiModel>,
    makeDropdownMenu : List<String>,
    modelDropdownMenu : List<String>,
    onMakeDropdownMenuChange: (String) -> Unit,
    onModelDropdownMenuChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expandedPosition by rememberSaveable { mutableIntStateOf(0) }

    LazyColumn(modifier = modifier) {
        item {
            TopCarImageSection()
        }

        item {
            DropdownFilterSection(
                makeDropdownMenu = makeDropdownMenu,
                modelDropdownMenu = modelDropdownMenu,
                onMakeDropdownChange = onMakeDropdownMenuChange,
                onModelDropdownChange = onModelDropdownMenuChange,
                modifier = Modifier.padding(Sizes.ExtraLarge)
            )
        }
        this.carListSection(
            carListUi = carUIList,
            expandedPosition = expandedPosition,
            onClickItem = { index ->
                expandedPosition = index
            }
        )
    }
}