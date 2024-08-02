package com.example.showkasestyleguide

import androidx.compose.ui.graphics.Color
import com.airbnb.android.showkase.annotation.ShowkaseColor

/**
 * This file is used to showcase how colors can be displayed in the Showkase browser app.
 * */

/**
 * This is a sample wrapper class that contains a primary color.
 */
class WrapperClass {
	@ShowkaseColor("Primary", COLOR_GROUP_LIGHT)
	val primary = Color(0xFF6200EE)
}

/**
 * This is a sample wrapper object that contains a primary variant color.
 */
object WrapperObject {
	@ShowkaseColor("Secondary", COLOR_GROUP_LIGHT)
	val primaryVariant = Color(0xFF3700B3)
}

@ShowkaseColor("Info", COLOR_GROUP_LIGHT)
val secondary = Color(0xFF03DAC6)

@ShowkaseColor("Caption", COLOR_GROUP_LIGHT)
val secondaryVariant = Color(0xFF018786)

@ShowkaseColor("Label", COLOR_GROUP_LIGHT)
val background = Color.White

@ShowkaseColor("Surface", COLOR_GROUP_LIGHT)
val surface = Color.White

@ShowkaseColor("Error", COLOR_GROUP_LIGHT)
val error = Color(0xFFB00020)

const val COLOR_GROUP_LIGHT = "Light Colors"