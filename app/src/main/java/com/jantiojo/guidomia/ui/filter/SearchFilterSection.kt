package com.jantiojo.guidomia.ui.filter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.jantiojo.guidomia.R
import com.jantiojo.guidomia.ui.theme.DarkGray
import com.jantiojo.guidomia.ui.theme.GuidomiaTheme
import com.jantiojo.guidomia.ui.theme.Sizes

@Composable
fun SearchFilterSection(
    anyMakeValue: String,
    onAnyMakeValueChange: (String) -> Unit,
    anyModelValue: String,
    onAnyModelValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = DarkGray)
                .padding(horizontal = Sizes.Medium, vertical = Sizes.Large),
            verticalArrangement = Arrangement.spacedBy(Sizes.Medium)
        ) {
            Text(
                text = stringResource(id = R.string.filter_label),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp
                )
            )

            SearchField(
                textValue = anyMakeValue,
                onValueChange = onAnyMakeValueChange,
                textHint = stringResource(id = R.string.any_make_hint)
            )

            SearchField(
                textValue = anyModelValue,
                onValueChange = onAnyModelValueChange,
                textHint = stringResource(id = R.string.any_model_hint)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchFilterSectionPreview() {
    GuidomiaTheme {
        SearchFilterSection(
            anyMakeValue = "",
            onAnyMakeValueChange = {},
            anyModelValue = "",
            onAnyModelValueChange = {}
        )
    }
}