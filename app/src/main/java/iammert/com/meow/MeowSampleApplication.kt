package iammert.com.meow

import android.app.Application
import iammert.com.meowlib.Meow
import iammert.com.meowlib.interceptor.DynamicEndpointInterceptor
import iammert.com.meowlib.model.MeowConfig
import iammert.com.meowlib.model.RemoteSource
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by mertsimsek on 23/01/2018.
 */
class MeowSampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Meow.install(this, getConfig())
    }

    fun getConfig(): MeowConfig{
        val remote1 = RemoteSource(1, "101", "http://demo3711327.mockable.io/", false)
        val remote2 = RemoteSource(2, "102", "http://demo9530202.mockable.io/", true)
        val remoteList: MutableList<RemoteSource> = mutableListOf(remote1, remote2)
        return MeowConfig(remoteList)
    }

    fun getRetrofit(): RetrofitInterface {
        val okhttpBuilder = OkHttpClient.Builder();
        okhttpBuilder.interceptors()
                .add(DynamicEndpointInterceptor(this))
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("http://demo3711327.mockable.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpBuilder.build())
                .build()
        return retrofit.create(RetrofitInterface::class.java)
    }

    interface RetrofitInterface {
        @GET("users")
        fun getUsers(): Call<List<String>>
    }
}