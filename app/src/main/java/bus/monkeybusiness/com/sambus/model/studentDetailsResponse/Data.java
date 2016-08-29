package bus.monkeybusiness.com.sambus.model.studentDetailsResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("student")
    @Expose
    private Student student;

    /**
     * @return The student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student The student
     */
    public void setStudent(Student student) {
        this.student = student;
    }

}
