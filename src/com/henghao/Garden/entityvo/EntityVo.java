package com.henghao.Garden.entityvo;

//定义通过养护状态（二维码）查询植物信息实体类
public class EntityVo {
	// 植物编号
	private int id;
	// 植物名称
	private String treeName;
	// 种植地点
	private String treeSite;
	// 种植日期
	private String treeTime;
	// 植物二维码
	private String treeId;
	// 养护行为名称
	private String yhStatusName;
	// 养护时间
	private String yhStatusTime;
	// 养护地点
	private String yhStatusSite;
	// 植物用途
	private String treeuse;
	// 植物规格
	private String specification;
	// 迁移地点
	private String migrateSite;
	// 迁移说明
	private String migrateDetail;
	// 迁移时间
	private String migrateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTreeName() {
		return treeName;
	}

	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}

	public String getTreeSite() {
		return treeSite;
	}

	public void setTreeSite(String treeSite) {
		this.treeSite = treeSite;
	}

	public String getTreeTime() {
		return treeTime;
	}

	public void setTreeTime(String treeTime) {
		this.treeTime = treeTime;
	}

	public String getTreeId() {
		return treeId;
	}

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	public String getYhStatusName() {
		return yhStatusName;
	}

	public void setYhStatusName(String yhStatusName) {
		this.yhStatusName = yhStatusName;
	}

	public String getYhStatusTime() {
		return yhStatusTime;
	}

	public void setYhStatusTime(String yhStatusTime) {
		this.yhStatusTime = yhStatusTime;
	}

	public String getYhStatusSite() {
		return yhStatusSite;
	}

	public void setYhStatusSite(String yhStatusSite) {
		this.yhStatusSite = yhStatusSite;
	}

	public String getTreeuse() {
		return treeuse;
	}

	public void setTreeuse(String treeuse) {
		this.treeuse = treeuse;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getMigrateSite() {
		return migrateSite;
	}

	public void setMigrateSite(String migrateSite) {
		this.migrateSite = migrateSite;
	}

	public String getMigrateDetail() {
		return migrateDetail;
	}

	public void setMigrateDetail(String migrateDetail) {
		this.migrateDetail = migrateDetail;
	}

	public String getMigrateTime() {
		return migrateTime;
	}

	public void setMigrateTime(String migrateTime) {
		this.migrateTime = migrateTime;
	}

}
