package com.jantiojo.guidomia.ui.car

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jantiojo.guidomia.ui.model.CarItemUiModel
import com.jantiojo.guidomia.ui.theme.GuidomiaTheme

fun LazyListScope.carListSection(
    carListUi: List<CarItemUiModel>,
    modifier: Modifier = Modifier
) {
    items(items = carListUi) { uiModel ->
        CarItem(carItemUiModel = uiModel, modifier = modifier)
    }
}

@Preview(showBackground = true)
@Composable
private fun CarListSectionPreview() {
    GuidomiaTheme {
        LazyColumn {
            this.carListSection(carListUi = CarItemPreviewProvider().values.toList())
        }
    }
}