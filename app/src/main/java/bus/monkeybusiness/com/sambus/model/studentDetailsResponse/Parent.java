package bus.monkeybusiness.com.sambus.model.studentDetailsResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parent {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("parent_name")
    @Expose
    private String parentName;
    @SerializedName("contact_phone")
    @Expose
    private String contactPhone;
    @SerializedName("contact_email")
    @Expose
    private String contactEmail;
    @SerializedName("contact_alt_phone")
    @Expose
    private String contactAltPhone;
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
     * @return The parentName
     */
    public String getParentName() {
        return parentName;
    }

    /**
     * @param parentName The parent_name
     */
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    /**
     * @return The contactPhone
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * @param contactPhone The contact_phone
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    /**
     * @return The contactEmail
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * @param contactEmail The contact_email
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    /**
     * @return The contactAltPhone
     */
    public String getContactAltPhone() {
        return contactAltPhone;
    }

    /**
     * @param contactAltPhone The contact_alt_phone
     */
    public void setContactAltPhone(String contactAltPhone) {
        this.contactAltPhone = contactAltPhone;
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
