package org.sopt.and.presentation.ui.my.state

sealed interface MyUiState {
    data class Success(val hobby: String) : MyUiState
    data object Loading : MyUiState
    data class Error(val message: String?) : MyUiState
}