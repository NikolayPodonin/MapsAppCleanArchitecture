package podonin.android.com.mapsappcleanarchitecture.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import podonin.android.com.data.repository.RepositoryProvider;
import podonin.android.com.domain.interactor.placeinteractor.PlaceDetailUseCase;
import podonin.android.com.domain.interactor.placeinteractor.PlacesNextPageUseCase;
import podonin.android.com.domain.interactor.placeinteractor.PlacesUseCase;
import podonin.android.com.domain.interactor.UseCase;
import podonin.android.com.domain.model.PlaceData;
import podonin.android.com.domain.model.PlaceDetailsResultData;
import podonin.android.com.domain.model.PlacesSearchResultData;
import podonin.android.com.mapsappcleanarchitecture.model.PlaceClusterItem;
import podonin.android.com.mapsappcleanarchitecture.view.MapsView;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.text.TextUtils.isEmpty;

public class MapsPresenter {
    private MapsView mMapsView;
    private UseCase<PlacesSearchResultData, PlacesUseCase.Params> mSearchUseCase;
    private UseCase<PlaceDetailsResultData, PlaceDetailUseCase.Params> mDetailsUseCase;
    private UseCase<PlacesSearchResultData, PlacesNextPageUseCase.Params> mNextPageUseCase;
    private List<PlaceData> mPlacesDataList = new ArrayList<>();
    private String mApiKey;

    public MapsPresenter(@NonNull MapsView mapsView, @NonNull String apiKey) {
        mMapsView = mapsView;
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Scheduler backThread = Schedulers.newThread();
        mSearchUseCase = new PlacesUseCase(RepositoryProvider.providePlacesRepository(), backThread, mainThread);
        mNextPageUseCase = new PlacesNextPageUseCase(RepositoryProvider.providePlacesRepository(), backThread, mainThread);
        mDetailsUseCase = new PlaceDetailUseCase(RepositoryProvider.providePlacesRepository(), backThread, mainThread);
        mApiKey = apiKey;
    }

    public void mapIsReady() {
        mMapsView.requestLocation();
        mMapsView.setUpClusterer();
    }

    private void onNeedPlaces(double lat, double lon, int radius, @NonNull String placeType) {
        mPlacesDataList.clear();
        mSearchUseCase.execute(new PlacesSubscriber(), new PlacesUseCase.Params(lat, lon, radius, placeType, mApiKey));
    }

    private void checkIfHaveNextPage(String pageToken) {
        if (!isEmpty(pageToken)) {
            mNextPageUseCase.execute(new PlacesSubscriber(), new PlacesNextPageUseCase.Params(pageToken, mApiKey));
        } else {
            onPlacesDataIsReady(mPlacesDataList);
        }
    }

    public void onNeedDetails(@NonNull List<PlaceData> placeDataList) {
        List<String> placeIds = new ArrayList<>();
        for (PlaceData data : placeDataList) {
            placeIds.add(data.getPlaceId());
        }
        mDetailsUseCase.execute(new PlaceDetailsSubscriber(), new PlaceDetailUseCase.Params(placeIds, mApiKey));
    }

    public void onNeedRequestPermission() {
        mMapsView.requestPermission();
    }

    public void onPermissionRequestResult(boolean isGranted) {
        if (isGranted) {
            mMapsView.requestLocation();
        } else {
            //TODO
        }
    }

    public void onLocationProvided(double lat, double lon) {
        mMapsView.setCentralMarker(lat, lon, "You");
        mMapsView.onChanges();
    }

    public void onLocationNotProvided() {
        //TODO
        mMapsView.setCentralMarker(60.019131, 30.402735, "MUGEN");
        mMapsView.onChanges();
    }

    public void onDestroy() {
        mDetailsUseCase.unsubscribe();
        mSearchUseCase.unsubscribe();
        mNextPageUseCase.unsubscribe();
    }

    private void onPlacesDataIsReady(List<PlaceData> placeDataList) {
        ArrayList<PlaceClusterItem> items = new ArrayList<>();
        for (PlaceData place : placeDataList) {
            items.add(new PlaceClusterItem(place));
        }
        mMapsView.showClusterItems(items);
    }

    private void onDetailDataIsReady(List<PlaceData> placeDataList) {
        mMapsView.showBottomSheetWithData(placeDataList);
    }

    public void onChoosePlaceType(String type) {
        mMapsView.setPlaceType(type);
        mMapsView.onChanges();
    }

    public void onViewStateChange(double lat, double lon, int radius, @NonNull String placeType) {
        onNeedPlaces(lat, lon, radius, placeType);
    }

    public void onChangeRadius() {
        mMapsView.onChanges();
    }

    private class PlacesSubscriber extends Subscriber<PlacesSearchResultData> {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            //TODO
        }

        @Override
        public void onNext(PlacesSearchResultData placesSearchResultData) {
            Log.i("NEVERNEVERLATYOUGO", placesSearchResultData.getStatus());
            mPlacesDataList.addAll(placesSearchResultData.getResults());
            for (PlaceData data : placesSearchResultData.getResults()) {
                for (String type:data.getTypes()) {
                    Log.i("TYPE", type);
                }
            }
            checkIfHaveNextPage(placesSearchResultData.getNextPageToken());
        }
    }

    private class PlaceDetailsSubscriber extends Subscriber<PlaceDetailsResultData> {
        private List<PlaceData> mPlaceData = new ArrayList<>();

        @Override
        public void onCompleted() {
            onDetailDataIsReady(mPlaceData);
        }

        @Override
        public void onError(Throwable e) {
            //TODO
        }

        @Override
        public void onNext(PlaceDetailsResultData placeDetailsResultData) {
            mPlaceData.add(placeDetailsResultData.getResult());
        }
    }
}
