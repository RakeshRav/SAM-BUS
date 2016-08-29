package bus.monkeybusiness.com.sambus.model.busListResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data {

    @SerializedName("bus")
    @Expose
    private List<Bu> bus = new ArrayList<Bu>();
    @SerializedName("count")
    @Expose
    private Object count;

    /**
     * @return The bus
     */
    public List<Bu> getBus() {
        return bus;
    }

    /**
     * @param bus The bus
     */
    public void setBus(List<Bu> bus) {
        this.bus = bus;
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
