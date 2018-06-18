package podonin.android.com.data.mapper;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import podonin.android.com.data.entity.places.AddressComponentEntity;
import podonin.android.com.data.entity.places.GeometryEntity;
import podonin.android.com.data.entity.places.LocationEntity;
import podonin.android.com.data.entity.places.DayAndTimeEntity;
import podonin.android.com.data.entity.places.OpeningHoursEntity;
import podonin.android.com.data.entity.places.PeriodEntity;
import podonin.android.com.data.entity.places.PhotoEntity;
import podonin.android.com.data.entity.places.PlaceDetailsResultEntity;
import podonin.android.com.data.entity.places.PlaceEntity;
import podonin.android.com.data.entity.places.PlacesSearchResultEntity;
import podonin.android.com.data.entity.places.ReviewEntity;
import podonin.android.com.data.entity.places.ViewportEntity;
import podonin.android.com.domain.model.AddressComponentData;
import podonin.android.com.domain.model.GeometryData;
import podonin.android.com.domain.model.LocationData;
import podonin.android.com.domain.model.DayAndTimeData;
import podonin.android.com.domain.model.OpeningHoursData;
import podonin.android.com.domain.model.PeriodData;
import podonin.android.com.domain.model.PhotoData;
import podonin.android.com.domain.model.PlaceData;
import podonin.android.com.domain.model.PlaceDetailsResultData;
import podonin.android.com.domain.model.PlacesSearchResultData;
import podonin.android.com.domain.model.ReviewData;
import podonin.android.com.domain.model.ViewportData;

public class EntityMapper {
    
    
    @Nullable
    public static AddressComponentData transform(@Nullable AddressComponentEntity entity){
        if (entity == null) {
            return null;
        }
        AddressComponentData data = new AddressComponentData();
        data.setLongName(entity.getLongName());
        data.setShortName(entity.getShortName());
        data.setTypes(entity.getTypes());
        return data;
    }

    @Nullable
    public static DayAndTimeData transform(@Nullable DayAndTimeEntity entity){
        if (entity == null) {
            return null;
        }
        DayAndTimeData data = new DayAndTimeData();
        data.setDay(entity.getDay());
        data.setTime(entity.getTime());
        return data;
    }

    @Nullable
    public static GeometryData transform(@Nullable GeometryEntity entity){
        if (entity == null) {
            return null;
        }
        GeometryData data = new GeometryData();
        data.setLocation(transform(entity.getLocation()));
        data.setViewport(transform(entity.getViewport()));
        return data;
    }

    @Nullable
    public static LocationData transform(@Nullable LocationEntity entity){
        if (entity == null) {
            return null;
        }
        LocationData data = new LocationData();
        data.setLat(entity.getLat());
        data.setLng(entity.getLng());
        return data;
    }

    @Nullable
    public static OpeningHoursData transform(@Nullable OpeningHoursEntity entity){
        if (entity == null) {
            return null;
        }
        OpeningHoursData data = new OpeningHoursData();
        data.setOpenNow(entity.getOpenNow());
        List<PeriodData> dataList = new ArrayList<>();
        for (PeriodEntity periodEntity: entity.getPeriods()) {
            dataList.add(transform(periodEntity));
        }
        data.setPeriods(dataList);
        data.setWeekdayText(entity.getWeekdayText());
        return data;
    }

    @Nullable
    public static PeriodData transform(@Nullable PeriodEntity entity) {
        if (entity == null) {
            return null;
        }
        PeriodData data = new PeriodData();
        data.setClose(transform(entity.getClose()));
        data.setOpen(transform(entity.getOpen()));
        return data;
    }

    @Nullable
    public static PhotoData transform(@Nullable PhotoEntity entity) {
        if (entity == null) {
            return null;
        }
        PhotoData data = new PhotoData();
        data.setHeight(entity.getHeight());
        data.setWidth(entity.getWidth());
        data.setPhotoReference(entity.getPhotoReference());
        data.setHtmlAttributions(entity.getHtmlAttributions());
        return data;
    }

