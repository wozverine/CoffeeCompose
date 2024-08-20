package com.glitch.coffeecompose.ui.paidScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.glitch.coffeecompose.R
import com.glitch.coffeecompose.ui.theme.ButtonOrange
import com.glitch.coffeecompose.ui.theme.CoffeeComposeTheme
import com.glitch.coffeecompose.ui.theme.Maincolor
import com.glitch.coffeecompose.ui.theme.Textcolor1
import com.glitch.coffeecompose.ui.theme.vic

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaidScreen(navController: NavController) {
	val configuration = LocalConfiguration.current

	val screenWidth = configuration.screenWidthDp
	val screenHeight = configuration.screenHeightDp

	Scaffold(topBar = {
		CenterAlignedTopAppBar(
			title = { Text(text = stringResource(id = R.string.pay), fontFamily = vic) },
			colors = TopAppBarDefaults.topAppBarColors(
				containerColor = Maincolor, titleContentColor = Textcolor1
			)
		)
	}) { paddingValues ->
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(paddingValues),
			verticalArrangement = Arrangement.SpaceEvenly
		) {
			Text(
				text = stringResource(id = R.string.paymentsuccessful),
				fontWeight = FontWeight.Bold,
				fontSize = (screenWidth / 10).sp,
				textAlign = TextAlign.Center,
				color = Textcolor1,
			)

			Button(
				modifier = Modifier
					.padding(vertical = 3.dp)
					.align(Alignment.CenterHorizontally)
					.width((screenWidth / 4 * 3).dp),
				onClick = { navController.navigate("welcomepage") },
				colors = ButtonDefaults.buttonColors(
					containerColor = ButtonOrange, contentColor = Textcolor1
				),
			) {
				Text(
					text = stringResource(id = R.string.paymentsuccessful), fontSize = 20.sp
				)
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun PaidPreview() {
	CoffeeComposeTheme {
		val navController = rememberNavController()
		PaidScreen(navController)
	}
}