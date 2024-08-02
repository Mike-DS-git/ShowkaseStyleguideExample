package com.example.showkasestyleguide

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.airbnb.android.showkase.annotation.ShowkaseComposable
import com.airbnb.android.showkase.ui.padding4x
import com.example.showkasestyleguide.ui.theme.ShowkaseStyleGuideExampleTheme

/**
 * This component shows some static text in cursive text style.
 */
@ShowkaseComposable(name = "Cursive Text Style", group = TEXT_GROUP)
@Composable
fun CursiveTextComponent() {
	val context = LocalContext.current
	val string = context.getString(R.string.app_name)

	ShowkaseStyleGuideExampleTheme {
		Card {
			Text(
				text = string, modifier = Modifier
					.fillMaxWidth()
					.padding(padding4x),
				style = TextStyle(
					fontSize = 16.sp, fontWeight = FontWeight.Bold,
					fontFamily = FontFamily.Cursive
				)
			)
		}
	}
}

@ShowkaseComposable(name = "Serif Text Style", group = TEXT_GROUP)
@Composable
fun SerifTextComponentPreview() {
	val context = LocalContext.current
	val string = context.getString(R.string.app_name)

	ShowkaseStyleGuideExampleTheme {
		Card {
			Text(
				text = string, modifier = Modifier
					.fillMaxWidth()
					.padding(padding4x),
				style = TextStyle(
					fontSize = 16.sp, fontWeight = FontWeight.Bold,
					fontFamily = FontFamily.Serif
				)
			)
		}
	}
}

@ShowkaseComposable(name = "Sans Serif Text Style", group = TEXT_GROUP)
@Composable
fun SansSerifTextComponentPreview() {
	val context = LocalContext.current
	val string = context.getString(R.string.app_name)

	ShowkaseStyleGuideExampleTheme {
		Card {
			Text(
				text = string, modifier = Modifier
					.fillMaxWidth()
					.padding(padding4x),
				style = TextStyle(
					fontSize = 16.sp, fontWeight = FontWeight.Bold,
					fontFamily = FontFamily.SansSerif
				)
			)
		}
	}
}

@ShowkaseComposable(name = "H4 Text Row", group = TEXT_GROUP)
@Composable
fun H4TextRowComponentPreview() {
	val context = LocalContext.current
	val string = context.getString(R.string.app_name)

	ShowkaseStyleGuideExampleTheme {
		Card {
			Text(
				text = string,
				modifier = Modifier
					.fillMaxWidth()
					.padding(padding4x),
				style = Material.h4
			)
		}
	}
}

const val TEXT_GROUP = "Text"