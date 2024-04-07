package com.jantiojo.guidomia.ui.car

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jantiojo.guidomia.ui.model.CarItemUiModel
import com.jantiojo.guidomia.ui.theme.GuidomiaTheme

@Composable
fun CarListSection(
    carListUi: List<CarItemUiModel>,
    modifier: Modifier = Modifier
) {

    LazyColumn(modifier = modifier) {
        items(items = carListUi) { uiModel ->
            CarItem(carItemUiModel = uiModel)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CarListSectionPreview() {
    GuidomiaTheme {
        CarListSection(carListUi = CarItemPreviewProvider().values.toList())
    }
}