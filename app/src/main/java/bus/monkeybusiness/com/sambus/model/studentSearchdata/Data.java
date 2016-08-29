
package bus.monkeybusiness.com.sambus.model.studentSearchdata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data {

    @SerializedName("students")
    @Expose
    private List<Student> students = new ArrayList<Student>();
    @SerializedName("count")
    @Expose
    private Object count;

    /**
     * 
     * @return
     *     The students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * 
     * @param students
     *     The students
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * 
     * @return
     *     The count
     */
    public Object getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    public void setCount(Object count) {
        this.count = count;
    }

}
