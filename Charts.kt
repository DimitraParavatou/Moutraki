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
fun Charts() {
// Add code for Charts
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = "My Charts",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(20.dp))
    }
}