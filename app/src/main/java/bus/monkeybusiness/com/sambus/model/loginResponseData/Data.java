package bus.monkeybusiness.com.sambus.model.loginResponseData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data {

    @SerializedName("user_type_details")
    @Expose
    private String userTypeDetails;
    @SerializedName("user_roles")
    @Expose
    private List<UserRole> userRoles = new ArrayList<UserRole>();

    /**
     * @return The userTypeDetails
     */
    public String getUserTypeDetails() {
        return userTypeDetails;
    }

    /**
     * @param userTypeDetails The user_type_details
     */
    public void setUserTypeDetails(String userTypeDetails) {
        this.userTypeDetails = userTypeDetails;
    }

    /**
     * @return The userRoles
     */
    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    /**
     * @param userRoles The user_roles
     */
    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

}
