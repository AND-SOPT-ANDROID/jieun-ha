package org.sopt.and.presentation.ui.auth

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.and.data.datasource.local.WaveLocalDataSource
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val localDataSource: WaveLocalDataSource
) : ViewModel() {

    fun checkIsUserEmail(email: String): Boolean = (email == localDataSource.userEmail)

    fun checkIsUserPassword(password: String): Boolean = (password == localDataSource.userPassword)
}