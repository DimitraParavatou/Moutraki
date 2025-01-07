package com.example.mootrakiapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Calendar() {
// Add code for Calendar
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = "My Calendar",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(20.dp))
    }
}