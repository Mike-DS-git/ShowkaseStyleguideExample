package com.example.showkasestyleguide

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

class CollapsingToolBarActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			CollapsingToolbarPreview()
		}
	}

	@Preview(showBackground = true)
	@Composable
	fun CollapsingToolbarPreview() {
		CollapsingToolbar()
	}

	@OptIn(ExperimentalMaterial3Api::class)
	@Composable
	fun CollapsingToolbar() {
		val toolbarHeight = 56.dp
		val maxOffset = 200.dp
		val scrollState = rememberScrollState()

		Box {
			// Collapsible toolbar
			Box(
				modifier = Modifier
					.fillMaxWidth()
					.height(maxOffset)
					.graphicsLayer {

						// changing alpha example
						val collapseRange = maxOffset.toPx() - toolbarHeight.toPx()
						val collapseFraction = (scrollState.value / collapseRange).coerceIn(0f, 1f)
						alpha = lerp(1f, 0f, collapseFraction)

						// parallax effect
						translationY = lerp(0f, -maxOffset.toPx() / 3, collapseFraction)
					}
			) {
				Image(
					painter = painterResource(id = R.drawable.bg_profile_header),
					contentDescription = null,
					contentScale = ContentScale.Crop,
					modifier = Modifier.fillMaxSize()
				)
			}

			// Toolbar
			CenterAlignedTopAppBar(
				title = {
					Text("Collapsing Toolbar", Modifier.padding(16.dp))
				},
				modifier = Modifier
					.height(toolbarHeight)
					.graphicsLayer {
						val collapseRange = maxOffset.toPx() - toolbarHeight.toPx()
						val collapseFraction = (scrollState.value / collapseRange).coerceIn(0f, 1f)
						alpha = lerp(0f, 1f, collapseFraction)
					}
					.zIndex(1f)
					.shadow(elevation = 0.dp)
					.background(Color.Transparent)
			)

			// Content
			Column(
				modifier = Modifier
					.fillMaxSize()
					.verticalScroll(scrollState)
					.padding(top = maxOffset)
			) {
				repeat(20) {
					Card(
						shape = RoundedCornerShape(8.dp),
						colors = CardDefaults.cardColors(containerColor = Color.LightGray),
						border = BorderStroke(2.dp, Color.Gray),
						modifier = Modifier
							.fillMaxWidth()
							.padding(8.dp)
							.height(100.dp)
					) {
						Text(
							text = "Item $it",
							modifier = Modifier.padding(16.dp)
						)
					}
				}
			}
		}
	}

	// Utility function to interpolate Float values
	private fun lerp(start: Float, stop: Float, fraction: Float): Float {
		return start + (stop - start) * fraction
	}

	companion object {
		fun getIntent(context: Context) = Intent(context, CollapsingToolBarActivity::class.java)
	}
}