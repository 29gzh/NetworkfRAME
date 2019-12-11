package com.heng.common_base.http

import com.heng.common_base.BuildConfig
import com.heng.common_base.constant.RetrofitConstant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit


/**
 * @author ziheng
 * @date   2019/12/9.
 * @function    请求网络
 */
object RetrofitHelper {

    private var retrofit: Retrofit? = null

//    val service: ApiService by lazy {  }


    private fun getRetrofit(): Retrofit?{
        if(retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(RetrofitConstant.BASE_URL)
                .client(getOkHttlClient())
                .build()
        }
        return retrofit
    }

    private fun getOkHttlClient():OkHttpClient{

        val builder = OkHttpClient().newBuilder()
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        builder.run {
            addInterceptor(httpLoggingInterceptor)
            addInterceptor(SaveCookieInterceptor())
        }

        return builder.build()

    }

    class SaveCookieInterceptor: Interceptor{
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            val requestUrl = request.url().toString()
            val response = chain.proceed(request)
            val domain = request.url().host()
            if(requestUrl.contains(RetrofitConstant.SAVE_USER_LOGIN_KEY) || requestUrl.contains(RetrofitConstant.SAVE_USER_REGISTER_KEY)
                && response.headers(RetrofitConstant.SET_COOKIE_KEY).isEmpty()){
                val cookies = response.headers(RetrofitConstant.SET_COOKIE_KEY)
                val cookie = RetrofitConstant.encodeCookie(cookies)
                RetrofitConstant.saveCookie(cookie,domain)
            }
        return response
        }
    }

}