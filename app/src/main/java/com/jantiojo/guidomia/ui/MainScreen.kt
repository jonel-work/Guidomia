package com.jantiojo.guidomia.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.jantiojo.guidomia.ui.car.TopCarImageSection
import com.jantiojo.guidomia.ui.car.carListSection
import com.jantiojo.guidomia.ui.filter.SearchFilterSection
import com.jantiojo.guidomia.ui.model.CarItemUiModel
import com.jantiojo.guidomia.ui.theme.Sizes

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = MainScreenViewModel.factory)
) {

    val uiState by viewModel.carListUi.collectAsState()
    MainScreenBody(
        carUIList = uiState,
        modifier = modifier
    )

}


@Composable
private fun MainScreenBody(
    carUIList: List<CarItemUiModel>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        item {
            TopCarImageSection()
        }

        item {
            SearchFilterSection(
                anyMakeValue = "",
                onAnyMakeValueChange = {},
                anyModelValue = "",
                onAnyModelValueChange = {},
                modifier = Modifier.padding(Sizes.ExtraLarge)
            )
        }
        this.carListSection(carListUi = carUIList)
    }
}