    @Nullable
    public static PlaceDetailsResultData transform(@Nullable PlaceDetailsResultEntity entity) {
        if (entity == null) {
            return null;
        }
        PlaceDetailsResultData data = new PlaceDetailsResultData();
        data.setHtmlAttributions(entity.getHtmlAttributions());
        data.setResult(transform(entity.getResult()));
        data.setStatus(entity.getStatus());
        return data;
    }

    @Nullable
    public static PlacesSearchResultData transform(@Nullable PlacesSearchResultEntity entity) {
        if (entity == null) {
            return null;
        }
        PlacesSearchResultData data = new PlacesSearchResultData();
        data.setHtmlAttributions(entity.getHtmlAttributions());
        List<PlaceData> dataList = new ArrayList<>();
        for (PlaceEntity placeEntity: entity.getResults()) {
            dataList.add(transform(placeEntity));
        }
        data.setResults(dataList);
        data.setNextPageToken(entity.getNextPageToken());
        data.setStatus(entity.getStatus());
        return data;
    }

    @Nullable
    public static PlaceData transform(@Nullable PlaceEntity entity) {
        if (entity == null) {
            return null;
        }
        PlaceData data = new PlaceData();
        List<AddressComponentData> dataComponentList = new ArrayList<>();
        for (AddressComponentEntity componentEntity: entity.getAddressComponents()) {
            dataComponentList.add(transform(componentEntity));
        }
        data.setAddressComponents(dataComponentList);
        data.setAdrAddress(entity.getAdrAddress());
        data.setFormattedAddress(entity.getFormattedAddress());
        data.setFormattedPhoneNumber(entity.getFormattedPhoneNumber());
        data.setGeometry(transform(entity.getGeometry()));
        data.setIcon(entity.getIcon());
        data.setId(entity.getId());
        data.setInternationalPhoneNumber(entity.getInternationalPhoneNumber());
        data.setName(entity.getName());
        data.setOpeningHours(transform(entity.getOpeningHours()));
        List<PhotoData> photoDataList = new ArrayList<>();
        for (PhotoEntity photoEntity: entity.getPhotos()) {
            photoDataList.add(transform(photoEntity));
        }
        data.setPhotos(photoDataList);
        data.setPlaceId(entity.getPlaceId());
        data.setPriceLevel(entity.getPriceLevel());
        data.setRating(entity.getRating());
        data.setReference(entity.getReference());
        List<ReviewData> reviewDataList = new ArrayList<>();
        for (ReviewEntity reviewEntity: entity.getReviews()) {
            reviewDataList.add(transform(reviewEntity));
        }
        data.setReviews(reviewDataList);
        data.setScope(entity.getScope());
        data.setTypes(entity.getTypes());
        data.setUrl(entity.getUrl());
        data.setUtcOffset(entity.getUtcOffset());
        data.setVicinity(entity.getVicinity());
        data.setWebsite(entity.getWebsite());
        return data;
    }

    @Nullable
    private static ReviewData transform(@Nullable ReviewEntity entity) {
        if (entity == null) {
            return null;
        }
        ReviewData data = new ReviewData();
        data.setAuthorName(entity.getAuthorName());
        data.setAuthorUrl(entity.getAuthorUrl());
        data.setLanguage(entity.getLanguage());
        data.setProfilePhotoUrl(entity.getProfilePhotoUrl());
        data.setRating(entity.getRating());
        data.setRelativeTimeDescription(entity.getRelativeTimeDescription());
        data.setText(entity.getText());
        data.setTime(entity.getTime());
        return data;
    }

    @Nullable
    private static ViewportData transform(@Nullable ViewportEntity entity) {
        if (entity == null) {
            return null;
        }
        ViewportData data = new ViewportData();
        data.setNortheast(transform(entity.getNortheast()));
        data.setSouthwest(transform(entity.getSouthwest()));
        return data;
    }
}
