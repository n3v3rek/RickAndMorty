package com.example.rickandmorty.activities.characterDetails

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.rickandmorty.repository.dto.CharacterDetails

@Composable
fun CharacterDetailsView(characterDetails: CharacterDetails) {
    Log.d("CharacterDetails", "Character details - $characterDetails.")

    Column{
        Column(modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Character details",
                fontSize = 24.sp
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .border(border = BorderStroke(1.dp, Color.DarkGray))
            ) {
                AsyncImage(
                    model = characterDetails.image,
                    contentDescription = "Image from ${characterDetails.image}"
                )
            }
        }
        Column(
            modifier = Modifier
            .padding(4.dp)
            ) {
            Text(
                text = "Name: ${characterDetails.name}",
                fontSize = 12.sp
            )
            Text(
                text = "Character ID: ${characterDetails.id}",
                fontSize = 12.sp
            )
            Text(
                text = "Status: ${characterDetails.status}",
                fontSize = 12.sp
            )
            Text(
                text = "Species: ${characterDetails.species}",
                fontSize = 12.sp
            )
            Text(
                text = "Type: ${characterDetails.type}",
                fontSize = 12.sp
            )
            Text(
                text = "Gender: ${characterDetails.gender}",
                fontSize = 12.sp
            )
            Text(
                text = "Origin: ${characterDetails.origin.name}",
                fontSize = 12.sp
            )
            Text(
                text = "Location: ${characterDetails.location.name}",
                fontSize = 12.sp
            )
            Text(
                text = "Number of appearances in episodes: ${characterDetails.episode.size}",
                fontSize = 12.sp
            )
        }
    }
}