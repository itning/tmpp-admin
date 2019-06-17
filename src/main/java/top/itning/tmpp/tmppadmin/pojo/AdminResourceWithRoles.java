package top.itning.tmpp.tmppadmin.pojo;

import java.util.Date;
import java.util.List;

/**
 * @author itning
 * @date 2019/6/17 16:26
 */
public class AdminResourceWithRoles {
    private String id;

    private String url;

    private String method;

    private List<AdminUserRole> roles;

    private Date gmtCreate;

    private Date gmtModified;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<AdminUserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<AdminUserRole> roles) {
        this.roles = roles;
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
