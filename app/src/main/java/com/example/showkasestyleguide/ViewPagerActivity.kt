package com.example.showkasestyleguide

import android.content.Context
import android.os.Bundle
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

class ViewPagerActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ViewPagerScreen()
		}
	}

	companion object {
		fun getIntent(context: Context) = android.content.Intent(context, ViewPagerActivity::class.java)
	}
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ViewPagerScreen() {
	val pagerState = rememberPagerState()
	val context = LocalContext.current
	val accessibilityManager = context.getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager

	LaunchedEffect(pagerState.currentPage) {
//		val currentPageDescription = "Page ${pagerState.currentPage + 1}"
//		if (accessibilityManager.isEnabled) {
//			accessibilityManager.announceForAccessibility(currentPageDescription)
//		}
	}

	Surface(
		modifier = Modifier.fillMaxSize(),
		color = MaterialTheme.colorScheme.background
	) {
		Column(
			modifier = Modifier.fillMaxSize(),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center
		) {
			HorizontalPager(
				state = pagerState,
				count = 6,
				modifier = Modifier.fillMaxWidth()
			) { page ->
				when (page) {
					0 -> PageContent("Title 1", R.drawable.image_1)
					1 -> PageContent("Title 2", R.drawable.image_1)
					2 -> PageContent("Title 3", R.drawable.image_1)
					3 -> PageContent("Title 4", R.drawable.image_1)
					4 -> PageContent("Title 5", R.drawable.image_1)
					5 -> PageContent("Title 6", R.drawable.image_1)
				}
			}
		}
	}
}

@Composable
fun PageContent(text: String, imageResId: Int) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(16.dp),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		Image(
			painter = painterResource(id = imageResId),
			contentDescription = null,
			modifier = Modifier
				.height(350.dp)
//				.padding(70.dp)
				.fillMaxWidth()
		)
		BasicText(
			text = text,
//			style = MaterialTheme.typography.h4.copy(fontSize = 24.sp),
			style = MaterialTheme.typography.bodyLarge.copy(fontSize = 24.sp),
			modifier = Modifier.padding(top = 16.dp)
		)
	}
}

fun AccessibilityManager.announceForAccessibility(text1: CharSequence) {
	(this as? AccessibilityManager)?.sendAccessibilityEvent(
		AccessibilityEvent().apply {
			eventType = AccessibilityEvent.TYPE_ANNOUNCEMENT
			text.add(text1)
		}
	)
}