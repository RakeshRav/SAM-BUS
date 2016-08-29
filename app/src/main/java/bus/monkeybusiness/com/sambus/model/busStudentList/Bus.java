package bus.monkeybusiness.com.sambus.model.busStudentList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Bus {

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
    @SerializedName("students")
    @Expose
    private List<Student> students = new ArrayList<Student>();
    @SerializedName("bus_staff")
    @Expose
    private BusStaff busStaff;

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
     * @return The students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * @param students The students
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * @return The busStaff
     */
    public BusStaff getBusStaff() {
        return busStaff;
    }

    /**
     * @param busStaff The bus_staff
     */
    public void setBusStaff(BusStaff busStaff) {
        this.busStaff = busStaff;
    }

}
