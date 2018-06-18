
package podonin.android.com.data.entity.places;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ViewportEntity implements Serializable
{

    @SerializedName("northeast")
    @Expose
    private LocationEntity northeast;
    @SerializedName("southwest")
    @Expose
    private LocationEntity southwest;

    public LocationEntity getNortheast() {
        return northeast;
    }

    public void setNortheast(LocationEntity northeast) {
        this.northeast = northeast;
    }

    public LocationEntity getSouthwest() {
        return southwest;
    }

    public void setSouthwest(LocationEntity southwest) {
        this.southwest = southwest;
    }

}
