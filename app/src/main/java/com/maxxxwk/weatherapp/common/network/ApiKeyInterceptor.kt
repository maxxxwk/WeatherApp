package com.maxxxwk.weatherapp.common.network

import com.maxxxwk.weatherapp.BuildConfig
import javax.inject.Inject
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url
        return chain.proceed(
            request.newBuilder()
                .url(
                    url.newBuilder()
                        .addQueryParameter("appid", BuildConfig.API_KEY)
                        .build()
                ).build()
        )
    }
}
