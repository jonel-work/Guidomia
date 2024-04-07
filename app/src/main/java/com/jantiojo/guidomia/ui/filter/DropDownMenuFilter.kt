package com.jantiojo.guidomia.ui.filter

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jantiojo.guidomia.ui.theme.Black45
import com.jantiojo.guidomia.ui.theme.GuidomiaTheme
import com.jantiojo.guidomia.ui.theme.Sizes

@Composable
fun DropDownMenuFilter(
    dropdownItems: List<String>,
    defaultItem: String,
    onDropdownMenuChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val localDensity = LocalDensity.current
    var parentWidth by remember {
        mutableStateOf(0.dp)
    }
    var expanded by remember { mutableStateOf(false) }

    var dropDownValue by remember { mutableStateOf(defaultItem) }

    Card(
        shape = RoundedCornerShape(6.dp),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        modifier = modifier
            .onGloballyPositioned { coordinates ->
                parentWidth = with(localDensity) { coordinates.size.width.toDp() }
            }
    ) {
        Text(
            text = dropDownValue,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Black45,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(Sizes.Small)
                .clickable {
                    expanded = !expanded
                }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(Color.White)
                .width(parentWidth)
        ) {
            dropdownItems.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = item,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = Black45,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    },
                    onClick = {
                        onDropdownMenuChange(item)
                        dropDownValue = item
                        expanded = false
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun SearchFieldPreview() {
    GuidomiaTheme {
        DropDownMenuFilter(
            dropdownItems = listOf("Menu1", "Menu2"),
            defaultItem = "Any Model",
            onDropdownMenuChange = {}
        )
    }
}