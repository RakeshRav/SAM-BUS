package bus.monkeybusiness.com.sambus.model.checkLoginResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Picture {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("has_picture_id")
    @Expose
    private int hasPictureId;
    @SerializedName("has_picture_type")
    @Expose
    private String hasPictureType;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    /**
     * @return The id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return The hasPictureId
     */
    public int getHasPictureId() {
        return hasPictureId;
    }

    /**
     * @param hasPictureId The has_picture_id
     */
    public void setHasPictureId(int hasPictureId) {
        this.hasPictureId = hasPictureId;
    }

    /**
     * @return The hasPictureType
     */
    public String getHasPictureType() {
        return hasPictureType;
    }

    /**
     * @param hasPictureType The has_picture_type
     */
    public void setHasPictureType(String hasPictureType) {
        this.hasPictureType = hasPictureType;
    }

    /**
     * @return The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
