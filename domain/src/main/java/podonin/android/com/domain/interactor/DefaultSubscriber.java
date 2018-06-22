package podonin.android.com.domain.interactor;

import rx.Subscriber;

public abstract class DefaultSubscriber<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {
        //No default implementation
    }

    @Override
    public void onError(Throwable e) {
        //No default implementation
    }

    @Override
    public void onNext(T t) {
        //No default implementation
    }
}
