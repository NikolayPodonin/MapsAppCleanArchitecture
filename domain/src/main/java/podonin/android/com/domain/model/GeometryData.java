
package podonin.android.com.domain.model;

import java.io.Serializable;

public class GeometryData implements Serializable
{
    private LocationData location;
    private ViewportData viewport;

    public LocationData getLocation() {
        return location;
    }

    public void setLocation(LocationData location) {
        this.location = location;
    }

    public ViewportData getViewport() {
        return viewport;
    }

    public void setViewport(ViewportData viewport) {
        this.viewport = viewport;
    }

}
