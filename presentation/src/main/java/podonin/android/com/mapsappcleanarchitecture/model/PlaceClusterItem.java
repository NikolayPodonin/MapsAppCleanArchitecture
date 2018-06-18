package podonin.android.com.mapsappcleanarchitecture.model;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

import podonin.android.com.domain.model.LocationData;
import podonin.android.com.domain.model.PlaceData;

public class PlaceClusterItem implements ClusterItem {
    private PlaceData mPlaceData;

    public PlaceClusterItem(PlaceData placeData) {
        mPlaceData = placeData;
    }

    @Override
    public LatLng getPosition() {
        LocationData location = mPlaceData.getGeometry().getLocation();
        LatLng latLng = new LatLng(location.getLat(), location.getLng());
        return latLng;
    }

    public PlaceData getPlaceData() {
        return mPlaceData;
    }
}
