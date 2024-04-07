package com.jantiojo.guidomia.ui.filter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jantiojo.guidomia.ui.theme.Black45
import com.jantiojo.guidomia.ui.theme.GuidomiaTheme

@Composable
fun SearchField(
    textValue: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    textHint: String = ""
) {

    Card(
        shape = RoundedCornerShape(6.dp),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        modifier = modifier
    ) {
        BasicTextField(
            value = textValue,
            onValueChange = onValueChange,
            decorationBox = { innerTextField ->
                Text(
                    text = textHint,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Black45,
                        fontWeight = FontWeight.Bold
                    )
                )
                innerTextField()
            },
            modifier = Modifier
                .background(Color.White)
                .padding(vertical = 8.dp, horizontal = 10.dp)
        )
    }
}

@Preview
@Composable
private fun SearchFieldPreview() {
    GuidomiaTheme {
        SearchField(textValue = "", onValueChange = {}, textHint = "Any Model")
    }
}