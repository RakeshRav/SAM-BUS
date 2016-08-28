package bus.monkeybusiness.com.sambus.model.checkLoginResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInfo {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("contact")
    @Expose
    private long contact;
    @SerializedName("last_ip_address")
    @Expose
    private Object lastIpAddress;
    @SerializedName("activation_status")
    @Expose
    private Boolean activationStatus;
    @SerializedName("locked_status")
    @Expose
    private Boolean lockedStatus;
    @SerializedName("school_id")
    @Expose
    private int schoolId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("user_type_id")
    @Expose
    private int userTypeId;
    @SerializedName("user_type_type")
    @Expose
    private String userTypeType;

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
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return The contact
     */
    public long getContact() {
        return contact;
    }

    /**
     * @param contact The contact
     */
    public void setContact(long contact) {
        this.contact = contact;
    }

    /**
     * @return The lastIpAddress
     */
    public Object getLastIpAddress() {
        return lastIpAddress;
    }

    /**
     * @param lastIpAddress The last_ip_address
     */
    public void setLastIpAddress(Object lastIpAddress) {
        this.lastIpAddress = lastIpAddress;
    }

    /**
     * @return The activationStatus
     */
    public Boolean getActivationStatus() {
        return activationStatus;
    }

    /**
     * @param activationStatus The activation_status
     */
    public void setActivationStatus(Boolean activationStatus) {
        this.activationStatus = activationStatus;
    }

    /**
     * @return The lockedStatus
     */
    public Boolean getLockedStatus() {
        return lockedStatus;
    }

    /**
     * @param lockedStatus The locked_status
     */
    public void setLockedStatus(Boolean lockedStatus) {
        this.lockedStatus = lockedStatus;
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
     * @return The userTypeId
     */
    public int getUserTypeId() {
        return userTypeId;
    }

    /**
     * @param userTypeId The user_type_id
     */
    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    /**
     * @return The userTypeType
     */
    public String getUserTypeType() {
        return userTypeType;
    }

    /**
     * @param userTypeType The user_type_type
     */
    public void setUserTypeType(String userTypeType) {
        this.userTypeType = userTypeType;
    }

}
