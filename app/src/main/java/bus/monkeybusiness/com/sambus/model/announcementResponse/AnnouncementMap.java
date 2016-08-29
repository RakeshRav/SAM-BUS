package bus.monkeybusiness.com.sambus.model.announcementResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnnouncementMap {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("announcement_type_type")
    @Expose
    private String announcementTypeType;
    @SerializedName("announcement_type_id")
    @Expose
    private int announcementTypeId;
    @SerializedName("announcement_type")
    @Expose
    private AnnouncementType announcementType;

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
     * @return The announcementTypeType
     */
    public String getAnnouncementTypeType() {
        return announcementTypeType;
    }

    /**
     * @param announcementTypeType The announcement_type_type
     */
    public void setAnnouncementTypeType(String announcementTypeType) {
        this.announcementTypeType = announcementTypeType;
    }

    /**
     * @return The announcementTypeId
     */
    public int getAnnouncementTypeId() {
        return announcementTypeId;
    }

    /**
     * @param announcementTypeId The announcement_type_id
     */
    public void setAnnouncementTypeId(int announcementTypeId) {
        this.announcementTypeId = announcementTypeId;
    }

    /**
     * @return The announcementType
     */
    public AnnouncementType getAnnouncementType() {
        return announcementType;
    }

    /**
     * @param announcementType The announcement_type
     */
    public void setAnnouncementType(AnnouncementType announcementType) {
        this.announcementType = announcementType;
    }

}
