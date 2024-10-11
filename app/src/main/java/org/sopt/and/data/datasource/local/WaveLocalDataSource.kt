package org.sopt.and.data.datasource.local

import android.content.SharedPreferences

interface WaveLocalDataSource {
    val sharedPreferences: SharedPreferences
    var isLogin: Boolean
    var userEmail: String
    var userPassword: String
}