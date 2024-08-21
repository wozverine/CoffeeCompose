package com.glitch.coffeecompose.ui.common

import com.glitch.coffeecompose.R

data class PastryItem(
	val image: Int,
	val pastryName: Int,
	val coffeeType: Int,
	val count: String,
	val price: String
)

val PastryItems = listOf(
	PastryItem(
		R.drawable.coffee1,
		R.string.coffee_mocha,
		R.string.deep_foam,
		"0",
		"$1.50"
	)
)
