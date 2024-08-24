package com.glitch.coffeecompose.ui.common

import com.glitch.coffeecompose.R

data class PastryItem(
	val image: Int,
	val pastryName: Int,
	val coffeeType: Int,
	val count: String,
	val price: String
)

val pastryItems = listOf(
	PastryItem(
		R.drawable.pastry_1,
		R.string.birthday_cake,
		R.string.cake,
		"0",
		"$3.50"
	),
	PastryItem(
		R.drawable.pastry_2,
		R.string.cupcake,
		R.string.cake,
		"0",
		"$6.00"
	),

	PastryItem(
		R.drawable.pastry_3,
		R.string.cake,
		R.string.pie,
		"0",
		"$4.75"
	),

	PastryItem(
		R.drawable.pastry_4,
		R.string.macarons,
		R.string.cookie,
		"0",
		"$5.50"
	),

	PastryItem(
		R.drawable.pastry_1,
		R.string.birthday_cake,
		R.string.cake,
		"0",
		"$7.50"
	),
	PastryItem(
		R.drawable.pastry_2,
		R.string.cupcake,
		R.string.cake,
		"0",
		"$3.50"
	),

	PastryItem(
		R.drawable.pastry_3,
		R.string.pie,
		R.string.cake,
		"0",
		"$4.20"
	),

	PastryItem(
		R.drawable.pastry_4,
		R.string.macarons,
		R.string.cookie,
		"0",
		"$5.30"
	)
)
