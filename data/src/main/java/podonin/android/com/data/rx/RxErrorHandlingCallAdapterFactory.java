package podonin.android.com.data.rx;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.functions.Func1;

public class RxErrorHandlingCallAdapterFactory extends CallAdapter.Factory {
    private final RxJavaCallAdapterFactory original;

    private RxErrorHandlingCallAdapterFactory(){
        original = RxJavaCallAdapterFactory.create();
    }

    @Nullable
    @Override
    public CallAdapter<?, ?> get(@NonNull Type returnType, @NonNull Annotation[] annotations, @NonNull Retrofit retrofit) {
        return new RxCallAdapterWrapper(retrofit, original.get(returnType, annotations, retrofit));
    }

    public static CallAdapter.Factory create() {
        return new RxErrorHandlingCallAdapterFactory();
    }

    private static class RxCallAdapterWrapper
            implements CallAdapter<Observable<?>, Observable<?>> {

        Retrofit mRetrofit;
        CallAdapter<?,?> mWrapped;

        public RxCallAdapterWrapper(Retrofit retrofit, CallAdapter<?, ?> wrapped) {
            mRetrofit = retrofit;
            mWrapped = wrapped;
        }

        @Override
        public Type responseType() {
            return mWrapped.responseType();
        }

        @SuppressWarnings("unchecked")
        @Override
        public Observable adapt(Call call) {
            return ((Observable)mWrapped.adapt(call)).onErrorResumeNext(new Func1<Throwable, Observable>() {
                @Override
                public Observable call(Throwable throwable) {
                    return Observable.error(asRetrofitException(throwable));
                }
            });
        }

        private RetrofitException asRetrofitException(Throwable throwable) {
            if (throwable instanceof HttpException) {
                HttpException exception = (HttpException) throwable;
                Response response = exception.response();
                return RetrofitException.createHttpException(
                        response.raw().request().url().toString(), response, mRetrofit);
            } else if (throwable instanceof IOException) {
                return RetrofitException.createNetworkException((IOException) throwable);
            } else {
                return RetrofitException.createUnexpectedException(throwable);
            }
        }
    }
}
