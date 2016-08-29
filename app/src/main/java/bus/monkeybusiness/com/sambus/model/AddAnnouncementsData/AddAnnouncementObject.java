package bus.monkeybusiness.com.sambus.model.AddAnnouncementsData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddAnnouncementObject {

    @SerializedName("announcements")
    @Expose
    private Announcements announcements;

    /**
     * @return The announcements
     */
    public Announcements getAnnouncements() {
        return announcements;
    }

    /**
     * @param announcements The announcements
     */
    public void setAnnouncements(Announcements announcements) {
        this.announcements = announcements;
    }

}
