package com.henghao.Garden.entity.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Equipment entity.设备信息数据表实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "equipment", catalog = "garden")
public class Equipment implements java.io.Serializable {

	private static final long serialVersionUID = -3989708005059727145L;
	// 表id
	private Integer eid;
	// 项目名称
	private String name;
	// 设备名称
	private String sbName;
	// 设备型号
	private String sbSpec;
	// 设备数量
	private Integer sbNum;
	// 设备用途
	private String sbPurpose;
	// 设备来源
	private String sbSource;
	// 用户id
	private String uid;
	// 项目编号
	private Integer pid;
	// 数据状态信息（删除状态不让用户查看）
	private Integer isNo;

	// Constructors

	/** default constructor */
	public Equipment() {
		this.isNo = 0;
	}

	/** full constructor */
	public Equipment(Integer eid, String name, String sbName, String sbSpec,
			Integer sbNum, String sbPurpose, String sbSource, String uid,
			Integer pid, Integer isNo) {
		super();
		this.eid = eid;
		this.name = name;
		this.sbName = sbName;
		this.sbSpec = sbSpec;
		this.sbNum = sbNum;
		this.sbPurpose = sbPurpose;
		this.sbSource = sbSource;
		this.uid = uid;
		this.pid = pid;
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

	@Column(name = "sbName", length = 50, nullable = false)
	public String getSbName() {
		return this.sbName;
	}

	public void setSbName(String sbName) {
		this.sbName = sbName;
	}

	@Column(name = "sbSpec", length = 300, nullable = false)
	public String getSbSpec() {
		return this.sbSpec;
	}

	public void setSbSpec(String sbSpec) {
		this.sbSpec = sbSpec;
	}

	@Column(name = "sbNum", nullable = false)
	public Integer getSbNum() {
		return this.sbNum;
	}

	public void setSbNum(Integer sbNum) {
		this.sbNum = sbNum;
	}

	@Column(name = "sbPurpose", length = 50, nullable = false)
	public String getSbPurpose() {
		return this.sbPurpose;
	}

	public void setSbPurpose(String sbPurpose) {
		this.sbPurpose = sbPurpose;
	}

	@Column(name = "sbSource", length = 50, nullable = false)
	public String getSbSource() {
		return this.sbSource;
	}

	public void setSbSource(String sbSource) {
		this.sbSource = sbSource;
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