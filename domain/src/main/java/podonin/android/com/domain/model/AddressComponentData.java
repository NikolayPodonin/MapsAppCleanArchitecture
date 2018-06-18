
package podonin.android.com.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddressComponentData implements Serializable
{
    private String longName;
    private String shortName;
    private List<String> types = new ArrayList<>();

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

}
