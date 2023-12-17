package com.example.rickandmorty.components.views

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.rickandmorty.components.cards.CharacterCard
import com.example.rickandmorty.repository.RickAndMortyData

@Composable
fun MyListView(rickAndMortyRecords: List<RickAndMortyData>) {
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
                    record.image
                )
            }
        }
    }
}