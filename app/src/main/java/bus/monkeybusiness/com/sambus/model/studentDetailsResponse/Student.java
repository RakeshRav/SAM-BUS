package bus.monkeybusiness.com.sambus.model.studentDetailsResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Student {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("student_name")
    @Expose
    private String studentName;
    @SerializedName("father_name")
    @Expose
    private String fatherName;
    @SerializedName("mother_name")
    @Expose
    private String motherName;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("school_id")
    @Expose
    private int schoolId;
    @SerializedName("batch_id")
    @Expose
    private int batchId;
    @SerializedName("course_id")
    @Expose
    private int courseId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("pin_code")
    @Expose
    private int pinCode;
    @SerializedName("rollno")
    @Expose
    private int rollno;
    @SerializedName("date_of_joining")
    @Expose
    private String dateOfJoining;
    @SerializedName("date_of_leaving")
    @Expose
    private Object dateOfLeaving;
    @SerializedName("locked_status")
    @Expose
    private Object lockedStatus;
    @SerializedName("parent_id")
    @Expose
    private int parentId;
    @SerializedName("batch")
    @Expose
    private Batch batch;
    @SerializedName("parent")
    @Expose
    private Parent parent;
    @SerializedName("course")
    @Expose
    private Course course;
    @SerializedName("attendances")
    @Expose
    private List<Attendance> attendances = new ArrayList<Attendance>();
    @SerializedName("picture")
    @Expose
    private Picture picture= new Picture();

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
     * @return The studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName The student_name
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
     * @return The batchId
     */
    public int getBatchId() {
        return batchId;
    }

    /**
     * @param batchId The batch_id
     */
    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    /**
     * @return The courseId
     */
    public int getCourseId() {
        return courseId;
    }

    /**
     * @param courseId The course_id
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
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
     * @return The address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return The city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return The state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return The pinCode
     */
    public int getPinCode() {
        return pinCode;
    }

    /**
     * @param pinCode The pin_code
     */
    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    /**
     * @return The rollno
     */
    public int getRollno() {
        return rollno;
    }

    /**
     * @param rollno The rollno
     */
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    /**
     * @return The dateOfJoining
     */
    public String getDateOfJoining() {
        return dateOfJoining;
    }

    /**
     * @param dateOfJoining The date_of_joining
     */
    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    /**
     * @return The dateOfLeaving
     */
    public Object getDateOfLeaving() {
        return dateOfLeaving;
    }

    /**
     * @param dateOfLeaving The date_of_leaving
     */
    public void setDateOfLeaving(Object dateOfLeaving) {
        this.dateOfLeaving = dateOfLeaving;
    }

    /**
     * @return The lockedStatus
     */
    public Object getLockedStatus() {
        return lockedStatus;
    }

    /**
     * @param lockedStatus The locked_status
     */
    public void setLockedStatus(Object lockedStatus) {
        this.lockedStatus = lockedStatus;
    }

    /**
     * @return The parentId
     */
    public int getParentId() {
        return parentId;
    }

    /**
     * @param parentId The parent_id
     */
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    /**
     * @return The batch
     */
    public Batch getBatch() {
        return batch;
    }

    /**
     * @param batch The batch
     */
    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    /**
     * @return The parent
     */
    public Parent getParent() {
        return parent;
    }

    /**
     * @param parent The parent
     */
    public void setParent(Parent parent) {
        this.parent = parent;
    }

    /**
     * @return The course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @param course The course
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * @return The attendances
     */
    public List<Attendance> getAttendances() {
        return attendances;
    }

    /**
     * @param attendances The attendances
     */
    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

}
