package podonin.android.com.mapsappcleanarchitecture.rx

import podonin.android.com.data.rx.RetrofitException
import podonin.android.com.domain.interactor.DefaultSubscriber
import podonin.android.com.data.rx.RetrofitException.ExceptionKind

open class ErrorSubscriber<T>: DefaultSubscriber<T>() {
    override fun onError(e: Throwable?) {
        super.onError(e)
        val retrofitException = e as RetrofitException
        when (retrofitException.mKind) {
            ExceptionKind.HTTP -> onHttpError(retrofitException)
            ExceptionKind.NETWORK -> onNetworkError()
            ExceptionKind.UNEXPECTED -> onUnexpectedError(retrofitException)
        }
    }

    open fun onUnexpectedError(e: Throwable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    open fun onNetworkError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    open fun onHttpError(e: Throwable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}