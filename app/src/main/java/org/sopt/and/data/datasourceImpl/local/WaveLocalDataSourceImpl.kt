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

    override var accessToken: String
        get() = pref.getString(ACCESS_TOKEN, "") ?: ""
        set(value) = pref.edit { putString(ACCESS_TOKEN, value) }

    companion object {
        const val FILE_NAME = "AuthSharedPreferences"
        const val AUTO_LOGIN = "AutoLogin"
        const val ACCESS_TOKEN = "AccessToken"
    }
}