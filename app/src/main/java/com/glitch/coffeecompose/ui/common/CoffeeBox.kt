package com.glitch.coffeecompose.ui.common


import android.annotation.SuppressLint
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.glitch.coffeecompose.R
import com.glitch.coffeecompose.ui.theme.ButtonOrange
import com.glitch.coffeecompose.ui.theme.CoffeeComposeTheme

@SuppressLint("AutoboxingStateCreation")
@Composable
fun Coffeebox(image: Painter, price: String, coffeeName: Int, coffeeType: Int) {
	val counter = remember {
		mutableStateOf(0)
	}

	val configuration = LocalConfiguration.current

	val screenWidth = configuration.screenWidthDp
	val screenHeight = configuration.screenHeightDp

	Column(
		modifier = Modifier
			.padding(8.dp)
			.fillMaxWidth()
	) {
		Image(
			painter = image,
			modifier = Modifier
				.fillMaxWidth(),
			contentScale = ContentScale.Crop,
			contentDescription = null
		)

		Text(
			text = stringResource(id = coffeeName),
			fontSize = 20.sp,
			fontWeight = FontWeight.Bold,
			modifier = Modifier
				.padding(top = 8.dp)
		)

		Text(
			text = stringResource(id = coffeeType),
			fontSize = 16.sp,
			modifier = Modifier.padding(vertical = 10.dp)
		)

		Row(
			modifier = Modifier
				.fillMaxWidth(),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.SpaceBetween
		) {

			Text(
				text = price,
				fontSize = 20.sp,
				fontWeight = FontWeight.Bold,
			)

			Text(
				text = counter.value.toString(),
				fontSize = 20.sp,
				fontWeight = FontWeight.Bold,
			)

			Row(
				/*modifier = Modifier
					.padding(horizontal = 15.dp),*/
				//horizontalArrangement = Arrangement.SpaceEvenly
			) {
				Box(
					modifier = Modifier
						.size((screenWidth / 10).dp)
						.clip(RoundedCornerShape(4.dp))
						.background(ButtonOrange)
						.clickable(onClick = {
							counter.value += 1
						}),
					contentAlignment = Alignment.Center
				) {
					Image(
						painter = painterResource(id = R.drawable.ic_plus),
						contentScale = ContentScale.Fit,
						contentDescription = null,
						modifier = Modifier.size(24.dp)
					)
				}
				Spacer(modifier = Modifier.padding(1.dp))
				Box(
					modifier = Modifier
						.size((screenWidth / 10).dp)
						.clip(RoundedCornerShape(4.dp))
						.background(ButtonOrange)
						.clickable(onClick = {
							if (counter.value > 0) {
								counter.value -= 1
							}
						}),
					contentAlignment = Alignment.Center
				) {
					Image(
						painter = painterResource(id = R.drawable.ic_minus),
						contentScale = ContentScale.Fit,
						contentDescription = null,
						modifier = Modifier.size(24.dp)
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
		Coffeebox(
			painterResource(id = R.drawable.coffee1),
			"$5",
			R.string.coffee_mocha,
			R.string.deep_foam
		)
	}
}
