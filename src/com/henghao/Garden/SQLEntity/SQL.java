package com.henghao.Garden.SQLEntity;

/**
 * function 数据库操作项目管理sql语句辅助类
 * 
 * @author 严彬荣
 */
public class SQL {

	// 定义保存植物信息sql
	private String saveTreeMsgSql = "insert into tree_massage(treeId,treeName,treeUse,treeSpecification,treeSite,treeTime,treeMigratetime,migratesite,migratedetaile) values(?,?,?,?,?,?,?,?,?)";
	// 获取当天已扫过的植物信息sql
	private String queryNowTreeSql = "from YhStatus where treeId=? and yhStatustime like ?";
	// 保存文件信息数据sql
	private String saveFileSql = "insert into filemassage(path,uid,Photofile,isNo) values(?,?,?,?)";
	// 用户文件信息保存sql
	private String saveUserFileSql = "insert into userFile(path,fileId) values (?,?)";
	// 抓取招标信息数据sql
	private String saveBidMsgSql = "insert into bid(titleName,content,contacts,tel,dates,uid) values (?,?,?,?,?,?)";
	// 施工安全日志概要信息sql
	private String summaryOfConstructionLogSql = "select a.name,a.startTime,a.completionTime,a.constructionUnit,b.* from  (select pid,isNo,xm_name name,startTime,completionTime,constructionUnit from project) a left join constructionSafetyLog b on a.pid=b.pid where b.cid is not null  and b.uid=:uid and b.isNo=0 order by b.cid desc";
	// 结算信息sql
	private String settlementSql = "select b.xm_name name,a.* from settlement a left join project b on a.pid=b.pid where a.uid=:uid and a.isNo=0 order by sid desc";
	// 变更管理sql
	private String alterationSql = "select b.xm_name name,a.* from alteration a left join project b on a.pid=b.pid where a.uid=:uid and a.isNo=0 order by aid desc";
	// 施工日志sql
	private String constructionLogSql = "select b.xm_name name,a.* from constructionLog a left join project b on a.pid=b.pid where a.uid=:uid and a.isNo=0 order by cid desc";
	// 申报进度sql
	private String declarationSql = "select b.xm_name name,a.* from declaration a left join project b on a.pid=b.pid where a.uid=:uid and a.isNo=0 order by did desc";
	// 设备信息sql
	private String equipmentSql = "select b.xm_name name,a.* from equipment a left join project b on a.pid=b.pid where a.uid=:uid and a.isNo=0 order by eid desc";
	// 会审结果sql
	private String hsResultSql = "select b.xm_name name,a.* from hs_result a left join project b on a.pid=b.pid where a.uid=:uid and a.isNo=0 order by hid desc";
	// 施工人员sql
	private String sgPersonnelSql = "select b.xm_name name,a.* from sg_personnel a left join project b on a.pid=b.pid where a.uid=:uid and a.isNo=0 order by sid desc";
	// 供货商信息sql
	private String supplierSql = "select b.xm_name name,a.* from supplier a left join project b on a.pid=b.pid where a.uid=:uid and a.isNo=0 order by sid desc";
	// 技术交底sql
	private String technologySql = "select b.xm_name name,a.* from technology a left join project b on a.pid=b.pid where a.uid=:uid and a.isNo=0 order by tid desc";
	// 竣工验收sql
	private String finalacceptanceSql = "select b.xm_name name,a.* from finalacceptance a left join project b on a.pid=b.pid where a.uid=:uid and a.isNo=0 order by fid desc";
	// 开工报告sql
	private String kgReportSql = "select b.xm_name name,a.* from kg_report a left join project b on a.pid=b.pid where a.uid=:uid and a.isNo=0 order by kid desc";
	// 现场施工检验sql
	private String prospectSql = "select b.xm_name name,a.* from prospect a left join project b on a.pid=b.pid where a.uid=:uid and a.isNo=0 order by ppid desc";

	public String getSaveTreeMsgSql() {
		return saveTreeMsgSql;
	}

	public void setSaveTreeMsgSql(String saveTreeMsgSql) {
		this.saveTreeMsgSql = saveTreeMsgSql;
	}

	public String getQueryNowTreeSql() {
		return queryNowTreeSql;
	}

	public void setQueryNowTreeSql(String queryNowTreeSql) {
		this.queryNowTreeSql = queryNowTreeSql;
	}

	public String getSaveFileSql() {
		return saveFileSql;
	}

	public void setSaveFileSql(String saveFileSql) {
		this.saveFileSql = saveFileSql;
	}

	public String getSaveBidMsgSql() {
		return saveBidMsgSql;
	}

	public void setSaveBidMsgSql(String saveBidMsgSql) {
		this.saveBidMsgSql = saveBidMsgSql;
	}

	public String getSummaryOfConstructionLogSql() {
		return summaryOfConstructionLogSql;
	}

	public void setSummaryOfConstructionLogSql(
			String summaryOfConstructionLogSql) {
		this.summaryOfConstructionLogSql = summaryOfConstructionLogSql;
	}

	public String getSettlementSql() {
		return settlementSql;
	}

	public void setSettlementSql(String settlementSql) {
		this.settlementSql = settlementSql;
	}

	public String getAlterationSql() {
		return alterationSql;
	}

	public void setAlterationSql(String alterationSql) {
		this.alterationSql = alterationSql;
	}

	public String getConstructionLogSql() {
		return constructionLogSql;
	}

	public void setConstructionLogSql(String constructionLogSql) {
		this.constructionLogSql = constructionLogSql;
	}

	public String getDeclarationSql() {
		return declarationSql;
	}

	public void setDeclarationSql(String declarationSql) {
		this.declarationSql = declarationSql;
	}

	public String getEquipmentSql() {
		return equipmentSql;
	}

	public void setEquipmentSql(String equipmentSql) {
		this.equipmentSql = equipmentSql;
	}

	public String getHsResultSql() {
		return hsResultSql;
	}

	public void setHsResultSql(String hsResultSql) {
		this.hsResultSql = hsResultSql;
	}

	public String getSgPersonnelSql() {
		return sgPersonnelSql;
	}

	public void setSgPersonnelSql(String sgPersonnelSql) {
		this.sgPersonnelSql = sgPersonnelSql;
	}

	public String getSupplierSql() {
		return supplierSql;
	}

	public void setSupplierSql(String supplierSql) {
		this.supplierSql = supplierSql;
	}

	public String getTechnologySql() {
		return technologySql;
	}

	public void setTechnologySql(String technologySql) {
		this.technologySql = technologySql;
	}

	public String getFinalacceptanceSql() {
		return finalacceptanceSql;
	}

	public void setFinalacceptanceSql(String finalacceptanceSql) {
		this.finalacceptanceSql = finalacceptanceSql;
	}

	public String getKgReportSql() {
		return kgReportSql;
	}

	public void setKgReportSql(String kgReportSql) {
		this.kgReportSql = kgReportSql;
	}

	public String getProspectSql() {
		return prospectSql;
	}

	public void setProspectSql(String prospectSql) {
		this.prospectSql = prospectSql;
	}

	public String getSaveUserFileSql() {
		return saveUserFileSql;
	}

	public void setSaveUserFileSql(String saveUserFileSql) {
		this.saveUserFileSql = saveUserFileSql;
	}

}
