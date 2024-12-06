package org.sopt.and.presentation.ui.my

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import org.sopt.and.domain.usecase.PatchUserHobbyUseCase
import org.sopt.and.presentation.ui.my.state.MyUiState
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val patchUserHobbyUseCase: PatchUserHobbyUseCase
) : ViewModel() {
    val myUiState: StateFlow<MyUiState> =
        flow<MyUiState> {
            runCatching {
                patchUserHobbyUseCase()
            }.onSuccess { data ->
                emit(MyUiState.Success(data.hobby))
            }.onFailure { throwable ->
                emit(MyUiState.Error(throwable.message))
            }
        }.catch { throwable ->
            emit(MyUiState.Error(throwable.message))
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = MyUiState.Loading
        )
}