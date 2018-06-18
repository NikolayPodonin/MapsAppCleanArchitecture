
package podonin.android.com.data.entity.places;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlacesSearchResultEntity implements Serializable
{

    @SerializedName("html_attributions")
    @Expose
    private List<String> htmlAttributions = new ArrayList<>();
    @SerializedName("next_page_token")
    @Expose
    private String nextPageToken;
    @SerializedName("results")
    @Expose
    private List<PlaceEntity> results = new ArrayList<>();
    @SerializedName("status")
    @Expose
    private String status;

    public List<String> getHtmlAttributions() {
        return htmlAttributions;
    }

    public void setHtmlAttributions(List<String> htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public List<PlaceEntity> getResults() {
        return results;
    }

    public void setResults(List<PlaceEntity> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
