
package podonin.android.com.domain.model;

import java.io.Serializable;

public class ViewportData implements Serializable
{
    private LocationData northeast;
    private LocationData southwest;

    public LocationData getNortheast() {
        return northeast;
    }

    public void setNortheast(LocationData northeast) {
        this.northeast = northeast;
    }

    public LocationData getSouthwest() {
        return southwest;
    }

    public void setSouthwest(LocationData southwest) {
        this.southwest = southwest;
    }

}
