package bus.monkeybusiness.com.sambus.model.studentsResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Batch {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("grade_id")
    @Expose
    private int gradeId;
    @SerializedName("school_id")
    @Expose
    private int schoolId;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("class_alias")
    @Expose
    private String classAlias;
    @SerializedName("teacher_id")
    @Expose
    private int teacherId;
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
     * @return The section
     */
    public String getSection() {
        return section;
    }

    /**
     * @param section The section
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * @return The classAlias
     */
    public String getClassAlias() {
        return classAlias;
    }

    /**
     * @param classAlias The class_alias
     */
    public void setClassAlias(String classAlias) {
        this.classAlias = classAlias;
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
