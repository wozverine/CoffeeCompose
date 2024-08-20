package com.glitch.coffeecompose.ui.common

import com.glitch.coffeecompose.R

data class CoffeeItem(val image: Int, val count: String, val price: String)

val coffeeItems = listOf(
	CoffeeItem(R.drawable.coffee1, "0","$1.50"),
	CoffeeItem(R.drawable.coffee2, "0","$2.00"),
	CoffeeItem(R.drawable.coffee3, "0","$1.80"),
	CoffeeItem(R.drawable.coffee4, "0","$3.00"),
	CoffeeItem(R.drawable.coffee1, "0","$5.40"),
	CoffeeItem(R.drawable.coffee2, "0","$1.20"),
	CoffeeItem(R.drawable.coffee3, "0","$2.95"),
	CoffeeItem(R.drawable.coffee4, "0","$4.85"),
)