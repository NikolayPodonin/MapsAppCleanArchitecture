
package podonin.android.com.domain.model;

import java.io.Serializable;

public class DayAndTimeData implements Serializable
{
    private Integer day;
    private String time;

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
