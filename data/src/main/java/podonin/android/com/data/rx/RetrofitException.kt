package podonin.android.com.data.rx

import retrofit2.Response
import retrofit2.Retrofit
import java.lang.RuntimeException

class RetrofitException private constructor(
        mMessage: String?, mException: Throwable?, mUrl: String?,
        mResponse: Response<*>?, mRetrofit: Retrofit?, val mKind: ExceptionKind
) : RuntimeException(mMessage, mException) {

    private enum class ExceptionKind {
        NETWORK, HTTP, UNEXPECTED
    }

    companion object {
        @JvmStatic
        fun createNetworkException(
                message: String?, exception: Throwable?, url: String?,
                response: Response<*>?, retrofit: Retrofit?
        ): RetrofitException {
            return RetrofitException(message, exception, url, response, retrofit, ExceptionKind.NETWORK)
        }
        @JvmStatic
        fun createHttpException(
                message: String?, exception: Throwable?, url: String?,
                response: Response<*>?, retrofit: Retrofit?
        ): RetrofitException {
            return RetrofitException(message, exception, url, response, retrofit, ExceptionKind.HTTP)
        }
        @JvmStatic
        fun createUnexpectedException(
                message: String?, exception: Throwable?, url: String?,
                response: Response<*>?, retrofit: Retrofit?
        ): RetrofitException {
            return RetrofitException(message, exception, url, response, retrofit, ExceptionKind.UNEXPECTED)
        }
    }
}