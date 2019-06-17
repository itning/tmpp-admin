package top.itning.tmpp.tmppadmin.pojo;

import java.util.Date;

public class AdminUserRoleResource extends AdminUserRoleResourceKey {
    private Date gmtCreate;

    private Date gmtModified;

    public AdminUserRoleResource(Integer userRoleId, String resourceId, Date gmtCreate, Date gmtModified) {
        super(userRoleId, resourceId);
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public AdminUserRoleResource() {
        super();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}