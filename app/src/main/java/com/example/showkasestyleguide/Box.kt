package com.example.showkasestyleguide

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class BoxActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			BoxExample()
		}
	}

	@Composable
	fun BoxExample() {
		Box(
			modifier = Modifier
				// .width(100.dp)
				// .height(100.dp)
				.fillMaxSize() // Parent Box fills the entire screen
				.systemBarsPadding() // Apply padding to avoid system bars
				.padding(16.dp) // Additional padding
				.border(
					width = 2.dp,
					color = Color.DarkGray,
					shape = RoundedCornerShape(16.dp), // Border with rounded corners
					// shape = CutCornerShape(16.dp) // Border with cut corners
				)
				.background(
					color = Color.LightGray,
					shape = RoundedCornerShape(16.dp) // Background color with rounded corners
				),

			contentAlignment = Alignment.Center // Align the content to the center
		) {
			Box(modifier = Modifier.wrapContentSize()) {
				Text(
					text = "Centered Box",
					color = Color.Black,
					style = MaterialTheme.typography.bodyLarge
				)
			}
		}
	}

	@Preview(showBackground = true)
	@Composable
	fun PreviewBoxExample() {
		BoxExample()
	}

	companion object {
		fun getIntent(activity: ComponentActivity) = Intent(activity, BoxActivity::class.java)
	}
}