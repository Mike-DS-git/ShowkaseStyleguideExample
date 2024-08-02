package com.example.showkasestyleguide.colorlist

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ColorItem(colorPairs: List<Pair<String, Int>>) {
	val params = Modifier
		.wrapContentSize()
		.padding(2.dp)

	LazyRow(modifier = Modifier.fillMaxWidth()) {
		items(count = colorPairs.size) { keyIdx ->
			ColorView(colorPairs[keyIdx], false, params)
		}
	}
}