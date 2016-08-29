
package bus.monkeybusiness.com.sambus.model.studentSearchdata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Student {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("student_name")
    @Expose
    private String studentName;
    @SerializedName("batch_id")
    @Expose
    private Integer batchId;
    @SerializedName("rollno")
    @Expose
    private Integer rollno;
    @SerializedName("batch")
    @Expose
    private Batch batch;

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * 
     * @param studentName
     *     The student_name
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * 
     * @return
     *     The batchId
     */
    public Integer getBatchId() {
        return batchId;
    }

    /**
     * 
     * @param batchId
     *     The batch_id
     */
    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    /**
     * 
     * @return
     *     The rollno
     */
    public Integer getRollno() {
        return rollno;
    }

    /**
     * 
     * @param rollno
     *     The rollno
     */
    public void setRollno(Integer rollno) {
        this.rollno = rollno;
    }

    /**
     * 
     * @return
     *     The batch
     */
    public Batch getBatch() {
        return batch;
    }

    /**
     * 
     * @param batch
     *     The batch
     */
    public void setBatch(Batch batch) {
        this.batch = batch;
    }

}
