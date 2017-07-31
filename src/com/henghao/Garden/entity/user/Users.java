package com.henghao.Garden.entity.user;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Users entity.用户表实体
 *
 * @author 严彬荣
 */
@Entity
@Table(name = "users", catalog = "garden")
public class Users implements java.io.Serializable {

    private static final long serialVersionUID = -7630658413532401374L;
    // 表ID
    private Integer id;
    // 用户ID
    private String uid;
    //权限表id
    private String roleId;
    // 密码
    private String password;
    // 联系电话
    private String tel;
    // 用户名
    private String username;
    // 联系人姓名
    private String contact;
    // 身份证号
    private String legalPersonIDcard;
    // 邮箱账号
    private String email;
    // 文件路径编号
    private String filesId;
    // 注册日期
    private String dates;
    //初始用户权限等级
    private int level;
    // 数据状态参数
    private int isNo;

    // 用户标签
    // private String label;

    // Constructors

    /**
     * default constructor
     */
    public Users() {
        this.dates = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date());
        this.isNo = 0;
        this.level = 1;
    }

    /**
     * full constructor
     */
    public Users(String uid, String password, String tel, String username,
    /* String label, */String contact, String legalPersonIDcard, String email,
                 String filesId, String dates) {
        super();
        this.uid = uid;
        this.password = password;
        this.tel = tel;
        this.username = username;
        // this.label = label;
        this.contact = contact;
        this.legalPersonIDcard = legalPersonIDcard;
        this.email = email;
        this.filesId = filesId;
        this.dates = dates;
    }

    // Property accessors

    public Users(String uid, String tel, String username) {
        super();
        this.uid = uid;
        this.tel = tel;
        this.username = username;
    }

    public Users(String uid, String tel, String contact,
                 String legalPersonIDcard) {
        super();
        this.uid = uid;
        this.tel = tel;
        this.contact = contact;
        this.legalPersonIDcard = legalPersonIDcard;
    }

    public Users(String uid) {
        super();
        this.uid = uid;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "uid", unique = true, nullable = false, length = 32)
    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "tel", nullable = false, length = 20)
    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Column(name = "username", nullable = false, length = 20)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "dates", length = 50)
    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    @Column(name = "contact", length = 20)
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Column(name = "legalPersonIDcard", length = 20)
    public String getLegalPersonIDcard() {
        return legalPersonIDcard;
    }

    public void setLegalPersonIDcard(String legalPersonIDcard) {
        this.legalPersonIDcard = legalPersonIDcard;
    }

    @Column(name = "email", length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "filesId", length = 32, unique = true, nullable = false)
    public String getFilesId() {
        return filesId;
    }

    public void setFilesId(String filesId) {
        this.filesId = filesId;
    }

    @Column(name = "roleId", length = 32, unique = true, nullable = false)
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Transient
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Column(name = "isNo", nullable = false)
    public int getIsNo() {
        return isNo;
    }

    public void setIsNo(int isNo) {
        this.isNo = isNo;
    }
/*
     * @Column(name = "label", length = 100, nullable = false) public String
	 * getLabel() { return label; }
	 * 
	 * public void setLabel(String label) { this.label = label; }
	 */

}