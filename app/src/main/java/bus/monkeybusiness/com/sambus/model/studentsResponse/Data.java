package bus.monkeybusiness.com.sambus.model.studentsResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data {

    @SerializedName("batch")
    @Expose
    private Batch batch;
    @SerializedName("students")
    @Expose
    private List<Student> students = new ArrayList<Student>();
    @SerializedName("count")
    @Expose
    private Object count;

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
     * @return The count
     */
    public Object getCount() {
        return count;
    }

    /**
     * @param count The count
     */
    public void setCount(Object count) {
        this.count = count;
    }

}
