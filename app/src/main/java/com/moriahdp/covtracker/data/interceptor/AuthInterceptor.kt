package com.moriahdp.covtracker.data.interceptor

import com.moriahdp.covtracker.util.AppPreferences
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(
    private val appPreferences: AppPreferences
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val request = if (!AppPreferences.authToken.isNullOrEmpty() && AppPreferences.authToken != AppPreferences.AUTH_TOKEN_DEFAULT) {
            original.newBuilder().addHeader("Authorization", appPreferences.authToken!!).build()
        } else {
            original.newBuilder().build()
        }

        return chain.proceed(request)
    }
}