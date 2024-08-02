package com.example.showkasestyleguide

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.graphics.toArgb
import com.airbnb.android.showkase.models.Showkase
import com.example.showkasestyleguide.colorlist.ColorList

/**
 * The StyleGuideActivity is custom StyleGuide activity.
 * */
class StyleGuideActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		// Get the list of colors from Showkase metadata.
		val colors = Showkase.getMetadata().colorList.map { color ->
			color.colorName to color.color.toArgb()
		}

		enableEdgeToEdge()

		setContent {

			ColorList(colors = mapOf("Colors_001" to colors))
		}
	}

	companion object {
		fun getIntent(context: Context) = Intent(context, StyleGuideActivity::class.java)
	}
}