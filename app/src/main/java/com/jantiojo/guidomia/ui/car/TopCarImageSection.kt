package com.jantiojo.guidomia.ui.car

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.jantiojo.guidomia.R
import com.jantiojo.guidomia.ui.model.CarImageResource
import com.jantiojo.guidomia.ui.theme.GuidomiaTheme
import com.jantiojo.guidomia.ui.theme.Sizes

@Composable
fun TopCarImageSection(
    modifier: Modifier = Modifier
) {
    val painter = painterResource(id = CarImageResource.TACOMA.imageRes)
    val imageRatio = painter.intrinsicSize.width / painter.intrinsicSize.height
    Box(modifier = modifier.wrapContentWidth()) {
        Image(
            painter = painter,
            contentDescription = stringResource(id = R.string.tacoma_2021),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(imageRatio)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Sizes.Large)
                .align(Alignment.BottomStart)
        ) {
            Text(
                text = stringResource(id = R.string.tacoma_2021),
                style = MaterialTheme.typography.displaySmall.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                text = stringResource(id = R.string.get_yours_now),
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun TopCarImageSectionPreview() {
    GuidomiaTheme {
        TopCarImageSection()
    }
}