package podonin.android.com.data.api;

import podonin.android.com.data.entity.places.PlacesSearchResultEntity;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface GetNearbyPlacesRequest {
    String BASE_URL = "nearbysearch/json?";
    String LOCATION = "location";
    String RADIUS = "radius";
    String KEY = "key";
    String TYPE = "type";

    @GET(BASE_URL)
    Observable<PlacesSearchResultEntity> getNearbyPlaces(@Query(LOCATION) String location,
                                                         @Query(RADIUS) int radius, @Query(TYPE) String placeType, @Query(KEY) String key);
}
