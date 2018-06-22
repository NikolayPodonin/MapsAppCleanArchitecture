package podonin.android.com.domain.interactor.placeinteractor;

import android.support.annotation.NonNull;

import podonin.android.com.domain.interactor.UseCase;
import podonin.android.com.domain.model.PlacesSearchResultData;
import podonin.android.com.domain.repository.PlacesRepository;
import rx.Observable;
import rx.Scheduler;

public class PlacesNextPageUseCase extends UseCase<PlacesSearchResultData, PlacesNextPageUseCase.Params> {
    private PlacesRepository mRepository;

    public PlacesNextPageUseCase(PlacesRepository repository, Scheduler executionThread, Scheduler postExecutionThread) {
        super(executionThread, postExecutionThread);
        mRepository = repository;
    }

    @Override
    protected Observable<PlacesSearchResultData> buildUseCaseObservable(Params params) {
        return mRepository.getNextPagePlacesResult(params.mPageToken, params.mKey);
    }

    public static class Params {
        final String mPageToken;
        final String mKey;

        public Params(@NonNull String pageToken, @NonNull String key) {
            mKey = key;
            mPageToken = pageToken;
        }
    }
}
