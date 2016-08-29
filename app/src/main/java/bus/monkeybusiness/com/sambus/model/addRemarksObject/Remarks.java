
package bus.monkeybusiness.com.sambus.model.addRemarksObject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Remarks {

    @SerializedName("students")
    @Expose
    private List<Integer> students = new ArrayList<Integer>();
    @SerializedName("remark")
    @Expose
    private String remark;
    @SerializedName("date_of_remark")
    @Expose
    private String dateOfRemark;

    /**
     * @return The students
     */
    public List<Integer> getStudents() {
        return students;
    }

    /**
     * @param students The students
     */
    public void setStudents(List<Integer> students) {
        this.students = students;
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

}
