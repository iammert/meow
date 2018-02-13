import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by mertsimsek on 13/02/2018.
 */
class DynamicEndpointInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        return chain?.proceed(chain.request())!!
    }
}