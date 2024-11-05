package org.sopt.and.presentation.ui.my

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.sopt.and.domain.usecase.GetUserHobbyUseCase
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val getUserHobbyUseCase: GetUserHobbyUseCase
) : ViewModel() {
    private val _userHobby = MutableStateFlow<String>("")
    val userHobby: StateFlow<String> = _userHobby

    init {
        getUserHobby()
    }

    private fun getUserHobby() {
        viewModelScope.launch {
            getUserHobbyUseCase().onSuccess { data ->
                _userHobby.value = data.hobby
            }
        }
    }
}