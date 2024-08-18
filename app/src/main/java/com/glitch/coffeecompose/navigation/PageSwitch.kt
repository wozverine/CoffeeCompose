package com.glitch.coffeecompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.glitch.coffeecompose.ui.coffeedetail.CoffeeDetails
import com.glitch.coffeecompose.ui.welcomescreen.WelcomePage

@Composable
fun PageSwitch() {
	val navController = rememberNavController()

	NavHost(navController = navController, startDestination = "welcomepage") {

		composable("welcomepage") {
			WelcomePage(navController = navController)
		}

		composable("detailspage") {
			CoffeeDetails()
		}
	}
}