package org.sopt.and.data.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.sopt.and.data.datasource.local.WaveLocalDataSource
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val localStorage: WaveLocalDataSource
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val authRequest =
            if (localStorage.isLogin) originalRequest.newAuthBuilder() else originalRequest
        return chain.proceed(authRequest)
    }

    private fun Request.newAuthBuilder() =
        this.newBuilder().addHeader(AUTHORIZATION, localStorage.accessToken).build()

    companion object {
        const val AUTHORIZATION = "token"
    }
}