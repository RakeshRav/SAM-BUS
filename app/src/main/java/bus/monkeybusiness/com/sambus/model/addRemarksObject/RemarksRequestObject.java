
package bus.monkeybusiness.com.sambus.model.addRemarksObject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RemarksRequestObject {

    @SerializedName("remarks")
    @Expose
    private Remarks remarks;

    /**
     * 
     * @return
     *     The remarks
     */
    public Remarks getRemarks() {
        return remarks;
    }

    /**
     * 
     * @param remarks
     *     The remarks
     */
    public void setRemarks(Remarks remarks) {
        this.remarks = remarks;
    }

}
