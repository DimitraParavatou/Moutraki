package com.example.myapp

// PieChart.kt
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp // Import for dp

// Define custom colors directly in this file
val PastelRed = Color(255, 153, 153) // RGB
val PastelGreen = Color(102, 255, 158) // RGB
val PastelBlue = Color(153, 204, 255) // RGB
val CustomPurple = Color(128, 0, 128) // RGB for Purple
val CustomOrange = Color(255, 165, 0) // RGB for Orange

@Composable
fun PieChart(
    modifier: Modifier = Modifier,
    colors: List<Color>,
    inputValues: List<Float>
) {
    val total = inputValues.sum()
    val proportions = inputValues.map { it / total }
    val angles = proportions.map { it * 360f }

    Canvas(modifier = modifier) {
        var startAngle = 0f
        angles.forEachIndexed { index, angle ->
            drawArc(
                color = colors[index],
                startAngle = startAngle,
                sweepAngle = angle,
                useCenter = true
            )
            startAngle += angle
        }
    }
}

// Preview for PieChart
@Preview(showBackground = true)
@Composable
fun PreviewPieChart() {
    Text(text = "Pie Chart: Displays the emotions in the last seven days.", style = MaterialTheme.typography.bodyLarge)
    PieChart(
        colors = listOf(PastelRed,PastelGreen, PastelBlue), // Use custom colors
        inputValues = listOf(30f, 50f, 20f),
        modifier = Modifier.size(200.dp) // Ensure the size is set for the preview
    )
}