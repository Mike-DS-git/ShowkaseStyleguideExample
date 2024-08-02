package com.example.showkasestyleguide.colorlist

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ColorList(colors: Map<String, List<Pair<String, Int>>>) {
	val keys = remember { colors.keys.toList() }

	LazyColumn(modifier = Modifier.padding(16.dp).wrapContentSize()) {
		items(count = colors.size, key = { index -> keys[index] }) { keyIdx ->
			keys[keyIdx].let { key ->
				colors[key]?.let { colorPairs ->
					ColorItem(colorPairs)
					Spacer(modifier = Modifier.padding(16.dp))
				}
			}
		}
	}
}