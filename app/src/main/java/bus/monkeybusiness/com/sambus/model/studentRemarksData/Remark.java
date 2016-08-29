package bus.monkeybusiness.com.sambus.model.studentRemarksData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Remark {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("remark")
    @Expose
    private String remark;
    @SerializedName("user_login_id")
    @Expose
    private int userLoginId;
    @SerializedName("student_id")
    @Expose
    private int studentId;
    @SerializedName("date_of_remark")
    @Expose
    private String dateOfRemark;
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
     * @return The remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark The remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
     * @return The studentId
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * @param studentId The student_id
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * @return The dateOfRemark
     */
    public String getDateOfRemark() {
        return dateOfRemark;
    }

    /**
     * @param dateOfRemark The date_of_remark
     */
    public void setDateOfRemark(String dateOfRemark) {
        this.dateOfRemark = dateOfRemark;
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
