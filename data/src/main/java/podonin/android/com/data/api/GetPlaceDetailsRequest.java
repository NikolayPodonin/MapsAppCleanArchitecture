package podonin.android.com.data.api;

import podonin.android.com.data.entity.places.PlaceDetailsResultEntity;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface GetPlaceDetailsRequest {
    String BASE_URL = "details/json?";
    String PLACE_ID = "placeid";
    String KEY = "key";

    @GET(BASE_URL)
    Observable<PlaceDetailsResultEntity> getPlaceDetails(@Query(PLACE_ID) String placeId, @Query(KEY) String key);
}
