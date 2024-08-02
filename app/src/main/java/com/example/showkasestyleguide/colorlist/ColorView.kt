package com.example.showkasestyleguide.colorlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ColorView(colorPair: Pair<String, Int>, isMiddle: Boolean, modifier: Modifier) {
	val backgroundColor = if (isMiddle) Color.Black else Color.White
	val textColor = if (isMiddle) Color.White else Color.Black

	Column(
		modifier = modifier.background(backgroundColor),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		if (isMiddle) {
			val name = colorPair.first.split("_")
			Text(
				text = name[0],
				color = textColor,
				fontSize = 20.sp,
				textAlign = TextAlign.Center
			)
		}
		Text(
			text = colorPair.first.secondPart(),
			color = textColor,
			fontSize = 16.sp,
			textAlign = TextAlign.Center
		)
		Box(
			modifier = Modifier
				.size(50.dp)
				.background(Color(colorPair.second))
		) {
			Text(
				text = Integer.toHexString(colorPair.second),
				color = textColor,
				modifier = Modifier.align(Alignment.Center)
			)
		}
	}
}

// Extension function to get the second part of a string after an underscore
fun String.secondPart(): String {
	val parts = this.split("_")
	return if (parts.size > 1) parts[1] else this
}