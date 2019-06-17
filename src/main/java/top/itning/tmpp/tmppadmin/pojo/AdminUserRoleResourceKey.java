package top.itning.tmpp.tmppadmin.pojo;

public class AdminUserRoleResourceKey {
    private Integer userRoleId;

    private String resourceId;

    public AdminUserRoleResourceKey(Integer userRoleId, String resourceId) {
        this.userRoleId = userRoleId;
        this.resourceId = resourceId;
    }

    public AdminUserRoleResourceKey() {
        super();
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId == null ? null : resourceId.trim();
    }
}