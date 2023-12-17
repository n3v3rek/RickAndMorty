package com.example.rickandmorty.components.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun MyLoadingView(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
    ) {
        CircularProgressIndicator(
            color = Color.Black,
            modifier = modifier
        )
        Text(
            text = "Loading...",
            modifier = modifier,
            fontSize = 20.sp
        )
    }
}