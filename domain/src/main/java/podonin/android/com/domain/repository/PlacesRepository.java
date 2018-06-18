package podonin.android.com.domain.repository;

import android.support.annotation.NonNull;

import java.util.List;

import podonin.android.com.domain.model.PlaceDetailsResultData;
import podonin.android.com.domain.model.PlacesSearchResultData;
import rx.Observable;

public interface PlacesRepository {
    Observable<PlacesSearchResultData> getPlacesResult(double lat, double lon, int radius, @NonNull String placeType, @NonNull String key);

    Observable<PlacesSearchResultData> getNextPagePlacesResult(@NonNull String pageToken, @NonNull String key);

    Observable<PlaceDetailsResultData> getPlaceDetailResult(@NonNull List<String> placeIds, @NonNull String key);
}
