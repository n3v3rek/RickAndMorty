package com.example.rickandmorty.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun CharacterCard(
    id: Int,
    name: String,
    status: String,
    species: String,
    gender: String,
    image: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(4.dp)
            .border(border = BorderStroke(1.dp, Color.DarkGray))
    ) {
        Row(
            modifier = modifier
                .padding(0.dp, 4.dp)
        ) {
            Column(
                modifier = modifier
                    .padding(4.dp, 0.dp)
            ) {
                AsyncImage(
                    model = image,
                    contentDescription = "Image from $image"
                )
            }
            Column(
                modifier = modifier
                    .padding(4.dp, 0.dp)
            ) {
                Column(
                    modifier = modifier
                        .padding(0.dp, 2.dp)
                ) {
                    Text(
                        text = "Character id: $id",
                        modifier = modifier,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp
                    )
                    Text(
                        text = "Name: $name",
                        modifier = modifier,
                        fontSize = 12.sp
                    )
                    Text(
                        text = "Species: $species",
                        modifier = modifier,
                        fontSize = 8.sp,
                        color = Color.DarkGray
                    )
                    Text(
                        text = "Gender: $gender",
                        modifier = modifier,
                        fontSize = 8.sp,
                        color = Color.DarkGray
                    )
                    Text(
                        text = "Status: $status",
                        modifier = modifier,
                        fontSize = 8.sp,
                        color = Color.DarkGray
                    )
                }
            }
        }
    }
}