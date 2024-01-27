package com.example.rickandmorty

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.repository.UiState
import com.example.rickandmorty.repository.dto.RickAndMortyData
import com.example.rickandmorty.repository.RickAndMortyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val rickAndMortyRepository = RickAndMortyRepository();
    private val mutableRickAndMortyData = MutableLiveData<UiState<List<RickAndMortyData>>>()
    val immutableRickAndMortyData: LiveData<UiState<List<RickAndMortyData>>> = mutableRickAndMortyData

    fun getData() {
        mutableRickAndMortyData.postValue(UiState(isLoading = true))
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val request = rickAndMortyRepository.getRickAndMortyResponse()
                if (request.isSuccessful){
                    val characters = request.body()?.results
                    mutableRickAndMortyData.postValue(UiState(data = characters))
                } else {
                    mutableRickAndMortyData.postValue(UiState(error = "${request.code()}"))
                    Log.e("MainViewModel", "Request failed ${request.errorBody()}.")
                }
            } catch (e: Exception) {
                Log.e("MainViewModel", "Exception occurred, while trying o fetch data.", e)
                mutableRickAndMortyData.postValue(UiState(error = "Exception occurred, while trying o fetch data."))
            }
        }
    }
}