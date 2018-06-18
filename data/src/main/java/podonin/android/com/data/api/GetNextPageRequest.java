package podonin.android.com.data.api;

import podonin.android.com.data.entity.places.PlacesSearchResultEntity;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface GetNextPageRequest {
    String BASE_URL = "nearbysearch/json?";
    String PAGE_TOKEN = "pagetoken";
    String KEY = "key";

    @GET(BASE_URL)
    Observable<PlacesSearchResultEntity> getNextPagePlaces(@Query(PAGE_TOKEN) String pageToken, @Query(KEY) String key);

}
