package top.itning.tmpp.tmppadmin.pojo;

import java.util.Date;

public class AdminUser {
    private String id;

    private String name;

    private String username;

    private String password;

    private String type;

    private Date gmtCreate;

    private Date gmtModified;

    public AdminUser(String id, String name, String username, String password, String type, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.type = type;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public AdminUser() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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