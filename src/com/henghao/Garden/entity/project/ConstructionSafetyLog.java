package com.henghao.Garden.entity.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ConstructionSafetyLog entity.施工安全日志表实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "constructionSafetyLog", catalog = "garden")
public class ConstructionSafetyLog implements java.io.Serializable {

	private static final long serialVersionUID = -8970201119999094591L;
	// 表ID
	private Integer cid;
	// 日期
	private String dates;
	// 施工部位
	private String constructionSite;
	// 施工工序动态
	private String constructionDynamic;
	// 安全状况
	private String safetySituation;
	// 安全问题的处理
	private String safetyProblems;
	// 填写人
	private String fillPeople;
	// 用户ID
	private String uid;
	// 项目编号
	private Integer pid;
	// 状态参数
	private Integer isNo;

	public ConstructionSafetyLog() {
		this.isNo = 0;
	}

	public ConstructionSafetyLog(String dates, String constructionSite,
			String constructionDynamic, String safetySituation,
			String safetyProblems, Integer pid, String fillPeople, String uid,
			Integer isNo) {
		super();
		this.dates = dates;
		this.constructionSite = constructionSite;
		this.constructionDynamic = constructionDynamic;
		this.safetySituation = safetySituation;
		this.safetyProblems = safetyProblems;
		this.fillPeople = fillPeople;
		this.uid = uid;
		this.pid = pid;
		this.isNo = isNo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid", unique = true, nullable = false)
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Column(name = "dates", length = 30, nullable = false)
	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	@Column(name = "constructionSite", length = 50, nullable = false)
	public String getConstructionSite() {
		return constructionSite;
	}

	public void setConstructionSite(String constructionSite) {
		this.constructionSite = constructionSite;
	}

	@Column(name = "constructionDynamic", length = 500, nullable = false)
	public String getConstructionDynamic() {
		return constructionDynamic;
	}

	public void setConstructionDynamic(String constructionDynamic) {
		this.constructionDynamic = constructionDynamic;
	}

	@Column(name = "safetySituation", length = 500, nullable = false)
	public String getSafetySituation() {
		return safetySituation;
	}

	public void setSafetySituation(String safetySituation) {
		this.safetySituation = safetySituation;
	}

	@Column(name = "safetyProblems", length = 300, nullable = false)
	public String getSafetyProblems() {
		return safetyProblems;
	}

	public void setSafetyProblems(String safetyProblems) {
		this.safetyProblems = safetyProblems;
	}

	@Column(name = "fillPeople", length = 15, nullable = false)
	public String getFillPeople() {
		return fillPeople;
	}

	public void setFillPeople(String fillPeople) {
		this.fillPeople = fillPeople;
	}

	@Column(name = "uid", nullable = false, length = 32)
	public String getUid() {
		return uid;
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
		return isNo;
	}

	public void setIsNo(Integer isNo) {
		this.isNo = isNo;
	}

}
