package com.henghao.Garden.entity.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * KgReport entity. 开工报告实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "kg_report", catalog = "garden")
public class KgReport implements java.io.Serializable {

	private static final long serialVersionUID = 6321436309644438535L;
	// 表ID
	private Integer kid;
	// 项目名称
	private String name;
	// 开工日期
	private String kgTime;
	// 确认文件
	private String kgDocument;
	// 用户ID
	private String uid;
	// 项目编号
	private Integer pid;
	// 数据状态信息（删除状态不让用户查看）
	private Integer isNo;

	// Constructors

	/** default constructor */
	public KgReport() {
		this.isNo = 0;
	}

	/** full constructor */
	public KgReport(Integer kid, String name, String kgTime, String kgDocument,
			String uid, Integer pid, Integer isNo) {
		super();
		this.kid = kid;
		this.name = name;
		this.kgTime = kgTime;
		this.kgDocument = kgDocument;
		this.uid = uid;
		this.pid = pid;
		this.isNo = isNo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kid", unique = true, nullable = false)
	public Integer getKid() {
		return this.kid;
	}

	public void setKid(Integer kid) {
		this.kid = kid;
	}

	@Column(name = "kgTime", length = 50, nullable = false)
	public String getKgTime() {
		return this.kgTime;
	}

	public void setKgTime(String kgTime) {
		this.kgTime = kgTime;
	}

	@Column(name = "kgDocument", length = 100, nullable = false)
	public String getKgDocument() {
		return this.kgDocument;
	}

	public void setKgDocument(String kgDocument) {
		this.kgDocument = kgDocument;
	}

	@Column(name = "uid", nullable = false, length = 32)
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "pid", nullable = false)
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Column(name = "isNo", nullable = false)
	public Integer getIsNo() {
		return this.isNo;
	}

	public void setIsNo(Integer isNo) {
		this.isNo = isNo;
	}

	@Transient
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}