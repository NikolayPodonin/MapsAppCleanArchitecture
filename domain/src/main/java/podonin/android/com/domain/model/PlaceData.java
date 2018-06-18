
package podonin.android.com.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlaceData implements Serializable
{
    private List<AddressComponentData> addressComponents = new ArrayList<>();
    private String adrAddress;
    private String formattedAddress;
    private String formattedPhoneNumber;
    private GeometryData geometry;
    private String icon;
    private String id;
    private String internationalPhoneNumber;
    private String name;
    private OpeningHoursData openingHours;
    private List<PhotoData> photos = new ArrayList<>();
    private String placeId;
    private Double rating;
    private String reference;
    private List<ReviewData> reviews = new ArrayList<>();
    private String scope;
    private List<String> types = new ArrayList<>();
    private String url;
    private Integer utcOffset;
    private String vicinity;
    private Integer priceLevel;
    private String website;

    public List<AddressComponentData> getAddressComponents() {
        return addressComponents;
    }

    public void setAddressComponents(List<AddressComponentData> addressComponents) {
        this.addressComponents = addressComponents;
    }

    public String getAdrAddress() {
        return adrAddress;
    }

    public void setAdrAddress(String adrAddress) {
        this.adrAddress = adrAddress;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getFormattedPhoneNumber() {
        return formattedPhoneNumber;
    }

    public void setFormattedPhoneNumber(String formattedPhoneNumber) {
        this.formattedPhoneNumber = formattedPhoneNumber;
    }

    public GeometryData getGeometry() {
        return geometry;
    }

    public void setGeometry(GeometryData geometry) {
        this.geometry = geometry;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInternationalPhoneNumber() {
        return internationalPhoneNumber;
    }

    public void setInternationalPhoneNumber(String internationalPhoneNumber) {
        this.internationalPhoneNumber = internationalPhoneNumber;
    }

    public OpeningHoursData getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(OpeningHoursData openingHours) {
        this.openingHours = openingHours;
    }

    public List<PhotoData> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoData> photos) {
        this.photos = photos;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<ReviewData> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewData> reviews) {
        this.reviews = reviews;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Integer utcOffset) {
        this.utcOffset = utcOffset;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public Integer getPriceLevel() {
        return priceLevel;
    }

    public void setPriceLevel(Integer priceLevel) {
        this.priceLevel = priceLevel;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
