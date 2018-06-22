package podonin.android.com.data.rx

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import rx.Observable
import java.lang.reflect.Type

class RxErrorHandlingCallAdapterFactory : CallAdapter.Factory() {

    private val mOriginal: RxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create()

    override fun get(returnType: Type?, annotations: Array<out Annotation>?, retrofit: Retrofit?): CallAdapter<*, *>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        @JvmStatic
        fun create() : CallAdapter.Factory {
            return RxErrorHandlingCallAdapterFactory()
        }
    }

    class RxCallAdapterWrapper: CallAdapter<Observable<*>, Observable<*>> {
        override fun adapt(call: Call<Observable<*>>?): Observable<*> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun responseType(): Type {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}