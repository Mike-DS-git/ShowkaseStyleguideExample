package com.example.showkasestyleguide

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.android.showkase.annotation.ShowkaseComposable


@Preview
@Composable
fun BoxExample() {
	Box(modifier = Modifier
		.width(100.dp)
		.height(100.dp)
		.background(
			color = Color.Cyan,
			shape = RoundedCornerShape(16.dp), // Background with rounded corners
		)
		.border(
			width = 5.dp,
			color = Color.Blue,
			shape = RoundedCornerShape(16.dp), // Border with rounded corners
			// shape = CutCornerShape(16.dp) // Border with cut corners
		)
	)
}

@Preview
@Composable
fun TextExample() {
	Text(
		text = "Hello, World!",
		color = Color.White,
		fontSize = 24.sp,
		modifier = Modifier
			.background(
				color = Color.Blue,
				shape = RoundedCornerShape(16.dp)
			)
			.border(
				width = 5.dp,
				color = Color.White,
				shape = RoundedCornerShape(16.dp)
			)
			.padding(16.dp)
	)
}

@ShowkaseComposable(name = "AlertDialog", group = "Dialogs", defaultStyle = true)
@Preview(name = "Landscape Preview", showBackground = true, widthDp = 640, heightDp = 360)
@Composable
fun BoxExampleLandscapePreview() {
	AlertDialogExample({}, {})
}

@Composable
fun AlertDialogExample(
	onDismissRequest: () -> Unit,
	onConfirm: () -> Unit
) {
	/**
	 * remember: Stores a value in memory across recompositions. It allows you to persist values without recalculating them on every recomposition.
	 * mutableStateOf: Creates a mutable state holder that triggers recompositions when its value changes.
	 * */
	val shouldShowDialog = remember { mutableStateOf(true) }

	if (shouldShowDialog.value) {
		AlertDialog(
			onDismissRequest = onDismissRequest,
			title = {
				Text(text = "AlertDialog Title")
			},
			text = {
				Text("This is the content of the AlertDialog.")
			},
			confirmButton = {
				TextButton(onClick = {
					// TODO Handle dismiss button click
					onDismissRequest()
					shouldShowDialog.value = false
				}) {
					Text("OK")
				}
			},
			dismissButton = {
				TextButton(onClick = {
					// TODO Handle dismiss button click
					onDismissRequest()
					shouldShowDialog.value = false
					onConfirm()
				}) {
					Text("Cancel", color = Color.Red)
				}
			}
		)
	}
}

