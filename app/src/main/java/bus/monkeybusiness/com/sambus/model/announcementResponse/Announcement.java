package bus.monkeybusiness.com.sambus.model.announcementResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Announcement {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("announcement_details")
    @Expose
    private String announcementDetails;
    @SerializedName("school_id")
    @Expose
    private int schoolId;
    @SerializedName("user_login_id")
    @Expose
    private int userLoginId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("announcement_maps")
    @Expose
    private List<AnnouncementMap> announcementMaps = new ArrayList<AnnouncementMap>();
    @SerializedName("user_login")
    @Expose
    private UserLogin userLogin;

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
     * @return The schoolId
     */
    public int getSchoolId() {
        return schoolId;
    }

    /**
     * @param schoolId The school_id
     */
    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    /**
     * @return The userLoginId
     */
    public int getUserLoginId() {
        return userLoginId;
    }

    /**
     * @param userLoginId The user_login_id
     */
    public void setUserLoginId(int userLoginId) {
        this.userLoginId = userLoginId;
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

    /**
     * @return The announcementMaps
     */
    public List<AnnouncementMap> getAnnouncementMaps() {
        return announcementMaps;
    }

    /**
     * @param announcementMaps The announcement_maps
     */
    public void setAnnouncementMaps(List<AnnouncementMap> announcementMaps) {
        this.announcementMaps = announcementMaps;
    }

    /**
     * @return The userLogin
     */
    public UserLogin getUserLogin() {
        return userLogin;
    }

    /**
     * @param userLogin The user_login
     */
    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

}
