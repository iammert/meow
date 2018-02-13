package iammert.com.meowlib.interceptor

import android.content.Context
import iammert.com.meowlib.data.PreferencesHelper
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Created by mertsimsek on 13/02/2018.
 */
class DynamicEndpointInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response {
        val selectedRemoteSource = PreferencesHelper.getSelectedRemoteSource(context)
        var request: Request? = chain?.request()

        if (selectedRemoteSource != null && selectedRemoteSource.baseUrl != "") {
            val httpUrl: HttpUrl? = chain?.request()
                    ?.url()
                    ?.newBuilder()
                    ?.host(HttpUrl.parse(selectedRemoteSource.baseUrl)?.host()!!)
                    ?.build()
            if (httpUrl != null) {
                request = chain.request()
                        ?.newBuilder()
                        ?.url(httpUrl)
                        ?.build()
            }
        }
        return chain?.proceed(request)!!
    }
}