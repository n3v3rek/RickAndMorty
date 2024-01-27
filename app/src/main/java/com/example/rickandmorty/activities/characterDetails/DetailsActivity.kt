package com.example.rickandmorty.activities.characterDetails

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.rickandmorty.components.views.MyErrorView
import com.example.rickandmorty.components.views.MyLoadingView
import com.example.rickandmorty.repository.UiState

class DetailsActivity : ComponentActivity() {
    private val viewModel: CharacterDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.getStringExtra("ACTIVITY_ID")

        if (id != null) {
            viewModel.getData(id)
        }

        setContent {
            ShowCharacterDetailsView(viewModel = viewModel)
        }
    }

    @Composable
    fun ShowCharacterDetailsView(viewModel: CharacterDetailsViewModel) {
        val uiState by viewModel.immutableCharacterDetailsData.observeAsState(UiState())

        when {
            uiState.isLoading -> { MyLoadingView() }
            uiState.error != null -> { uiState.error?.let { MyErrorView(error = it) } }
            uiState.data != null -> { uiState.data?.let { CharacterDetailsView(characterDetails = it) } }
        }
    }
}