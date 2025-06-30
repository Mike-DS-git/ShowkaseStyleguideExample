package com.example.showkasestyleguide

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.airbnb.android.showkase.models.Showkase

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("detail/{message}") { backStackEntry ->
            val msg = backStackEntry.arguments?.getString("message") ?: "No message"
            DetailScreen(msg)
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(50.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MenuButton(
            text = "Standard StyleGuide",
            onClick = {
                context.startActivity(Showkase.getBrowserIntent(context))
            }
        )

        Spacer(modifier = Modifier.padding(16.dp))

        MenuButton(
            text = "Custom StyleGuide",
            onClick = {
                context.startActivity(StyleGuideActivity.getIntent(context))
            }
        )

        Spacer(modifier = Modifier.padding(16.dp))

        MenuButton(
            text = "Box Layout",
            onClick = {
                context.startActivity(BoxActivity.getIntent(context))
            }
        )

        Spacer(modifier = Modifier.padding(16.dp))

        MenuButton(
            text = "Launch Effect State Activity",
            onClick = {
                context.startActivity(LaunchEffectStateActivity.getIntent(context))
            }
        )

        Spacer(modifier = Modifier.padding(16.dp))

        MenuButton(
            text = "Collapsing Toolbar Activity",
            onClick = {
                context.startActivity(CollapsingToolBarActivity.getIntent(context))
            }
        )

        Spacer(modifier = Modifier.padding(16.dp))

        MenuButton(
            text = "ViewPager Activity",
            onClick = {
                context.startActivity(ViewPagerActivity.getIntent(context))
            }
        )

        Spacer(modifier = Modifier.padding(16.dp))

        MenuButton(
            text = "WebView Activity",
            onClick = {
                context.startActivity(WebViewActivity.getIntent(context))
            }
        )

        Spacer(modifier = Modifier.padding(16.dp))

        MenuButton("Navigation") {
            navController.navigate("detail/HelloFromHome")
        }
    }
}

@Composable
fun DetailScreen(message: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Detail Screen: $message")
    }
}