package bus.monkeybusiness.com.sambus.model.changeRole;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChangeRoleObject {

    @SerializedName("session")
    @Expose
    private Session session;

    /**
     * @return The session
     */
    public Session getSession() {
        return session;
    }

    /**
     * @param session The session
     */
    public void setSession(Session session) {
        this.session = session;
    }

}
