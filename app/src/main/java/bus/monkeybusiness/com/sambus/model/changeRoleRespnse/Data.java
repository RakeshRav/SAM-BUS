package bus.monkeybusiness.com.sambus.model.changeRoleRespnse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("role")
    @Expose
    private Role role;

    /**
     * @return The role
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role The role
     */
    public void setRole(Role role) {
        this.role = role;
    }

}
