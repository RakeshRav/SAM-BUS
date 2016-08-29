package bus.monkeybusiness.com.sambus.model.studentDetailsResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attendance {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("student_id")
    @Expose
    private int studentId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("attendance_date")
    @Expose
    private String attendanceDate;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("is_save")
    @Expose
    private Boolean isSave;
    @SerializedName("student_attendance_group_id")
    @Expose
    private Object studentAttendanceGroupId;

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
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return The attendanceDate
     */
    public String getAttendanceDate() {
        return attendanceDate;
    }

    /**
     * @param attendanceDate The attendance_date
     */
    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
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
     * @return The isSave
     */
    public Boolean getIsSave() {
        return isSave;
    }

    /**
     * @param isSave The is_save
     */
    public void setIsSave(Boolean isSave) {
        this.isSave = isSave;
    }

    /**
     * @return The studentAttendanceGroupId
     */
    public Object getStudentAttendanceGroupId() {
        return studentAttendanceGroupId;
    }

    /**
     * @param studentAttendanceGroupId The student_attendance_group_id
     */
    public void setStudentAttendanceGroupId(Object studentAttendanceGroupId) {
        this.studentAttendanceGroupId = studentAttendanceGroupId;
    }

}
