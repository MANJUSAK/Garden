package com.henghao.Garden.entity.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * ConstructionLog entity.施工日志表实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "constructionLog", catalog = "garden")
public class ConstructionLog implements java.io.Serializable {

	private static final long serialVersionUID = -3320180022629079480L;
	// 表ID
	private Integer cid;
	// 项目名称
	private String name;
	// 施工日期
	private String dates;
	// 生产活动内容
	private String proactContent;
	// 技术安全技术指标
	private String technicalIndex;
	// 施工员
	private String builder;
	// 工程项目负责人
	private String principal;
	// 完成工作情况
	private String workingCondition;
	// 用户编号
	private String uid;
	// 项目编号
	private Integer pid;
	// 状态数据（删除状态不给用户查看）
	private Integer isNo;

	// Constructors

	/** default constructor */
	public ConstructionLog() {
		this.isNo = 0;
	}

	/** full constructor */
	public ConstructionLog(Integer cid, String name, String dates,
			String proactContent, String technicalIndex, String builder,
			String principal, String workingCondition, String uid, Integer pid,
			Integer isNo) {
		super();
		this.cid = cid;
		this.name = name;
		this.dates = dates;
		this.proactContent = proactContent;
		this.technicalIndex = technicalIndex;
		this.builder = builder;
		this.principal = principal;
		this.workingCondition = workingCondition;
		this.uid = uid;
		this.pid = pid;
		this.isNo = isNo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid", unique = true, nullable = false)
	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Column(name = "dates", length = 50, nullable = false)
	public String getDates() {
		return this.dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	@Column(name = "proactContent", length = 500, nullable = false)
	public String getProactContent() {
		return proactContent;
	}

	public void setProactContent(String proactContent) {
		this.proactContent = proactContent;
	}

	@Column(name = "technicalIndex", length = 500, nullable = false)
	public String getTechnicalIndex() {
		return technicalIndex;
	}

	public void setTechnicalIndex(String technicalIndex) {
		this.technicalIndex = technicalIndex;
	}

	@Column(name = "principal", length = 10, nullable = false)
	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	@Column(name = "workingCondition", length = 500, nullable = false)
	public String getWorkingCondition() {
		return workingCondition;
	}

	public void setWorkingCondition(String workingCondition) {
		this.workingCondition = workingCondition;
	}

	@Column(name = "builder", length = 15, nullable = false)
	public String getBuilder() {
		return this.builder;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
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