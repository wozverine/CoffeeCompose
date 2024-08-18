package com.glitch.coffeecompose.ui.welcomescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.glitch.coffeecompose.R
import com.glitch.coffeecompose.ui.theme.CoffeeComposeTheme
import com.glitch.coffeecompose.ui.theme.Maincolor
import com.glitch.coffeecompose.ui.theme.Textcolor1
import com.glitch.coffeecompose.ui.theme.vic

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomePage(navController: NavController) {

	val configuration = LocalConfiguration.current

	val screenWidth = configuration.screenWidthDp
	val screenHeight = configuration.screenHeightDp


	Scaffold(
		topBar = {
			CenterAlignedTopAppBar(
				title = { Text(text = "Mainpage", fontFamily = vic) },
				colors = TopAppBarDefaults.topAppBarColors(
					containerColor = Maincolor, titleContentColor = Textcolor1
				)
			)
		}
	) { paddingValues ->
		Box(
			modifier = Modifier.fillMaxSize()
		) {
			Column(
				modifier = Modifier
					.fillMaxSize()
					.padding(paddingValues),
				//horizontalAlignment = Alignment.CenterHorizontally,
				//verticalArrangement = Arrangement.SpaceBetween
			) {
				Image(
					painter = painterResource(id = R.drawable.coffeetop),
					modifier = Modifier
						.fillMaxWidth(),
					contentScale = ContentScale.Crop,
					contentDescription = ""
				)

				Spacer(modifier = Modifier.height(100.dp))
				Spacer(modifier = Modifier.weight(1f))
			}

			Image(
				painter = painterResource(id = R.drawable.coffeebottom),
				modifier = Modifier
					.fillMaxWidth()
					.align(Alignment.BottomCenter),
				contentScale = ContentScale.Crop,
				contentDescription = ""
			)

			Box(
				modifier = Modifier
					.align(Alignment.BottomCenter)
					.fillMaxWidth()
			) {

				Column(
					modifier = Modifier
						.align(Alignment.Center)
						.padding(bottom = 50.dp),
					horizontalAlignment = Alignment.CenterHorizontally,
					verticalArrangement = Arrangement.spacedBy(20.dp)
				) {
					Text(
						text = stringResource(id = R.string.coffee_title),
						fontWeight = FontWeight.Bold,
						fontSize = (screenWidth / 10).sp,
						textAlign = TextAlign.Center,
					)
					Text(
						text = stringResource(id = R.string.coffee_welcome),
						fontSize = (screenHeight / 30).sp,
						textAlign = TextAlign.Center
					)

					Button(onClick = {
						navController.navigate("detailspage")
					}) {
						Text(text = stringResource(id = R.string.get_started), fontSize = 20.sp)
					}
				}
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun MainpagePreview() {
	CoffeeComposeTheme {
		val navController = rememberNavController()
		WelcomePage(navController = navController)
	}
}

