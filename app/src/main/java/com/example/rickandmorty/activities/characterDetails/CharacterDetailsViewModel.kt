package com.example.rickandmorty.activities.characterDetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.repository.RickAndMortyRepository
import com.example.rickandmorty.repository.UiState
import com.example.rickandmorty.repository.dto.CharacterDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterDetailsViewModel : ViewModel() {
    private val rickAndMortyRepository = RickAndMortyRepository();
    private val mutableCharacterDetailsData = MutableLiveData<UiState<CharacterDetails>>()
    val immutableCharacterDetailsData: LiveData<UiState<CharacterDetails>> = mutableCharacterDetailsData

    fun getData(id: String) {
        mutableCharacterDetailsData.postValue(UiState(isLoading = true))
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val request = rickAndMortyRepository.getCharacterDetails(id)
                if (request.isSuccessful){
                    val characterDetails = request.body()
                    mutableCharacterDetailsData.postValue(UiState(data = characterDetails))
                } else {
                    mutableCharacterDetailsData.postValue(UiState(error = "${request.code()}"))
                    Log.e("MainViewModel", "Request failed ${request.errorBody()}.")
                }
            } catch (e: Exception) {
                Log.e("MainViewModel", "Exception occurred, while trying o fetch data.", e)
                mutableCharacterDetailsData.postValue(UiState(error = "Exception occurred, while trying o fetch data."))
            }
        }
    }
}