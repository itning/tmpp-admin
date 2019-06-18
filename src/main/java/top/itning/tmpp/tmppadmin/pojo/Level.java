package top.itning.tmpp.tmppadmin.pojo;

import java.util.Date;

public class Level {
    private String id;

    private String educationalLevel;

    private Date gmtModified;

    private Date gmtCreate;

    public Level(String id, String educationalLevel, Date gmtModified, Date gmtCreate) {
        this.id = id;
        this.educationalLevel = educationalLevel;
        this.gmtModified = gmtModified;
        this.gmtCreate = gmtCreate;
    }

    public Level() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEducationalLevel() {
        return educationalLevel;
    }

    public void setEducationalLevel(String educationalLevel) {
        this.educationalLevel = educationalLevel == null ? null : educationalLevel.trim();
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