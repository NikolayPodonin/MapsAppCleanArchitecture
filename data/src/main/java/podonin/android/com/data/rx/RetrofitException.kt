package podonin.android.com.data.rx

import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException
import java.lang.RuntimeException

class RetrofitException private constructor(
        mMessage: String?, mException: Throwable?, mUrl: String?,
        response: Response<*>?, mRetrofit: Retrofit?, val mKind: ExceptionKind
) : RuntimeException(mMessage, mException) {

    val mResponse: Response<*>? = response

    enum class ExceptionKind {
        NETWORK, HTTP, UNEXPECTED
    }

    companion object {
        @JvmStatic
        fun createNetworkException(ioException: IOException?): RetrofitException {
            return RetrofitException(ioException?.message, ioException, null, null, null, ExceptionKind.NETWORK)
        }
        @JvmStatic
        fun createHttpException(
                url: String?, response: Response<*>?, retrofit: Retrofit?
        ): RetrofitException {
            return RetrofitException(
                    "${response?.code()}, ${response?.message()}",
                    null, url, response, retrofit, ExceptionKind.NETWORK)
        }
        @JvmStatic
        fun createUnexpectedException(exception: Throwable?): RetrofitException {
            return RetrofitException(exception?.message, exception, null, null, null, ExceptionKind.NETWORK)
        }
    }
}