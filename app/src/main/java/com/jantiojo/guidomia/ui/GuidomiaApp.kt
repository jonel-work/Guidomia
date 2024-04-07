package com.jantiojo.guidomia.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import com.jantiojo.guidomia.R
import com.jantiojo.guidomia.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuidomiaApp(
    modifier: Modifier = Modifier
) {

    Scaffold(
        topBar = {
            FlightSearchTopAppBar(title = stringResource(id = R.string.app_name))
        },
        modifier = modifier
    ) { innerPadding ->
        HomeScreen(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        )
    }
}


/**
 * App bar to display title and conditionally display the back navigation.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightSearchTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title.toUpperCase(),
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Orange),
        modifier = modifier,
        scrollBehavior = scrollBehavior
    )
}
