
package podonin.android.com.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OpeningHoursData implements Serializable
{
    private Boolean openNow;
    private List<PeriodData> periods = new ArrayList<>();
    private List<String> weekdayText = new ArrayList<>();

    public Boolean getOpenNow() {
        return openNow;
    }

    public void setOpenNow(Boolean openNow) {
        this.openNow = openNow;
    }

    public List<PeriodData> getPeriods() {
        return periods;
    }

    public void setPeriods(List<PeriodData> periods) {
        this.periods = periods;
    }

    public List<String> getWeekdayText() {
        return weekdayText;
    }

    public void setWeekdayText(List<String> weekdayText) {
        this.weekdayText = weekdayText;
    }

}
