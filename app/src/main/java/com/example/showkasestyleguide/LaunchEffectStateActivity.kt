package com.example.showkasestyleguide

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

// for a 'val' variable
import androidx.compose.runtime.getValue
// for a `var` variable also add
import androidx.compose.runtime.setValue


class LaunchEffectStateActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			NetworkRequestExamplePreview()
		}
	}

	companion object {
		fun getIntent(activity: ComponentActivity) = Intent(activity, LaunchEffectStateActivity::class.java)
	}
}

@Preview(showBackground = true)
@Composable
fun NetworkRequestExamplePreview() {
	MaterialTheme {
		NetworkRequestExample()
	}
}

@Composable
fun NetworkRequestExample() {
	// State to hold the result of the network request
	var result by remember { mutableStateOf("No data yet") }

	// State to track if a request is in progress
	var isLoading by remember { mutableStateOf(false) }

	// LaunchedEffect to perform the network request when `isLoading` becomes true
	LaunchedEffect(isLoading) {
		if (isLoading) {
			// Simulate network delay
			delay(3000)
			// Update the result state
			result = "Data fetched from network"
			// Reset the loading state
			isLoading = false
		}
	}

	// UI elements
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(16.dp),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		Text(text = result, style = MaterialTheme.typography.bodyLarge)

		Spacer(modifier = Modifier.height(16.dp))

		Button(
			onClick = { isLoading = true },
			enabled = !isLoading
		) {
			if (isLoading) {
				CircularProgressIndicator(modifier = Modifier.size(24.dp))
			} else {
				Text("Fetch Data")
			}
		}
	}
}