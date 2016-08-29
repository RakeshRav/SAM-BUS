package bus.monkeybusiness.com.sambus.model.studentDetailsResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Course {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("course_name")
    @Expose
    private String courseName;
    @SerializedName("school_id")
    @Expose
    private int schoolId;
    @SerializedName("grade_id")
    @Expose
    private int gradeId;
    @SerializedName("comments")
    @Expose
    private String comments;
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
     * @return The courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName The course_name
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
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
     * @return The gradeId
     */
    public int getGradeId() {
        return gradeId;
    }

    /**
     * @param gradeId The grade_id
     */
    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    /**
     * @return The comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments The comments
     */
    public void setComments(String comments) {
        this.comments = comments;
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
