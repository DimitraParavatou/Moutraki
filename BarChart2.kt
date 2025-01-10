package com.example.myapp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RotatedBarChart(data: List<Float>, maxValue: Float) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val barHeight = size.height / (data.size * 2) // Height of each bar
        val maxWidth = size.width

        // Draw bars rotated 90 degrees to the right
        data.forEachIndexed { index, value ->
            val barWidth = (value / maxValue) * maxWidth // Width of each bar
            val x = index * 2 * barHeight + barHeight // Position of the bar
            val y = size.height - barWidth // Y position (inverted)

            drawRect(
                color = Color.Blue,
                topLeft = Offset(0f, y),
                size = Size(barWidth, barHeight)
            )
        }

        // Draw X-axis labels
        drawXLabels(maxValue)
    }
}

private fun DrawScope.drawXLabels(maxValue: Float) {
    val step = maxValue / 5 // Divide the X-axis into 5 steps
    val maxHeight = size.height

    for (i in 0..5) {
        val y = maxHeight - (i * (maxHeight / 5)) // Y position for labels
        val label = (i * step).toInt().toString()

        // Draw the label
        drawContext.canvas.nativeCanvas.drawText(
            label,
            10f, // X position for labels
            y,
            android.graphics.Paint().apply {
                color = android.graphics.Color.BLACK
                textSize = 30f
            }
        )
    }
}

// Preview for BarChart
@Preview(showBackground = true)
@Composable
fun PreviewBarChart2() {
    val data = listOf(10f, 20f, 30f, 25f, 15f)
    val maxValue = data.maxOrNull() ?: 1f // Get the maximum value for scaling
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        RotatedBarChart(data = data, maxValue = maxValue)
        Text(text = "Bar Chart: Represents the distribution of values.", style = MaterialTheme.typography.bodyLarge)
    }

}