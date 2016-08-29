package bus.monkeybusiness.com.sambus.model.studentRemarksData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data {

    @SerializedName("remarks")
    @Expose
    private List<Remark> remarks = new ArrayList<Remark>();
    @SerializedName("count")
    @Expose
    private Object count;

    /**
     * @return The remarks
     */
    public List<Remark> getRemarks() {
        return remarks;
    }

    /**
     * @param remarks The remarks
     */
    public void setRemarks(List<Remark> remarks) {
        this.remarks = remarks;
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
