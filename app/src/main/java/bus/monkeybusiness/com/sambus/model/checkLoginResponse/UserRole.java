package bus.monkeybusiness.com.sambus.model.checkLoginResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRole {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("role_name")
    @Expose
    private String roleName;
    @SerializedName("role_alias")
    @Expose
    private String roleAlias;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

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
     * @return The roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName The role_name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * @return The roleAlias
     */
    public String getRoleAlias() {
        return roleAlias;
    }

    /**
     * @param roleAlias The role_alias
     */
    public void setRoleAlias(String roleAlias) {
        this.roleAlias = roleAlias;
    }

    /**
     * @return The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
