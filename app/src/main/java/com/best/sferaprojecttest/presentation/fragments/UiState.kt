package com.best.sferaprojecttest.presentation.fragments

sealed class UiState {
    object ShowLoading : UiState()
    object HideLoading : UiState()
    data class ShowError(val message: String) : UiState()
}