package bus.monkeybusiness.com.sambus.model.checkLoginResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserTypeDetails {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("teacher_name")
    @Expose
    private String teacherName;
    @SerializedName("father_name")
    @Expose
    private String fatherName;
    @SerializedName("mother_name")
    @Expose
    private String motherName;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("qualification")
    @Expose
    private String qualification;
    @SerializedName("designation")
    @Expose
    private String designation;
    @SerializedName("experience")
    @Expose
    private int experience;
    @SerializedName("field_of_interest")
    @Expose
    private Object fieldOfInterest;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("user_login_id")
    @Expose
    private int userLoginId;
    @SerializedName("school_id")
    @Expose
    private int schoolId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("doj")
    @Expose
    private Object doj;
    @SerializedName("locked_status")
    @Expose
    private String lockedStatus;
    @SerializedName("address")
    @Expose
    private Object address;
    @SerializedName("contact_info")
    @Expose
    private String contactInfo;
    @SerializedName("picture")
    @Expose
    private Picture picture;

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

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
     * @return The teacherName
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * @param teacherName The teacher_name
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * @return The fatherName
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * @param fatherName The father_name
     */
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    /**
     * @return The motherName
     */
    public String getMotherName() {
        return motherName;
    }

    /**
     * @param motherName The mother_name
     */
    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    /**
     * @return The dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob The dob
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return The qualification
     */
    public String getQualification() {
        return qualification;
    }

    /**
     * @param qualification The qualification
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    /**
     * @return The designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation The designation
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * @return The experience
     */
    public int getExperience() {
        return experience;
    }

    /**
     * @param experience The experience
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * @return The fieldOfInterest
     */
    public Object getFieldOfInterest() {
        return fieldOfInterest;
    }

    /**
     * @param fieldOfInterest The field_of_interest
     */
    public void setFieldOfInterest(Object fieldOfInterest) {
        this.fieldOfInterest = fieldOfInterest;
    }

    /**
     * @return The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
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
     * @return The doj
     */
    public Object getDoj() {
        return doj;
    }

    /**
     * @param doj The doj
     */
    public void setDoj(Object doj) {
        this.doj = doj;
    }

    /**
     * @return The lockedStatus
     */
    public String getLockedStatus() {
        return lockedStatus;
    }

    /**
     * @param lockedStatus The locked_status
     */
    public void setLockedStatus(String lockedStatus) {
        this.lockedStatus = lockedStatus;
    }

    /**
     * @return The address
     */
    public Object getAddress() {
        return address;
    }

    /**
     * @param address The address
     */
    public void setAddress(Object address) {
        this.address = address;
    }

    /**
     * @return The contactInfo
     */
    public String getContactInfo() {
        return contactInfo;
    }

    /**
     * @param contactInfo The contact_info
     */
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

}
