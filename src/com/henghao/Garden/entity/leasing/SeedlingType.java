package com.henghao.Garden.entity.leasing;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SeedlingType entity. 苗木种类表实体
 * 
 * @author 严彬荣
 */

@Entity
@Table(name = "seedlingType", catalog = "garden")
public class SeedlingType implements java.io.Serializable {

	private static final long serialVersionUID = -5354621858520960649L;
	// 表ID
	private Integer sid;
	// 苗木种类
	private String type;
	// 苗木子种类
	private String subclass;

	public SeedlingType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SeedlingType(Integer sid, String type, String subclass) {
		super();
		this.sid = sid;
		this.type = type;
		this.subclass = subclass;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sid", unique = true, nullable = false)
	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@Column(name = "type", length = 10)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "subclass", length = 10)
	public String getSubclass() {
		return subclass;
	}

	public void setSubclass(String subclass) {
		this.subclass = subclass;
	}

}
