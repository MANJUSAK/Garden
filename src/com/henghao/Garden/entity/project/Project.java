package com.henghao.Garden.entity.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Project entity.项目信息报实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "project", catalog = "garden")
public class Project implements java.io.Serializable {

	private static final long serialVersionUID = -5754077182427409946L;
	// 表id
	private Integer pid;
	// 项目名称
	private String xmName;
	// 项目负责人
	private String xmPerson;
	// 联系方式
	private String xmContact;
	// 项目人数
	private Integer xmPersonNum;
	// 项目地点
	private String xmAdd;
	// 施工单位
	private String constructionUnit;
	// 开工时间
	private String startTime;
	// 竣工时间
	private String completionTime;
	// 用户ID
	private String uid;
	// 数据状态信息（删除状态不让用户查看）
	private Integer isNo;

	// Constructors

	/** default constructor */
	public Project() {
		this.isNo = 0;
	}

	/** full constructor */

	public Project(Integer pid, String xmName) {
		this.pid = pid;
		this.xmName = xmName;
	}

	public Project(Integer pid, String xmName, String xmPerson,
			String xmContact, Integer xmPersonNum, String xmAdd,
			String constructionUnit, String startTime, String completionTime,
			String uid, Integer isNo) {
		super();
		this.pid = pid;
		this.xmName = xmName;
		this.xmPerson = xmPerson;
		this.xmContact = xmContact;
		this.xmPersonNum = xmPersonNum;
		this.xmAdd = xmAdd;
		this.constructionUnit = constructionUnit;
		this.startTime = startTime;
		this.completionTime = completionTime;
		this.uid = uid;
		this.isNo = isNo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid", unique = true, nullable = false)
	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Column(name = "xm_name", length = 150, nullable = false)
	public String getXmName() {
		return this.xmName;
	}

	public void setXmName(String xmName) {
		this.xmName = xmName;
	}

	@Column(name = "xm_person", length = 30, nullable = false)
	public String getXmPerson() {
		return this.xmPerson;
	}

	public void setXmPerson(String xmPerson) {
		this.xmPerson = xmPerson;
	}

	@Column(name = "startTime", length = 30, nullable = false)
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@Column(name = "completionTime", length = 30, nullable = false)
	public String getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(String completionTime) {
		this.completionTime = completionTime;
	}

	@Column(name = "xm_contact", length = 15, nullable = false)
	public String getXmContact() {
		return this.xmContact;
	}

	public void setXmContact(String xmContact) {
		this.xmContact = xmContact;
	}

	@Column(name = "xm_personNum", nullable = false)
	public Integer getXmPersonNum() {
		return this.xmPersonNum;
	}

	public void setXmPersonNum(Integer xmPersonNum) {
		this.xmPersonNum = xmPersonNum;
	}

	@Column(name = "xm_add", length = 150, nullable = false)
	public String getXmAdd() {
		return this.xmAdd;
	}

	public void setXmAdd(String xmAdd) {
		this.xmAdd = xmAdd;
	}

	@Column(name = "constructionUnit", length = 50, nullable = false)
	public String getConstructionUnit() {
		return constructionUnit;
	}

	public void setConstructionUnit(String constructionUnit) {
		this.constructionUnit = constructionUnit;
	}

	@Column(name = "uid", nullable = false, length = 32)
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "isNo", nullable = false)
	public Integer getIsNo() {
		return this.isNo;
	}

	public void setIsNo(Integer isNo) {
		this.isNo = isNo;
	}

}