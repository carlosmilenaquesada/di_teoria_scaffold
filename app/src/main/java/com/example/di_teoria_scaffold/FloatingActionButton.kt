package com.example.di_teoria_scaffold

import android.R
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun FloatingActionButton01() {
    SmallFloatingActionButton(
        onClick = {},
        contentColor = Color.Red,
        containerColor = Color.Gray,
        shape = CircleShape
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = null,
            tint = Color.Red
        )
    }

}