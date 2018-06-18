
package podonin.android.com.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlaceDetailsResultData implements Serializable
{
    private List<String> htmlAttributions = new ArrayList<>();
    private PlaceData result;
    private String status;

    public List<String> getHtmlAttributions() {
        return htmlAttributions;
    }

    public void setHtmlAttributions(List<String> htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
    }

    public PlaceData getResult() {
        return result;
    }

    public void setResult(PlaceData result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
