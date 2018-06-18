package podonin.android.com.mapsappcleanarchitecture.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import podonin.android.com.domain.model.PlaceData;
import podonin.android.com.mapsappcleanarchitecture.R;
import podonin.android.com.mapsappcleanarchitecture.utils.PlaceStringResUtil;

public class PlacesRvAdapter extends RecyclerView.Adapter<PlacesRvAdapter.PlaceViewHolder> {
    private List<PlaceData> mPlaceDataList = new ArrayList<>();
    private String mType;

    public void setData(@NonNull List<PlaceData> placeData, @NonNull String type) {
        mPlaceDataList = placeData;
        mType = type;
        notifyDataSetChanged();
    }

    public PlacesRvAdapter(String type) {
        mType = type;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.place_item, parent,false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        holder.bind(mPlaceDataList.get(position), mType);
    }

    @Override
    public int getItemCount() {
        return mPlaceDataList.size();
    }

    class PlaceViewHolder extends RecyclerView.ViewHolder {
        private TextView mPlaceName;
        private TextView mPlaceType;
        private TextView mPlaceAddress;
        private TextView mPlaceOpenNow;
        private WeakReference<Context> mContextWeakReference;

        PlaceViewHolder(View itemView) {
            super(itemView);
            mPlaceName = itemView.findViewById(R.id.place_name_text_view);
            mPlaceType = itemView.findViewById(R.id.place_type_text_view);
            mPlaceAddress = itemView.findViewById(R.id.place_address_text_view);
            mPlaceOpenNow = itemView.findViewById(R.id.place_work_time_text_view);
            mContextWeakReference = new WeakReference<>(itemView.getContext());
        }

        void bind(PlaceData placeData, String type) {
            mPlaceName.setText(placeData.getName());
            mPlaceType.setText(type);
            mPlaceAddress.setText(placeData.getFormattedAddress());
            String openNow;
            if (placeData.getOpeningHours() == null){
                openNow = PlaceStringResUtil.getNonInformationString(mContextWeakReference.get());
            } else {
                openNow = PlaceStringResUtil.getOpenNowString(
                        mContextWeakReference.get(),
                        placeData.getOpeningHours().getOpenNow());
            }
            mPlaceOpenNow.setText(openNow);
        }
    }
}
