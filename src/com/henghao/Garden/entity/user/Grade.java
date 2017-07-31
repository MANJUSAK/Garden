package com.henghao.Garden.entity.user;

import javax.persistence.*;

/**
 * function 权限等级表
 * <p>
 * Created by 严彬荣 on 2017/7/25.
 */
@Entity
@Table(name = "grade", catalog = "garden")
public class Grade implements java.io.Serializable {
    private Integer gid;//表id
    private String levelId;//权限等级id
    private String roleId;//权限id
    private Integer level;//用户等级

    public Grade(String roleId) {
        this.roleId = roleId;
    }

    public Grade(Integer level) {
        this.level = level;
    }

    public Grade() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gid", nullable = false)
    public Integer getGid() {
        return gid;
    }


    public void setGid(Integer gid) {
        this.gid = gid;
    }

    @Column(name = "roleId", nullable = false, length = 32)
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Column(name = "level", nullable = false)
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Column(name = "levelId", nullable = false, length = 32)
    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }
}
