package org.sopt.and.data.datasourceImpl.local

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import org.sopt.and.data.datasource.local.WaveLocalDataSource
import javax.inject.Inject

class WaveLocalDataSourceImpl @Inject constructor(
    @ApplicationContext context: Context
) : WaveLocalDataSource {

    private val pref: SharedPreferences =
        context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)

    override var isLogin: Boolean
        get() = pref.getBoolean(AUTO_LOGIN, false)
        set(value) = pref.edit { putBoolean(AUTO_LOGIN, value) }

    override var userEmail: String
        get() = pref.getString(USER_EMAIL, "") ?: ""
        set(value) = pref.edit { putString(USER_EMAIL, value) }

    override var userPassword: String
        get() = pref.getString(USER_PASSWORD, "") ?: ""
        set(value) = pref.edit { putString(USER_PASSWORD, value) }

    companion object {
        const val FILE_NAME = "AuthSharedPreferences"
        const val AUTO_LOGIN = "AutoLogin"
        const val USER_EMAIL = "UserEmail"
        const val USER_PASSWORD = "UserPassword"
    }
}