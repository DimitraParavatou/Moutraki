import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.*

@Composable
fun CalendarScreen() {
    val today = LocalDate.now()
    val currentMonth = remember { mutableStateOf(today) }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF121212)), // Background color
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top Section (Month Selector)
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = {
                currentMonth.value = currentMonth.value.minusMonths(1)
            }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Previous Month", tint = Color.White)
            }

            Text(
                text = currentMonth.value.month.getDisplayName(TextStyle.FULL, Locale.getDefault()) + " " + currentMonth.value.year,
                color = Color.White,
                style = TextStyle(fontSize = 20.sp)
            )

            IconButton(onClick = {
                currentMonth.value = currentMonth.value.plusMonths(1)
            }) {
                Icon(Icons.Default.ArrowForward, contentDescription = "Next Month", tint = Color.White)
            }
        }

        // Calendar Grid
        CalendarGrid(currentMonth.value)
    }
}

@Composable
fun CalendarGrid(date: LocalDate) {
    val yearMonth = YearMonth.of(date.year, date.month)
    val firstDayOfMonth = yearMonth.atDay(1).dayOfWeek.value % 7
    val daysInMonth = yearMonth.lengthOfMonth()

    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Weekday Headers
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat").forEach { day ->
                Text(text = day, color = Color.Gray, fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Calendar Days
        val rows = (daysInMonth + firstDayOfMonth + 6) / 7
        for (row in 0 until rows) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (col in 0..6) {
                    val day = row * 7 + col - firstDayOfMonth + 1
                    if (day in 1..daysInMonth) {
                        val isToday = LocalDate.now().dayOfMonth == day && LocalDate.now().month == date.month
                        CalendarDay(day = day, isToday = isToday)
                    } else {
                        Spacer(modifier = Modifier.size(40.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun CalendarDay(day: Int, isToday: Boolean) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .background(
                if (isToday) Color(0xFF80C783) else Color(0xFF333333), // Highlight today
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = day.toString(),
            color = if (isToday) Color.Black else Color.White,
            fontSize = 14.sp
        )
    }
}
