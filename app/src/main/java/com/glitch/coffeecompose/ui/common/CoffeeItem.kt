package com.glitch.coffeecompose.ui.common

import com.glitch.coffeecompose.R

data class CoffeeItem(
	val image: Int,
	val coffeeName: Int,
	val coffeeType: Int,
	val count: String,
	val price: String
)

val coffeeItems = listOf(
	CoffeeItem(
		R.drawable.coffee1,
		R.string.coffee_mocha,
		R.string.deep_foam,
		"0",
		"$1.50"
	),

	CoffeeItem(
		R.drawable.coffee2,
		R.string.flat_white,
		R.string.espresso,
		"0",
		"$2.00"
	),

	CoffeeItem(
		R.drawable.coffee3,
		R.string.mocha_fushi,
		R.string.ice_hot,
		"0",
		"$1.80"
	),
	CoffeeItem(
		R.drawable.coffee4,
		R.string.caffe_panna,
		R.string.ice_hot,
		"0",
		"$3.00"
	),
	CoffeeItem(
		R.drawable.coffee1,
		R.string.coffee_mocha,
		R.string.deep_foam,
		"0",
		"$5.40"
	),
	CoffeeItem(
		R.drawable.coffee2,
		R.string.flat_white,
		R.string.espresso,
		"0",
		"$1.20"
	),
	CoffeeItem(
		R.drawable.coffee3,
		R.string.mocha_fushi,
		R.string.ice_hot,
		"0",
		"$2.95"
	),
	CoffeeItem(
		R.drawable.coffee4,
		R.string.caffe_panna,
		R.string.ice_hot,
		"0",
		"$4.85"
	)
)