package com.example.myapp

// BarChart.kt
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

// Define custom colors
val CustomBarColor = Color(153, 204, 255) // Custom RGB color

@Composable
fun BarChart(data: List<Float>) { //the heights of the bars in the chart
    val maxValue = data.maxOrNull() ?: 1f
    val barWidth = 40.dp //density-independent pixels (dp)
    val spacing = 16.dp

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), //adds 16 dp of padding around it
        horizontalArrangement = Arrangement.spacedBy(spacing)
    ) {
        data.forEach { value ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(barWidth)
            ) {
                Canvas(modifier = Modifier
                    .fillMaxHeight(0.8f) //fills 80% of the height of the parent and sets the width to barWidth
                    .width(barWidth)) {
                    val barHeight = size.height * (value / maxValue) //calculates the height of the bar based on the current value relative to maxValue. The height is a proportion of the available height of the canvas
                    drawRect( //o draw a rectangle (the bar) on the canvas
                        color = CustomBarColor , // Use custom color,
                        size = size.copy(width = size.width, height = barHeight) //The size parameter creates a rectangle that spans the full width of the canvas and has a height equal to barHeight.
                    )
                }
                Spacer(modifier = Modifier.height(4.dp)) //A Spacer is added to create vertical space of 4 dp between the bar and the text label below it.
                Text(text = value.toString()) //A Text composable is created to display the value of the bar as a string below the bar.
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Month")
            }
        }
    }
}

// Preview for BarChart
@Preview(showBackground = true)
@Composable
fun PreviewBarChart() {
    Text(
        text = "Bar Chart: Represents the distribution of x mood For each month.",
        style = MaterialTheme.typography.bodyLarge
    )
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        BarChart(data = listOf(10f, 20f, 15f, 30f, 25f)) // Sample data for preview
    }
}