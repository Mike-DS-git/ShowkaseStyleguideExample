package com.example.showkasestyleguide

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

/**
 * 1. remember and mutableStateOf
 * remember: Stores a value in memory across recompositions. It allows you to persist values without recalculating them on every recomposition.
 * mutableStateOf: Creates a mutable state holder that triggers recompositions when its value changes.
 * */
@Composable
@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
fun Example1() {
	// Create a state variable
	val count = remember { mutableIntStateOf(1) }

	// Display and modify the state
	Column {
		Text(text = "Count: ${count.intValue}", modifier = Modifier.padding(16.dp))
		Button(onClick = { count.intValue++ }) {
			Text("Increment")
		}
	}
}


/**
 * 2. rememberSaveable
 * rememberSaveable: Similar to remember, but it also saves and restores state across configuration changes (like screen rotations).
 * It uses a Saver to handle the state preservation.
 * */
@Composable
@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
fun Example2() {
	// Create a state variable that survives configuration changes
	val count = rememberSaveable { mutableIntStateOf(0) }

	Column {
		Text(text = "Count: ${count.intValue}")
		Button(onClick = { count.intValue++ }) {
			Text("Increment")
		}
	}
}


/**
 * 3. State Interface
 * State: Represents a read-only interface for a state holder. You use State<T> when you want to read a state value
 * without directly modifying it.
 * */
@Composable
fun Example3(state: State<Int>) {
	// Display the state value
	Text(text = "Count: ${state.value}")
}


/**
 * 4. LaunchedEffect
 * LaunchedEffect: A composable that allows you to perform side effects in response to changes in the provided keys.
 * It’s used for launching coroutines and performing asynchronous operations.
 *
 * This code runs whenever the composable is recomposed, which includes the initial composition and any
 * subsequent recompositions due to state changes.
 *
 * You do not get explicit guarantees about when this code runs in relation to the layout process.
 * This code will execute before the composable has completed its layout pass and before other side effects.
 * */
@Composable
fun Example4(data: String) {
	LaunchedEffect(data) {
		// It is a coroutine scope
		// Perform an operation when 'data' changes
		// TODO fetchDataFromNetwork(data)
		//  take a look at the example LaunchEffectStateActivity
	}
}


/**
 * 5. DerivedStateOf
 * DerivedStateOf: Creates a state that is derived from other states. It recalculates its value only when
 * its dependencies change.
 *
 * derivedStateOf ensures that the doubledCount is recalculated only when count.value changes.
 * This is efficient because it avoids unnecessary recalculations if the count.value remains the same.
 * */
@Composable
fun Example5(count: State<Int>) {
	val doubledCount by remember { derivedStateOf { count.value * 2 } }
	Text(text = "Doubled Count: $doubledCount")
}


/**
 * 6. rememberCoroutineScope
 * rememberCoroutineScope: Provides a CoroutineScope that is tied to the composable's lifecycle.
 * It is useful for launching coroutines.
 * */
@Composable
fun Example6() {
	val coroutineScope = rememberCoroutineScope()

	Button(onClick = {
		coroutineScope.launch {
			// Perform an asynchronous operation
			// TODO fetchData()
		}
	}) {
		Text("Fetch Data")
	}
}


/**
 * 7. SideEffect
 * SideEffect: Executes a block of code every time the composable is recomposed, and is generally used
 * for non-UI related side effects.
 *
 * The code inside SideEffect runs after the composable has been fully committed to the composition,
 * meaning it runs after the layout pass and the composable has been rendered.
 *
 * SideEffect is useful for operations that need to be in sync with the final layout state of the composable.
 * This is particularly important for tasks like sending analytics events or triggering external side effects that rely on the final state of the UI.
 * */
@Composable
fun Example7(count: Int) {
	SideEffect {
		// Perform a side effect, like logging or analytics
		Log.d("Example", "Count is $count")
	}
}