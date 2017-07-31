package com.henghao.Garden.entity.user;

import javax.persistence.*;

/**
 * function 权限表
 * <p>
 * Created by 严彬荣 on 2017/7/25.
 */
@Entity
@Table(name = "rights", catalog = "garden")
public class Rights implements java.io.Serializable {
    private Integer rid;//表id
    private String role;//角色
    private String roleId;//角色

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid", nullable = false)
    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }


    @Column(name = "roleId", nullable = false, length = 32)
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Column(name = "role", nullable = false)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
