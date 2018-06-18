
package podonin.android.com.data.entity.places;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PeriodEntity implements Serializable
{

    @SerializedName("close")
    @Expose
    private DayAndTimeEntity close;
    @SerializedName("open")
    @Expose
    private DayAndTimeEntity open;

    public DayAndTimeEntity getClose() {
        return close;
    }

    public void setClose(DayAndTimeEntity close) {
        this.close = close;
    }

    public DayAndTimeEntity getOpen() {
        return open;
    }

    public void setOpen(DayAndTimeEntity open) {
        this.open = open;
    }

}
