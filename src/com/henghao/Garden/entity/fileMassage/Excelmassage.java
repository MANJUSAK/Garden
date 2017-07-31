package com.henghao.Garden.entity.fileMassage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Excelmassage entity. Excel文件信息表实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "excelmassage", catalog = "garden")
public class Excelmassage implements java.io.Serializable {

	private static final long serialVersionUID = -7896941755538144105L;
	// 表ID
	private Integer eid;
	// 文件路径
	private String path;
	// 用户编号
	private String uid;
	// 数据状态信息（删除状态不让用户查看）
	private Integer isNo;

	// Constructors

	/** default constructor */
	public Excelmassage() {
		this.isNo = 0;
	}

	/** full constructor */
	public Excelmassage(String path, String uid, Integer isNo) {
		this.path = path;
		this.uid = uid;
		this.isNo = isNo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eid", unique = true, nullable = false)
	public Integer getEid() {
		return this.eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	@Column(name = "path", length = 150)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name = "uid")
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "is_no")
	public Integer getIsNo() {
		return this.isNo;
	}

	public void setIsNo(Integer isNo) {
		this.isNo = isNo;
	}

}