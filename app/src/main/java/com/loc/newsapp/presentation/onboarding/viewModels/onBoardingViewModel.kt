package com.loc.newsapp.presentation.onboarding.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.newsapp.preferences.useCases.Cases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class onBoardingViewModel @Inject constructor(
    private val appEntryCases : Cases
) : ViewModel() {

    fun onEvent(event : onBoardingEvents){
        when(event){
            is onBoardingEvents.savaAppEntry -> {
                saveAppEntry()
            }
        }
    }

    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryCases.saveAppEntry()
        }
    }
}