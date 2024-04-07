package com.jantiojo.guidomia.ui.car

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.jantiojo.guidomia.R
import com.jantiojo.guidomia.ui.model.CarItemUiModel
import com.jantiojo.guidomia.ui.theme.Black45
import com.jantiojo.guidomia.ui.theme.DarkGray
import com.jantiojo.guidomia.ui.theme.GuidomiaTheme
import com.jantiojo.guidomia.ui.theme.Orange
import com.jantiojo.guidomia.ui.theme.Sizes

@Composable
fun CarItem(
    carItemUiModel: CarItemUiModel,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = DarkGray)
                .padding(Sizes.Medium)
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(Sizes.Medium)
            ) {

                Image(
                    painter = painterResource(id = carItemUiModel.image.imageRes),
                    contentDescription = carItemUiModel.name,
                    contentScale = ContentScale.Crop,
                )

                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = carItemUiModel.name,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Black45,
                            fontWeight = FontWeight.Bold,
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        )
                    )
                    Text(
                        text = stringResource(
                            id = R.string.price_label,
                            carItemUiModel.priceDisplay
                        ),
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = Black45,
                            fontWeight = FontWeight.Bold,
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        )
                    )

                    Spacer(modifier = Modifier.size(Sizes.ExtraExtraSmall))

                    Row {
                        repeat(carItemUiModel.rating) {
                            Icon(
                                Icons.Filled.Star,
                                contentDescription = "Favorite $it",
                                tint = Orange,
                                modifier = Modifier
                                    .padding(end = Sizes.ExtraSmall)
                                    .size(Sizes.Large)
                            )
                        }
                    }
                }
            }
        }

        Divider(
            color = Orange,
            thickness = Sizes.LineSize,
            modifier = Modifier
                .padding(horizontal = Sizes.Medium, vertical = Sizes.Small)
                .fillMaxWidth()
                .width(1.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun CarItemPreview(@PreviewParameter(CarItemPreviewProvider::class) carItemUiModel: CarItemUiModel) {
    GuidomiaTheme {
        CarItem(carItemUiModel = carItemUiModel)
    }
}