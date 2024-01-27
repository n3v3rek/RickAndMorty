package com.example.rickandmorty.components.views

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmorty.components.cards.CharacterCard
import com.example.rickandmorty.repository.dto.RickAndMortyData

@Composable
fun MyListView(rickAndMortyRecords: List<RickAndMortyData>, onClick: (String) -> Unit) {
    Log.d("MainActivity", "Size - ${rickAndMortyRecords.size}")

    if (rickAndMortyRecords.isNotEmpty()) {
        LazyColumn {
            items(rickAndMortyRecords) { record ->
                Log.d("MainActivity", "$record")
                CharacterCard(
                    record.id,
                    record.name,
                    record.status,
                    record.species,
                    record.gender,
                    record.image,
                    onClick = { id -> onClick.invoke(id)}
                )
            }
        }
    }
}