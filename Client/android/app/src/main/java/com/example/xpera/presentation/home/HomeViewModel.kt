package com.example.xpera.presentation.home

import androidx.lifecycle.ViewModel
import com.example.xpera.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: AuthRepository
) :ViewModel() {
    val currentUser get() =repository.currentUser

}