package org.sopt.and

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import org.sopt.and.util.WaveDebugTree
import timber.log.Timber

@HiltAndroidApp
class WaveApp : Application() {
    override fun onCreate() {
        super.onCreate()

        setTimber()
    }

    private fun setTimber() {
        if (BuildConfig.DEBUG) Timber.plant(WaveDebugTree())
    }
}