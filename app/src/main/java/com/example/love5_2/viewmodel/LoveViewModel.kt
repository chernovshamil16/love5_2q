package com.example.love5_2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.love5_2.model.LoveModel
import com.example.love5_2.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository) :ViewModel() {

    fun getLiveLoveViewModel(
        firstName: String,
        secondName: String
    ): LiveData<LoveModel> {
        return repository.getMutableLiveDataOfLoveData(firstName, secondName)
    }

    fun getWeatherFromRoom (): LiveData<List<LoveModel>> {

        return repository.getWeatherRoom()
    }
}