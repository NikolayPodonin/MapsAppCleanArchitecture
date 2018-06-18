package podonin.android.com.mapsappcleanarchitecture.utils;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import podonin.android.com.mapsappcleanarchitecture.R;

public class PlaceStringResUtil {
    private PlaceStringResUtil(){}

    private static Map<String, String> typePairs = new HashMap<>();

    public static String getOpenNowString(Context context, boolean isOpenNow) {
        if (isOpenNow) {
            return context.getString(R.string.place_open);
        }
        return context.getString(R.string.place_close);
    }

    private static String convertString(Context context, String string){
        if (typePairs.isEmpty()){
            for (PlaceType type: PlaceType.values()) {
                typePairs.put(type.name(), context.getString(type.getStringResource()));
                typePairs.put(context.getString(type.getStringResource()), type.name());
            }
        }
        return typePairs.get(string);
    }

    public static String getLocalizedTypeName(Context context, String typeName) {
        return convertString(context, typeName);
    }

    public static String getCanonicalTypeName(Context context, String typeName) {
        return convertString(context, typeName);
    }

    public static String getNonInformationString(Context context) {
        return context.getString(R.string.none_information);
    }

    private enum PlaceType {
        bar,
        cafe,
        book_store,
        florist,
        hair_care,
        hospital,
        movie_theater,
        museum,
        pharmacy,
        restaurant,
        subway_station;

        public int getStringResource() {
            switch (this) {
                case bar:
                    return R.string.type_bar;
                case cafe:
                    return R.string.type_cafe;
                case book_store:
                    return R.string.type_book_store;
                case florist:
                    return R.string.type_florist;
                case hair_care:
                    return R.string.type_hair_care;
                case hospital:
                    return R.string.type_hospital;
                case pharmacy:
                    return R.string.type_pharmacy;
                case museum:
                    return R.string.type_museum;
                case restaurant:
                    return R.string.type_restaurant;
                case movie_theater:
                    return R.string.type_movie_theater;
                case subway_station:
                    return R.string.type_subway_station;
                default:
                    return R.string.none;
            }
        }
    }
}
