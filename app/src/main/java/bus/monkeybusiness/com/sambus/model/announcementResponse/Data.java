package bus.monkeybusiness.com.sambus.model.announcementResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data {

    @SerializedName("announcements")
    @Expose
    private List<Announcement> announcements = new ArrayList<Announcement>();
    @SerializedName("count")
    @Expose
    private Object count;

    /**
     * @return The announcements
     */
    public List<Announcement> getAnnouncements() {
        return announcements;
    }

    /**
     * @param announcements The announcements
     */
    public void setAnnouncements(List<Announcement> announcements) {
        this.announcements = announcements;
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
