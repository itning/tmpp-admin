package top.itning.tmpp.tmppadmin.pojo;

import java.util.Date;

public class Department {
    private String id;

    private String name;

    private Date gmtModified;

    private Date gmtCreate;

    public Department(String id, String name, Date gmtModified, Date gmtCreate) {
        this.id = id;
        this.name = name;
        this.gmtModified = gmtModified;
        this.gmtCreate = gmtCreate;
    }

    public Department() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}