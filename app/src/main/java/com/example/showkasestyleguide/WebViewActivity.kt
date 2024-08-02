package com.example.showkasestyleguide

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

class WebViewActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			WebViewScreen(url = "https://www.google.com")
		}
	}

	companion object {
		fun getIntent(context: Context) = Intent(context, WebViewActivity::class.java)
	}
}

@Composable
fun WebViewScreen(url: String) {
	val context = LocalContext.current

	AndroidView(
		modifier = Modifier.fillMaxSize(),
		factory = {
			WebView(context).apply {
				settings.javaScriptEnabled = true
				settings.cacheMode = WebSettings.LOAD_DEFAULT
				webViewClient = WebViewClient()
				loadUrl(url)
			}
		},
		update = { webView ->
			webView.loadUrl(url)
		}
	)
}