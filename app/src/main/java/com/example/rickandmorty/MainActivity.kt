package com.example.rickandmorty

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.rickandmorty.repository.UiState
import com.example.rickandmorty.components.views.MyErrorView
import com.example.rickandmorty.components.views.MyListView
import com.example.rickandmorty.components.views.MyLoadingView
import com.example.rickandmorty.activities.characterDetails.DetailsActivity

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getData()
        setContent {
            ShowMainView(
                viewModel = viewModel,
                onClick = { id -> navigateToModalActivity(id)}
            )
        }
    }

    private fun navigateToModalActivity(id: String) {
        val detailsIntent = Intent(this, DetailsActivity::class.java)
        detailsIntent.putExtra("ACTIVITY_ID", id)
        startActivity(detailsIntent)
    }

    @Composable
    fun ShowMainView(viewModel: MainViewModel, onClick: (String) -> Unit) {
        val uiState by viewModel.immutableRickAndMortyData.observeAsState(UiState())

        when {
            uiState.isLoading -> { MyLoadingView() }
            uiState.error != null -> { uiState.error?.let { MyErrorView(error = it) } }
            uiState.data != null -> { uiState.data?.let { MyListView(
                rickAndMortyRecords = it,
                onClick = { id -> onClick.invoke(id)}
            ) } }
        }
    }
}