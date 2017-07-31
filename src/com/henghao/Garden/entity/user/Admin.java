package com.henghao.Garden.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Role entity.管理员表实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "admin", catalog = "garden")
public class Admin implements java.io.Serializable {

	private static final long serialVersionUID = 507877625130221781L;
	// 表ID
	private Integer aid;
	// 用户名
	private String userName;
	// 用户密码
	private String passWord;
	// 联系电话
	private String tel;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Integer aid, String userName, String tel) {
		super();
		this.aid = aid;
		this.userName = userName;
		this.tel = tel;
	}

	public Admin(Integer aid, String userName, String passWord, String tel) {
		super();
		this.aid = aid;
		this.userName = userName;
		this.passWord = passWord;
		this.tel = tel;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aid", unique = true, nullable = false)
	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	@Column(name = "userName", nullable = false, unique = true, length = 10)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "passWord", nullable = false, length = 50)
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Column(name = "tel", nullable = false, length = 20)
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
