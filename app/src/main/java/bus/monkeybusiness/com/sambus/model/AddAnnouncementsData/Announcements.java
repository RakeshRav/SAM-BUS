package bus.monkeybusiness.com.sambus.model.AddAnnouncementsData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Announcements {

    @SerializedName("announcement_details")
    @Expose
    private String announcementDetails;
    @SerializedName("announcement_type_type")
    @Expose
    private String announcementTypeType;
    @SerializedName("announcement_type_id")
    @Expose
    private List<Integer> announcementTypeId = new ArrayList<Integer>();

    /**
     * @return The announcementDetails
     */
    public String getAnnouncementDetails() {
        return announcementDetails;
    }

    /**
     * @param announcementDetails The announcement_details
     */
    public void setAnnouncementDetails(String announcementDetails) {
        this.announcementDetails = announcementDetails;
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
    public List<Integer> getAnnouncementTypeId() {
        return announcementTypeId;
    }

    /**
     * @param announcementTypeId The announcement_type_id
     */
    public void setAnnouncementTypeId(List<Integer> announcementTypeId) {
        this.announcementTypeId = announcementTypeId;
    }

}
