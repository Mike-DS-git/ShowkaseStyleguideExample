package com.example.showkasestyleguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.airbnb.android.showkase.models.Showkase

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {

			Column(modifier = Modifier
				.padding(50.dp)
				.fillMaxSize(),
				verticalArrangement = Arrangement.Center,
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				MenuButton(
					text = "Standard StyleGuide",
					onClick = {
						startActivity(Showkase.getBrowserIntent(this@MainActivity))
					}
				)

				Spacer(modifier = Modifier.padding(16.dp))

				MenuButton(
					text = "Custom StyleGuide",
					onClick = {
						startActivity(StyleGuideActivity.getIntent(this@MainActivity))
					}
				)

				Spacer(modifier = Modifier.padding(16.dp))

				MenuButton(
					text = "Box Layout",
					onClick = {
						startActivity(BoxActivity.getIntent(this@MainActivity))
					}
				)

				Spacer(modifier = Modifier.padding(16.dp))

				MenuButton(
					text = "Launch Effect State Activity",
					onClick = {
						startActivity(LaunchEffectStateActivity.getIntent(this@MainActivity))
					}
				)

				Spacer(modifier = Modifier.padding(16.dp))

				MenuButton(
					text = "Collapsing Toolbar Activity",
					onClick = {
						startActivity(CollapsingToolBarActivity.getIntent(this@MainActivity))
					}
				)

				Spacer(modifier = Modifier.padding(16.dp))

				MenuButton(
					text = "ViewPager Activity",
					onClick = {
						startActivity(ViewPagerActivity.getIntent(this@MainActivity))
					}
				)

				Spacer(modifier = Modifier.padding(16.dp))

				MenuButton(
					text = "WebView Activity",
					onClick = {
						startActivity(WebViewActivity.getIntent(this@MainActivity))
					}
				)
			}
		}
	}
}

@Composable
fun MenuButton(
	text: String,
	onClick: () -> Unit,
) {
	Button(
		onClick = onClick,
		shape = RoundedCornerShape(8.dp),
		colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
	) {
		Text(
			text = text,
			modifier = Modifier
				.padding(getPadding(ButtonSize.Large))
				.fillMaxWidth(),
			style = TextStyle(color = Color.White),
			textAlign = TextAlign.Center
		)
	}
}