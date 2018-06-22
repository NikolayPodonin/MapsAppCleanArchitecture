package podonin.android.com.mapsappcleanarchitecture.view;

import java.util.Collection;
import java.util.List;

import podonin.android.com.domain.model.PlaceData;
import podonin.android.com.mapsappcleanarchitecture.model.PlaceClusterItem;

public interface MapsView {
    void setCentralMarker(double lat, double lon, String title);

    void requestPermission();

    void requestLocation();

    void setUpClusterer();

    void showClusterItems(Collection<PlaceClusterItem> items);

    void showBottomSheetWithData(List<PlaceData> placeDataList);

    void setPlaceType(String localizedType);

    void onChanges();
}
