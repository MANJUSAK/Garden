package com.henghao.Garden.entityvo;

/**
 * Equipment entity.施工安全日志概要信息实体
 * 
 * @author 严彬荣
 */
public class ConstructionSafetyLogVo {

	// 项目编号
	private Integer pid;
	// 用户ID
	private String uid;
	// 表ID
	private Integer cid;
	// 项目名称
	private String name;
	// 开工时间
	private String startTime;
	// 竣工时间
	private String completionTime;
	// 施工单位
	private String constructionUnit;
	// 施工安全日志时间
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
	// 状态参数
	private Integer isNo;

	public Integer getPid() {
		return pid;
	}

	public ConstructionSafetyLogVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConstructionSafetyLogVo(Integer pid, String uid, Integer cid,
			String name, String startTime, String completionTime,
			String constructionUnit, String dates, String constructionSite,
			String constructionDynamic, String safetySituation,
			String safetyProblems, String fillPeople, Integer isNo) {
		super();
		this.pid = pid;
		this.uid = uid;
		this.cid = cid;
		this.name = name;
		this.startTime = startTime;
		this.completionTime = completionTime;
		this.constructionUnit = constructionUnit;
		this.dates = dates;
		this.constructionSite = constructionSite;
		this.constructionDynamic = constructionDynamic;
		this.safetySituation = safetySituation;
		this.safetyProblems = safetyProblems;
		this.fillPeople = fillPeople;
		this.isNo = isNo;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(String completionTime) {
		this.completionTime = completionTime;
	}

	public String getConstructionSite() {
		return constructionSite;
	}

	public void setConstructionSite(String constructionSite) {
		this.constructionSite = constructionSite;
	}

	public String getConstructionDynamic() {
		return constructionDynamic;
	}

	public void setConstructionDynamic(String constructionDynamic) {
		this.constructionDynamic = constructionDynamic;
	}

	public String getSafetySituation() {
		return safetySituation;
	}

	public void setSafetySituation(String safetySituation) {
		this.safetySituation = safetySituation;
	}

	public String getSafetyProblems() {
		return safetyProblems;
	}

	public void setSafetyProblems(String safetyProblems) {
		this.safetyProblems = safetyProblems;
	}

	public String getFillPeople() {
		return fillPeople;
	}

	public void setFillPeople(String fillPeople) {
		this.fillPeople = fillPeople;
	}

	public String getConstructionUnit() {
		return constructionUnit;
	}

	public void setConstructionUnit(String constructionUnit) {
		this.constructionUnit = constructionUnit;
	}

	public Integer getIsNo() {
		return isNo;
	}

	public void setIsNo(Integer isNo) {
		this.isNo = isNo;
	}

}
