package bus.monkeybusiness.com.sambus.model.busListResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bu {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("bus_name")
    @Expose
    private String busName;
    @SerializedName("teacher_id")
    @Expose
    private int teacherId;
    @SerializedName("school_id")
    @Expose
    private int schoolId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("student_count")
    @Expose
    private int studentCount;

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
     * @return The busName
     */
    public String getBusName() {
        return busName;
    }

    /**
     * @param busName The bus_name
     */
    public void setBusName(String busName) {
        this.busName = busName;
    }

    /**
     * @return The teacherId
     */
    public int getTeacherId() {
        return teacherId;
    }

    /**
     * @param teacherId The teacher_id
     */
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
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
     * @return The studentCount
     */
    public int getStudentCount() {
        return studentCount;
    }

    /**
     * @param studentCount The student_count
     */
    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

}
