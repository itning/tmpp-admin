package top.itning.tmpp.tmppadmin.pojo;

import java.util.Date;

public class AdminUserRole {
    private Integer id;

    private String name;

    private Date gmtCreate;

    private Date gmtModified;

    private String type;

    public AdminUserRole(Integer id, String name, Date gmtCreate, Date gmtModified, String type) {
        this.id = id;
        this.name = name;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.type = type;
    }

    public AdminUserRole() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}