package com.mbds.newsletter.repositories

import com.mbds.newsletter.model.ListArticlesResponse
import com.mbds.newsletter.services.ArticleService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Articlepository {
    private val service: ArticleService
    init {

        // Add API KEY to Authorization
        val clientBulider = OkHttpClient.Builder()
            .addInterceptor(AuthenticationInterceptor())

        // Enable Logger
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        clientBulider.addInterceptor(interceptor)


        //Build Client
        val client = clientBulider.build()

        val retrofit = Retrofit.Builder().apply {
            baseUrl("https://newsapi.org/v2/")
            client(client)
            addConverterFactory(GsonConverterFactory.create())
        }.build()

    service = retrofit.create(ArticleService::class.java)
}

class AuthenticationInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val headers = request
            .headers()
            .newBuilder()
            .add("Authorization", "Bearer 91a74b33e53d4850a4c72de214f81173")
            .build()

        request = request
            .newBuilder()
            .headers(headers)
            .build()
        return chain.proceed(request)
    }

}

    fun list(sujet : String): ListArticlesResponse? {
            val response = service.list(q = sujet).execute()
        return response.body() ?: null
    }
}