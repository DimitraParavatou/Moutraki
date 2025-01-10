package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapp.ui.theme.MyAppTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //DropdownMenuMood()
            MaterialTheme {
                Surface (color = MaterialTheme.colorScheme.background) {
                    // Use a Column to stack the charts vertically
//                    Column(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(16.dp), // Add padding around the column
//                        verticalArrangement = Arrangement.spacedBy(16.dp) // Space between charts
//                    ) {
                        //BarChart(data = listOf(10f, 20f, 15f, 30f, 25f)) // BarChart composable call
                        DropdownMenuMood()
                        DropdownMenuEmotions()
                        //LineChart(data = listOf(10f, 20f, 15f, 30f, 25f)) // LineChart composable call
                    //}
                }
            }
        }
    }
}

//@Composable
//fun MainScreen() {
//    val data = listOf(10f, 20f, 30f, 25f, 15f)
//    val maxValue = data.maxOrNull() ?: 1f // Get the maximum value for scaling
//
//    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//        BarChart2(data = data, maxValue = maxValue)
//    }
//}
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            DropdownMenuExample()
//        }
//    }
//}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyAppTheme {
        Greeting("Android")
    }
}