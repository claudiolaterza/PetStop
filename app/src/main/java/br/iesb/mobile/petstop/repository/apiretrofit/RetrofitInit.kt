package br.iesb.mobile.petstop.repository.apiretrofit

import android.content.Context
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class RetrofitInit(context: Context, baseUrl: String) {
    val retrofit: Retrofit

    init {
        val interceptorParaLog = HttpLoggingInterceptor()
        interceptorParaLog.level = HttpLoggingInterceptor.Level.BODY

        retrofit = Retrofit.Builder()
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(interceptorParaLog)
                    .build()
            )
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }
}