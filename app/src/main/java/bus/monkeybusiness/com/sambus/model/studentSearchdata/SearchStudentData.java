
package bus.monkeybusiness.com.sambus.model.studentSearchdata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchStudentData {

    @SerializedName("response_metadata")
    @Expose
    private ResponseMetadata responseMetadata;
    @SerializedName("data")
    @Expose
    private Data data;

    /**
     * 
     * @return
     *     The responseMetadata
     */
    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }

    /**
     * 
     * @param responseMetadata
     *     The response_metadata
     */
    public void setResponseMetadata(ResponseMetadata responseMetadata) {
        this.responseMetadata = responseMetadata;
    }

    /**
     * 
     * @return
     *     The data
     */
    public Data getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The data
     */
    public void setData(Data data) {
        this.data = data;
    }

}
