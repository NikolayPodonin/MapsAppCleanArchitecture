
package podonin.android.com.data.entity.places;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpeningHoursEntity implements Serializable
{

    @SerializedName("open_now")
    @Expose
    private Boolean openNow;
    @SerializedName("periods")
    @Expose
    private List<PeriodEntity> periods = new ArrayList<>();
    @SerializedName("weekday_text")
    @Expose
    private List<String> weekdayText = new ArrayList<>();

    public Boolean getOpenNow() {
        return openNow;
    }

    public void setOpenNow(Boolean openNow) {
        this.openNow = openNow;
    }

    public List<PeriodEntity> getPeriods() {
        return periods;
    }

    public void setPeriods(List<PeriodEntity> periods) {
        this.periods = periods;
    }

    public List<String> getWeekdayText() {
        return weekdayText;
    }

    public void setWeekdayText(List<String> weekdayText) {
        this.weekdayText = weekdayText;
    }

}
