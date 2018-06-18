
package podonin.android.com.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlacesSearchResultData implements Serializable
{
    private List<String> htmlAttributions = new ArrayList<>();
    private String nextPageToken;
    private List<PlaceData> results = new ArrayList<>();
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

    public List<PlaceData> getResults() {
        return results;
    }

    public void setResults(List<PlaceData> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
