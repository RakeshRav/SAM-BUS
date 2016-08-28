
package bus.monkeybusiness.com.sambus.model.loginRequestObject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequestObject {

    @SerializedName("session")
    @Expose
    private Session session;
    @SerializedName("password")
    @Expose
    private String password;

    /**
     * 
     * @return
     *     The session
     */
    public Session getSession() {
        return session;
    }

    /**
     * 
     * @param session
     *     The session
     */
    public void setSession(Session session) {
        this.session = session;
    }

    /**
     * 
     * @return
     *     The password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password
     *     The password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
