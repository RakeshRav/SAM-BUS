package bus.monkeybusiness.com.sambus.model.announcementResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserLogin {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("user_type")
    @Expose
    private UserType userType;

    /**
     * @return The id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return The userType
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * @param userType The user_type
     */
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

}
