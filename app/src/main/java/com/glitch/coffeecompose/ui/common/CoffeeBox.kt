package com.glitch.coffeecompose.ui.common


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glitch.coffeecompose.R
import com.glitch.coffeecompose.ui.theme.CoffeeComposeTheme
import com.glitch.coffeecompose.ui.theme.Maincolor
import com.glitch.coffeecompose.ui.theme.Textcolor1

@Composable
fun Coffeebox(image: Painter, cont: String) {

	val counter = remember {
		mutableStateOf(0)
	}

	Column(
		modifier = Modifier
			.padding(8.dp) // Adjusted padding to give more space
			.fillMaxWidth() // Make sure it fills the available width in the Row
	) {
		Image(
			painter = image,
			modifier = Modifier
				.fillMaxWidth(),
			contentScale = ContentScale.Crop,
			contentDescription = null
		)

		Text(
			text = stringResource(id = R.string.coffee_mocha),
			fontSize = 24.sp,
			fontWeight = FontWeight.Bold,
			modifier = Modifier.padding(top = 8.dp)
		)

		Text(
			text = stringResource(id = R.string.deep_foam),
			fontSize = 16.sp,
			modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
		)

		Row(
			horizontalArrangement = Arrangement.SpaceEvenly
		) {
			Text(
				text = counter.value.toString(),
				fontSize = 16.sp,
				modifier = Modifier
					.padding(top = 4.dp, bottom = 8.dp)
			)

			Button(
				onClick = {

				},
				colors = ButtonDefaults.buttonColors(
					containerColor = Maincolor,
					contentColor = Textcolor1
				)
			) {
				Text(text = "Order")
			}
		}

	}
}


@Preview(showBackground = true)
@Composable
fun CoffeeDetailsPreview() {
	CoffeeComposeTheme {
		Coffeebox(painterResource(id = R.drawable.coffee1), "aaaaaaaaaa")
	}
}
