package com.glitch.coffeecompose.ui.coffeedetail

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.glitch.coffeecompose.R
import com.glitch.coffeecompose.ui.common.Coffeebox
import com.glitch.coffeecompose.ui.common.coffeeItems
import com.glitch.coffeecompose.ui.theme.ButtonOrange
import com.glitch.coffeecompose.ui.theme.CoffeeComposeTheme
import com.glitch.coffeecompose.ui.theme.Textcolor1
import com.glitch.coffeecompose.ui.theme.Topcolor
import my.nanihadesuka.compose.LazyVerticalGridScrollbar
import my.nanihadesuka.compose.ScrollbarSettings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeDetails(navController: NavController) {

	val configuration = LocalConfiguration.current

	val screenWidth = configuration.screenWidthDp
	val screenHeight = configuration.screenHeightDp

	val listState = rememberLazyGridState()

	Scaffold(topBar = {
		TopAppBar(
			title = { Text(text = "Welcome") }, colors = TopAppBarDefaults.topAppBarColors(
				containerColor = Topcolor, titleContentColor = Textcolor1
			)
		)
	}) { paddingValues ->
		Image(
			painter = painterResource(id = R.drawable.secondtop),
			modifier = Modifier
				.height((screenHeight / 3).dp)
				.fillMaxWidth(),
			contentScale = ContentScale.Crop,
			contentDescription = ""
		)
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(paddingValues)
		) {

			ConstraintLayout(
				modifier = Modifier
					.fillMaxSize()
			) {
				val (banner, grid, coffee, cart) = createRefs()

				Column(modifier = Modifier
					.constrainAs(banner) {
						top.linkTo(parent.top)
						start.linkTo(parent.start)
						end.linkTo(parent.end)
					}
					.padding(horizontal = 10.dp)) {


					Text(
						text = stringResource(id = R.string.coffee_title),
						fontSize = (screenWidth / 20).sp,
						color = Color.White,
						modifier = Modifier.padding(10.dp)
					)

					Image(
						painter = painterResource(id = R.drawable.searchbar),
						modifier = Modifier
							.fillMaxWidth()
							.height((screenHeight / 20).dp),
						contentScale = ContentScale.Crop,
						contentDescription = null
					)

					Image(
						painter = painterResource(id = R.drawable.banner),
						modifier = Modifier
							.padding(vertical = 10.dp)
							.height((screenHeight / 6).dp)
							.fillMaxWidth(),
						contentScale = ContentScale.FillBounds,
						contentDescription = null
					)
				}

				LazyVerticalGridScrollbar(
					state = listState,
					modifier = Modifier
						.constrainAs(grid) {
							top.linkTo(banner.bottom)
							start.linkTo(parent.start)
							end.linkTo(parent.end)
							bottom.linkTo(cart.top)
							height = Dimension.fillToConstraints
						},
					settings = ScrollbarSettings.Default,
				) {
					LazyVerticalGrid(columns = GridCells.Fixed(2),
						modifier = Modifier
							.constrainAs(coffee) {
								top.linkTo(grid.bottom)
								start.linkTo(grid.start)
								end.linkTo(grid.end)
								bottom.linkTo(parent.bottom)
							}
							.fillMaxSize()) {
						items(coffeeItems) { item ->
							Coffeebox(painterResource(item.image), item.price)
						}
					}
				}

				Button(
					modifier = Modifier
						.padding(vertical = 3.dp)
						.width((screenWidth / 4 * 3).dp)
						.constrainAs(cart) {
							top.linkTo(grid.bottom)
							bottom.linkTo(parent.bottom)
							start.linkTo(parent.start)
							end.linkTo(parent.end)
						},
					onClick = { navController.navigate("paidscreen") },
					colors = ButtonDefaults.buttonColors(
						containerColor = ButtonOrange,
						contentColor = Textcolor1
					),
				) {
					Text(
						text = stringResource(id = R.string.pay),
						fontSize = 20.sp
					)
				}
			}
		}
	}
}

@Preview(
	showBackground = true,
	uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun CoffeeDetailsPreview() {
	CoffeeComposeTheme {
		val navController = rememberNavController()
		CoffeeDetails(navController)
	}
}
