import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun DayDetailScreen() {
    var selectedMood by remember { mutableStateOf(-1) }
    var noteText by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(16.dp)
    ) {
        // Header with date and settings
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Saturday, December 21",
                color = Color.White,
                fontSize = 20.sp
            )
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Settings",
                tint = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Mood selection
        Text(
            text = "How was your day?",
            color = Color.White,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            listOf("😀", "😊", "😐", "☹️", "😢").forEachIndexed { index, emoji ->
                MoodOption(
                    emoji = emoji,
                    isSelected = selectedMood == index,
                    onClick = { selectedMood = index }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Emotions list
        Text(
            text = "Emotions",
            color = Color.Gray,
            fontSize = 16.sp,
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyVerticalGrid(
            cells = GridCells.Fixed(4),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(listOf("Excited", "Relaxed", "Happy", "Tired", "Annoyed", "Stressed", "Bored", "Hopeful")) { emotion ->
                EmotionOption(emotion = emotion)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Today's Note
        Text(
            text = "Today's note",
            color = Color.White,
            fontSize = 18.sp
        )
        BasicTextField(
            value = noteText,
            onValueChange = { noteText = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xFF2C2C2C), shape = MaterialTheme.shapes.small)
                .padding(8.dp),
            textStyle = TextStyle(color = Color.White, fontSize = 16.sp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Photo Selection
        Text(
            text = "Today's photo",
            color = Color.White,
            fontSize = 18.sp
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color(0xFF2C2C2C), shape = MaterialTheme.shapes.small),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Select up to 3 photos",
                color = Color.Gray,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Done button
        Button(
            onClick = { /* Handle action */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF4CAF50))
        ) {
            Text(
                text = "Done",
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun MoodOption(emoji: String, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(if (isSelected) Color(0xFF80C783) else Color(0xFF2C2C2C))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(text = emoji, fontSize = 20.sp)
    }
}

@Composable
fun EmotionOption(emotion: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Color(0xFF2C2C2C)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = emotion.take(1), fontSize = 18.sp, color = Color.Gray) // Placeholder
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = emotion, fontSize = 12.sp, color = Color.Gray)
    }
}
