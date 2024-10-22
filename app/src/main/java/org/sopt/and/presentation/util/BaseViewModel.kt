package org.sopt.and.presentation.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<Event : UiEvent, State : UiState, Effect : UiEffect> : ViewModel() {
    private val initialState: State by lazy { createInitialState() }
    abstract fun createInitialState(): State

    private val _uiState: MutableStateFlow<State> = MutableStateFlow(initialState)
    val currentUiState: State get() = _uiState.value
    val uiState = _uiState.asStateFlow()

    private val _uiEvent: MutableSharedFlow<Event> = MutableSharedFlow()
    val uiEvent: SharedFlow<Event> get() = _uiEvent.asSharedFlow()

    private val _uiEffect: Channel<Effect> = Channel()
    val uiEffect = _uiEffect.receiveAsFlow()

    init {
        subscribeToEvents()
    }

    protected fun setState(state: State) {
        _uiState.value = state
    }

    fun setEvent(event: Event) {
        viewModelScope.launch { _uiEvent.emit(event) }
    }

    fun setEffect(effect: Effect) {
        viewModelScope.launch { _uiEffect.send(effect) }
    }

    private fun subscribeToEvents() {
        viewModelScope.launch { uiEvent.collect { event -> handleEvent(event) } }
    }

    protected abstract suspend fun handleEvent(event: Event)
    protected abstract fun handleEffect(effect: Effect)
}