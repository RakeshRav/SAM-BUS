package bus.monkeybusiness.com.sambus.model.changeRole;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Session {

    @SerializedName("role_id")
    @Expose
    private int roleId;

    /**
     * @return The roleId
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * @param roleId The role_id
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

}
