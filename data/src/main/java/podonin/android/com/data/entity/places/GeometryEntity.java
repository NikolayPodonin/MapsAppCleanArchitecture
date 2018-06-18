
package podonin.android.com.data.entity.places;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GeometryEntity implements Serializable
{

    @SerializedName("location")
    @Expose
    private LocationEntity location;
    @SerializedName("viewport")
    @Expose
    private ViewportEntity viewport;

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public ViewportEntity getViewport() {
        return viewport;
    }

    public void setViewport(ViewportEntity viewport) {
        this.viewport = viewport;
    }

}
