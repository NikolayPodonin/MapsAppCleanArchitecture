package podonin.android.com.domain.interactor.placeinteractor;

import podonin.android.com.domain.interactor.UseCase;
import podonin.android.com.domain.model.PlacesSearchResultData;
import podonin.android.com.domain.repository.PlacesRepository;
import rx.Observable;
import rx.Scheduler;

public class PlacesUseCase extends UseCase<PlacesSearchResultData, PlacesUseCase.Params> {
    private PlacesRepository mRepository;

    public PlacesUseCase(PlacesRepository repository, Scheduler executionThread, Scheduler postExecutionThread) {
        super(executionThread, postExecutionThread);
        mRepository = repository;
    }

    @Override
    protected Observable<PlacesSearchResultData> buildUseCaseObservable(Params params) {
        return mRepository.getPlacesResult(params.mLat, params.mLon, params.mRadius, params.mPlaceType, params.mKey);
    }

    public static class Params {
        final String mPlaceType;
        final double mLat;
        final double mLon;
        final int mRadius;
        final String mKey;

        public Params(double lat, double lon, int radius, String placeType, String key) {
            mLat = lat;
            mLon = lon;
            mRadius = radius;
            mKey = key;
            mPlaceType = placeType;
        }
    }
}
