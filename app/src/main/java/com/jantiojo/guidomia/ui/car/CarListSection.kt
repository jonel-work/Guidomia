package com.jantiojo.guidomia.ui.car

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jantiojo.guidomia.ui.model.CarItemUiModel
import com.jantiojo.guidomia.ui.theme.GuidomiaTheme

fun LazyListScope.carListSection(
    carListUi: List<CarItemUiModel>,
    expandedPosition: Int,
    onClickItem: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    itemsIndexed(items = carListUi) { index, uiModel ->
        CarItem(
            carItemUiModel = uiModel,
            isExpanded = expandedPosition == index,
            onClickItem = { onClickItem(index) },
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CarListSectionPreview() {
    GuidomiaTheme {
        LazyColumn {
            this.carListSection(
                carListUi = CarItemPreviewProvider().values.toList(),
                expandedPosition = 0,
                onClickItem = {}
            )
        }
    }
}