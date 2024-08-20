package com.glitch.coffeecompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.glitch.coffeecompose.cartScreen.CartScreen
import com.glitch.coffeecompose.ui.coffeedetail.CoffeeDetails
import com.glitch.coffeecompose.ui.paidScreen.PaidScreen
import com.glitch.coffeecompose.ui.pastrydetail.PastryDetails
import com.glitch.coffeecompose.ui.welcomescreen.WelcomePage

@Composable
fun PageSwitch() {
	val navController = rememberNavController()

	NavHost(navController = navController, startDestination = "welcomepage") {

		composable("welcomepage") {
			WelcomePage(navController = navController)
		}

		composable("coffeedetails") {
			CoffeeDetails(navController = navController)
		}

		composable("pastrydetails") {
			PastryDetails(navController = navController)
		}

		composable("cartscreen") {
			CartScreen(navController = navController)
		}
		composable("paidscreen") {
			PaidScreen(navController = navController)
		}
	}
}