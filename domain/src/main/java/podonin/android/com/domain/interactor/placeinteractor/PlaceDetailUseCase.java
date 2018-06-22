package podonin.android.com.domain.interactor.placeinteractor;

import android.support.annotation.NonNull;

import java.util.List;

import podonin.android.com.domain.interactor.UseCase;
import podonin.android.com.domain.model.PlaceDetailsResultData;
import podonin.android.com.domain.repository.PlacesRepository;
import rx.Observable;
import rx.Scheduler;

public class PlaceDetailUseCase extends UseCase<PlaceDetailsResultData, PlaceDetailUseCase.Params> {
    private PlacesRepository mRepository;

    public PlaceDetailUseCase(PlacesRepository repository, Scheduler executionThread, Scheduler postExecutionThread) {
        super(executionThread, postExecutionThread);
        mRepository = repository;
    }

    @Override
    protected Observable<PlaceDetailsResultData> buildUseCaseObservable(PlaceDetailUseCase.Params params) {
        return mRepository.getPlaceDetailResult(params.mPlaceId, params.mKey);
    }

    public static class Params {
        final List<String> mPlaceId;
        final String mKey;

        public Params(@NonNull List<String> placeId, @NonNull String key) {
            mKey = key;
            mPlaceId = placeId;
        }
    }
}
