package com.glitch.coffeecompose.ui.coffeedetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glitch.coffeecompose.R
import com.glitch.coffeecompose.ui.common.Coffeebox
import com.glitch.coffeecompose.ui.theme.CoffeeComposeTheme
import com.glitch.coffeecompose.ui.theme.Maincolor
import com.glitch.coffeecompose.ui.theme.Textcolor1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeDetails() {

	/*val counter = remember {
		mutableStateOf(0)
	}*/

	val configuration = LocalConfiguration.current

	val screenWidth = configuration.screenWidthDp
	val screenHeight = configuration.screenHeightDp

	Scaffold(
		topBar = {
			TopAppBar(
				title = { Text(text = "Welcome") },
				colors = TopAppBarDefaults.topAppBarColors(
					containerColor = Maincolor, titleContentColor = Textcolor1
				)
			)
		}
	) { paddingValues ->
		Box(
			modifier = Modifier
				.fillMaxSize()
		) {
			Image(
				painter = painterResource(id = R.drawable.secondtop),
				modifier = Modifier
					.height((screenHeight / 4).dp)
					.fillMaxWidth(),
				contentScale = ContentScale.Crop,
				contentDescription = ""
			)

			Box(
				modifier = Modifier
					.fillMaxSize()
			) {

				Column(
					modifier = Modifier
						.align(Alignment.TopCenter)
						.padding(horizontal = 10.dp)
						.padding(top = paddingValues.calculateTopPadding())
				) {
					Text(
						text = stringResource(id = R.string.coffee_title),
						fontSize = (screenWidth / 10).sp,
						color = Color.White,
					)

				}

				Row(
					modifier = Modifier
						.fillMaxHeight()
						.align(Alignment.BottomCenter),

					verticalAlignment = Alignment.Bottom,
					horizontalArrangement = Arrangement.Center
				) {

					Column(
						modifier = Modifier
							.width((screenWidth / 2).dp)
							.weight(1f), // Take up equal space in the Column
					) {
						Coffeebox(painterResource(id = R.drawable.coffee1), "0")
						Coffeebox(painterResource(id = R.drawable.coffee2), "0")
					}

					Column(
						modifier = Modifier
							.width((screenWidth / 2).dp)
							.weight(1f), // Take up equal space in the Column
					) {
						Coffeebox(painterResource(id = R.drawable.coffee3), "0")
						Coffeebox(painterResource(id = R.drawable.coffee4), "0")
					}


				}
			}
		}

	}
}

@Preview(showBackground = true)
@Composable
fun CoffeeDetailsPreview() {
	CoffeeComposeTheme {
		CoffeeDetails()
	}
}
