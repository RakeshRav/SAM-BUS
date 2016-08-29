package bus.monkeybusiness.com.sambus.model.busStudentList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("bus")
    @Expose
    private Bus bus;

    /**
     * @return The bus
     */
    public Bus getBus() {
        return bus;
    }

    /**
     * @param bus The bus
     */
    public void setBus(Bus bus) {
        this.bus = bus;
    }

}
