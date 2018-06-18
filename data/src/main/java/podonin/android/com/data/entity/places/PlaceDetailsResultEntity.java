
package podonin.android.com.data.entity.places;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlaceDetailsResultEntity implements Serializable
{

    @SerializedName("html_attributions")
    @Expose
    private List<String> htmlAttributions = new ArrayList<>();
    @SerializedName("result")
    @Expose
    private PlaceEntity result;
    @SerializedName("status")
    @Expose
    private String status;

    public List<String> getHtmlAttributions() {
        return htmlAttributions;
    }

    public void setHtmlAttributions(List<String> htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
    }

    public PlaceEntity getResult() {
        return result;
    }

    public void setResult(PlaceEntity result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
