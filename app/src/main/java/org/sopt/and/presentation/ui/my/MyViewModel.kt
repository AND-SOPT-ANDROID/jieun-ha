package org.sopt.and.presentation.ui.my

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.and.data.datasource.local.WaveLocalDataSource
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val localDataSource: WaveLocalDataSource
) : ViewModel() {
    fun getLocalUserMail(): String {
        return localDataSource.userEmail
    }
}