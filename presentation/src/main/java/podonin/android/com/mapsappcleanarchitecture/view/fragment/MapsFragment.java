package podonin.android.com.mapsappcleanarchitecture.view.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import podonin.android.com.domain.model.PlaceData;
import podonin.android.com.mapsappcleanarchitecture.R;
import podonin.android.com.mapsappcleanarchitecture.adapter.PlacesRvAdapter;
import podonin.android.com.mapsappcleanarchitecture.model.PlaceClusterItem;
import podonin.android.com.mapsappcleanarchitecture.presenter.MapsPresenter;
import podonin.android.com.mapsappcleanarchitecture.utils.PlaceStringResUtil;
import podonin.android.com.mapsappcleanarchitecture.view.MapsView;

public class MapsFragment extends Fragment implements MapsView {

    public static MapsFragment newInstance() {
        return new MapsFragment();
    }

    private static final int PERMISSION_REQUEST_CODE = 0;

    private MapsPresenter mMapsPresenter;
    private FusedLocationProviderClient mLocationProviderClient;
    private MapView mMapView;
    private GoogleMap mMap;
    private OnMapReadyCallback mMapReadyCallback = (googleMap) -> {
        mMap = googleMap;
        mMapsPresenter.mapIsReady();
    };
    private ClusterManager<PlaceClusterItem> mClusterManager;
    private RecyclerView mRecyclerView;
    private PlacesRvAdapter mRvAdapter;
    private BottomSheetBehavior mBottomSheetBehavior;
    private String mLocalizedPlaceType = "Кафе";

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(R.layout.fragment_maps, viewGroup, false);
        mMapView = view.findViewById(R.id.map);
        mBottomSheetBehavior = BottomSheetBehavior.from(view.findViewById(R.id.bottom_sheet));
        mRecyclerView = view.findViewById(R.id.places_recycler_view);
        mMapView.onCreate(bundle);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMapsPresenter = new MapsPresenter(this);
        mLocationProviderClient = LocationServices.getFusedLocationProviderClient(Objects.requireNonNull(getContext()));
        mMapView.getMapAsync(mMapReadyCallback);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvAdapter = new PlacesRvAdapter(mLocalizedPlaceType);
        mRecyclerView.setAdapter(mRvAdapter);

    }

    @Override
    public void onStart() {
        mMapView.onStart();
        super.onStart();
    }

    @Override
    public void onResume() {
        mMapView.onResume();
        super.onResume();
    }

    @Override
    public void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    public void onStop() {
        mMapView.onStop();
        super.onStop();
    }

    @Override
    public void onDestroy() {
        mMapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        mMapView.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        mMapView.onLowMemory();
        super.onLowMemory();
    }

    @Override
    public void setUpClusterer() {
        mClusterManager = new ClusterManager<>(
                Objects.requireNonNull(getActivity()), mMap);
        mClusterManager.setOnClusterItemClickListener(placeClusterItem -> {
            List<PlaceData> placeDataList = new ArrayList<>();
            placeDataList.add(placeClusterItem.getPlaceData());
            mMapsPresenter.onNeedDetails(placeDataList, getString(R.string.google_maps_key));
            return true;
        });
        mClusterManager.setOnClusterClickListener(cluster -> {
            if (cluster.getSize() > 2) {
                int width = getWidth();
                mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(getBounds(cluster.getItems()), width / 18));
            } else {
                List<PlaceData> placeDataList = new ArrayList<>();
                for (PlaceClusterItem item: cluster.getItems()) {
                    placeDataList.add(item.getPlaceData());
                }
                mMapsPresenter.onNeedDetails(placeDataList, getString(R.string.google_maps_key));
            }
            return true;
        });
        mMap.setOnCameraIdleListener(mClusterManager);
        mMap.setOnMarkerClickListener(mClusterManager);
    }

    private int getWidth() {
        Display display = Objects.requireNonNull(getActivity()).getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        return point.x;
    }

    private LatLngBounds getBounds(@NonNull Collection<PlaceClusterItem> items) {
        LatLngBounds.Builder builder = LatLngBounds.builder();
        for (PlaceClusterItem item : items) {
            builder.include(item.getPosition());
        }
        return builder.build();
    }

    @Override
    public void showClusterItems(Collection<PlaceClusterItem> items) {
        mClusterManager.addItems(items);
    }

    @Override
    public void showBottomSheetWithData(List<PlaceData> placeDataList) {
        mRvAdapter.setData(placeDataList, mLocalizedPlaceType);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    @Override
    public void addMarker(double lat, double lon, String title) {
        LatLng location = new LatLng(lat, lon);
        mMap.addMarker(new MarkerOptions().position(location).title(title));
    }

    @Override
    public void requestLocation(){
        if (ActivityCompat.checkSelfPermission(Objects.requireNonNull(getActivity()),
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mLocationProviderClient.getLastLocation().addOnSuccessListener(getActivity(), location -> {
                if (location != null) {
                    mMapsPresenter.onLocationProvided(location.getLatitude(), location.getLongitude());
                } else {
                    mMapsPresenter.onNeedPlaces(60.019131, 30.402735, 10000,
                            PlaceStringResUtil.getCanonicalTypeName(getContext(), getString(R.string.type_cafe)),
                            getString(R.string.google_maps_key));
                }
            });
        } else {
            mMapsPresenter.onNeedRequestPermission();
        }
    }

    @Override
    public void requestPermission() {
        requestPermissions(new String[] { Manifest.permission.ACCESS_FINE_LOCATION }, PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE){
            mMapsPresenter.onPermissionRequestResult(grantResults[0] == PackageManager.PERMISSION_GRANTED);
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
