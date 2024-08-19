package com.glitch.coffeecompose.ui.coffeedetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
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
import com.glitch.coffeecompose.R
import com.glitch.coffeecompose.ui.common.Coffeebox
import com.glitch.coffeecompose.ui.common.coffeeItems
import com.glitch.coffeecompose.ui.theme.CoffeeComposeTheme
import com.glitch.coffeecompose.ui.theme.Textcolor1
import com.glitch.coffeecompose.ui.theme.Topcolor
import my.nanihadesuka.compose.LazyVerticalGridScrollbar
import my.nanihadesuka.compose.ScrollbarSettings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeDetails() {

	val configuration = LocalConfiguration.current

	val screenWidth = configuration.screenWidthDp
	val screenHeight = configuration.screenHeightDp

	val listState = rememberLazyGridState()

	Scaffold(
		topBar = {
			TopAppBar(
				title = { Text(text = "Welcome") },
				colors = TopAppBarDefaults.topAppBarColors(
					containerColor = Topcolor,
					titleContentColor = Textcolor1
				)
			)
		}
	) { paddingValues ->
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
				val (banner, grid, coffee) = createRefs()

				Column(
					modifier = Modifier
						.constrainAs(banner) {
							top.linkTo(parent.top)
							start.linkTo(parent.start)
							end.linkTo(parent.end)
						}
						.padding(horizontal = 10.dp)
				) {

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
							.height((screenHeight/20).dp),

						contentScale = ContentScale.Crop,

						contentDescription = null
					)

					Image(
						painter = painterResource(id = R.drawable.banner),
						modifier = Modifier
							.padding(vertical = 10.dp)
							.fillMaxWidth(),
						contentScale = ContentScale.Crop,
						contentDescription = null
					)
				}


				//LazyColumnScrollbar
				LazyVerticalGridScrollbar(
					state = listState,
					modifier = Modifier
						.constrainAs(grid) {
							top.linkTo(banner.bottom)
							start.linkTo(parent.start)
							end.linkTo(parent.end)
							//bottom.linkTo(parent.bottom)
						},
					settings = ScrollbarSettings.Default,
				) {
					////////


					LazyVerticalGrid(
						columns = GridCells.Fixed(2),
						modifier = Modifier
							.constrainAs(coffee) {
								top.linkTo(grid.bottom)
								start.linkTo(grid.start)
								end.linkTo(grid.end)
								bottom.linkTo(grid.bottom)
							}
							.fillMaxSize()
					) {
						items(coffeeItems) { item ->
							Coffeebox(painterResource(item.image), item.count)
						}
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
