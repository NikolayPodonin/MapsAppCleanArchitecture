
package podonin.android.com.domain.model;

import java.io.Serializable;

public class PeriodData implements Serializable
{
    private DayAndTimeData close;
    private DayAndTimeData open;

    public DayAndTimeData getClose() {
        return close;
    }

    public void setClose(DayAndTimeData close) {
        this.close = close;
    }

    public DayAndTimeData getOpen() {
        return open;
    }

    public void setOpen(DayAndTimeData open) {
        this.open = open;
    }

}
