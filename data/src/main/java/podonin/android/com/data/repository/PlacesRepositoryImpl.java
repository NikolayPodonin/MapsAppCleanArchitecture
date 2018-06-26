package podonin.android.com.data.repository;

import android.support.annotation.NonNull;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import podonin.android.com.data.api.GetNearbyPlacesRequest;
import podonin.android.com.data.api.GetNextPageRequest;
import podonin.android.com.data.api.GetPlaceDetailsRequest;
import podonin.android.com.data.mapper.EntityMapper;
import podonin.android.com.data.rx.RxErrorHandlingCallAdapterFactory;
import podonin.android.com.domain.model.PlaceDetailsResultData;
import podonin.android.com.domain.model.PlacesSearchResultData;
import podonin.android.com.domain.repository.PlacesRepository;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class PlacesRepositoryImpl implements PlacesRepository {
    private static final String mBaseUrl = "https://maps.googleapis.com/maps/api/place/";

    private static Retrofit mRetrofit = new Retrofit.Builder()
            .baseUrl(mBaseUrl)
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
            .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
            .build();

    public Observable<PlacesSearchResultData> getPlacesResult(double lat, double lon, int radius,
                                                              @NonNull String placeType, @NonNull String key){
        GetNearbyPlacesRequest request = mRetrofit.create(GetNearbyPlacesRequest.class);
        return request.getNearbyPlaces(lat + "," + lon, radius, placeType, key)
                .map(EntityMapper::transform);
    }

    @Override
    public Observable<PlaceDetailsResultData> getPlaceDetailResult(@NonNull List<String> placeIds, @NonNull String key) {
        GetPlaceDetailsRequest request = mRetrofit.create(GetPlaceDetailsRequest.class);

        List<Observable<PlaceDetailsResultData>> results = new ArrayList<>();

        for (String placeId : placeIds) {
            results.add(request.getPlaceDetails(placeId, key)
                    .map(EntityMapper::transform));
        }

        return Observable.merge(results);
    }

    @Override
    public Observable<PlacesSearchResultData> getNextPagePlacesResult(@NonNull String pageToken, @NonNull String key) {
//        try {
//            Thread.sleep(1500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        GetNextPageRequest request = mRetrofit.create(GetNextPageRequest.class);
        return request.getNextPagePlaces(pageToken, key)
                .map(EntityMapper::transform);
    }
}
