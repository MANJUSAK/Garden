package com.henghao.Garden.entity.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Mylocus entity. 我的轨迹表实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "my_locus", catalog = "garden")
public class Mylocus implements java.io.Serializable {

	private static final long serialVersionUID = 3669469456796529565L;
	// 表id
	private Integer mid;
	// 人员
	private String personnel;
	// 工作内容
	private String details;
	// 时间
	private String dates;
	// 工作类型
	private String workType;
	// 用户ID
	private String uid;
	// 数据状态信息（删除状态不让用户查看）
	private Integer isNo;

	// Constructors

	/** default constructor */
	public Mylocus() {
		this.isNo = 0;
	}

	public Mylocus(Integer mid, String personnel, String details, String dates,
			String workType, String uid, Integer isNo) {
		super();
		this.mid = mid;
		this.personnel = personnel;
		this.details = details;
		this.dates = dates;
		this.workType = workType;
		this.uid = uid;
		this.isNo = isNo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mid", unique = true, nullable = false)
	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	@Column(name = "personnel", length = 50, nullable = false)
	public String getPersonnel() {
		return personnel;
	}

	public void setPersonnel(String personnel) {
		this.personnel = personnel;
	}

	@Column(name = "details", length = 300, nullable = false)
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Column(name = "dates", length = 50, nullable = false)
	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	@Column(name = "workType", length = 20, nullable = false)
	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	@Column(name = "uid", nullable = false, length = 32)
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "isNo", length = 1, nullable = false)
	public Integer getIsNo() {
		return this.isNo;
	}

	public void setIsNo(Integer isNo) {
		this.isNo = isNo;
	}

}