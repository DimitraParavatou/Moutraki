package com.example.myapp

// LineChart.kt
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

// Define custom colors
val CustomLineColor = Color(102, 255, 158) // Custom RGB color
val CustomPointColor = Color(255, 153, 153) // Custom RGB color

@Composable
fun LineChart(data: List<Float>) {
    val maxValue = data.maxOrNull() ?: 1f
    val chartHeight = 200.dp
    val chartWidth = 300.dp

    Canvas(modifier = Modifier
        .size(chartWidth, chartHeight)
        .padding(16.dp)) {
        val widthPerPoint = size.width / (data.size - 1)
        val heightPerUnit = size.height / maxValue

        for (i in 0 until data.size - 1) {
            drawLine(
                color = CustomLineColor,
                start = androidx.compose.ui.geometry.Offset(i * widthPerPoint, size.height - (data[i] * heightPerUnit)),
                end = androidx.compose.ui.geometry.Offset((i + 1) * widthPerPoint, size.height - (data[i + 1] * heightPerUnit)),
                strokeWidth = 4f
            )
        }

        for (i in data.indices) {
            drawCircle(
                color = CustomPointColor,
                radius = 6f,
                center = androidx.compose.ui.geometry.Offset(i * widthPerPoint, size.height - (data[i] * heightPerUnit))
            )
        }
    }
    Spacer(modifier = Modifier.height(4.dp)) //A Spacer is added to create vertical space of 4 dp between the bar and the text label below it.
    //Text(text = value.toString()) //A Text composable is created to display the value of the bar as a string below the bar.
    Spacer(modifier = Modifier.height(4.dp))
    Text(text = "Month")
}

// Preview for LineChart
@Preview(showBackground = true)
@Composable
fun PreviewLineChart() {
    LineChart(data = listOf(10f, 20f, 15f, 30f, 25f)) // Sample data for preview
    Text(text = "Line Chart: Shows the distribution for the selected emotion", style = MaterialTheme.typography.bodyLarge)
}