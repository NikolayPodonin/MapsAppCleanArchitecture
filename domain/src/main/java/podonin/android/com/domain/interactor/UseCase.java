package podonin.android.com.domain.interactor;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public abstract class UseCase<T, Params> {
    private Scheduler mExecutionThread;
    private Scheduler mPostExecutionThread;

    private Subscription mSubscription = Subscriptions.empty();

    public UseCase(Scheduler executionThread, Scheduler postExecutionThread) {
        mExecutionThread = executionThread;
        mPostExecutionThread = postExecutionThread;
    }

    protected abstract Observable<T> buildUseCaseObservable(Params params);


    public void execute(Subscriber<T> useCaseSubscriber, Params params) {
        mSubscription = buildUseCaseObservable(params)
                .subscribeOn(mExecutionThread)
                .observeOn(mPostExecutionThread)
                .subscribe(useCaseSubscriber);
    }

    public void unsubscribe() {
        if (!mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }
}
