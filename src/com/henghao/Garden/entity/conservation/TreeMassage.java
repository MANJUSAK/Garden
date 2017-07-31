package com.henghao.Garden.entity.conservation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TreeMassage entity. 植物信息表实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "tree_massage", catalog = "garden")
public class TreeMassage implements java.io.Serializable {

	private static final long serialVersionUID = 2158623398681575996L;
	// 植物编号
	private String treeId;
	// 植物名称
	private String treeName;
	// 植物用途
	private String treeUse;
	// 植物规格
	private String treeSpecification;
	// 种植地点
	private String treeSite;
	// 录入时间
	private String treeTime;
	// 迁移时间
	private String treeMigratetime;
	// 迁移地点
	private String migratesite;
	// 迁移说明
	private String migratedetaile;

	// Constructors

	/** default constructor */
	public TreeMassage() {
	}

	/** minimal constructor */
	public TreeMassage(String treeId) {
		this.treeId = treeId;
	}

	/** full constructor */
	public TreeMassage(String treeId, String treeName, String treeUse,
			String treeSpecification, String treeSite, String treeTime,
			String treeMigratetime, String migratesite, String migratedetaile) {
		this.treeId = treeId;
		this.treeName = treeName;
		this.treeUse = treeUse;
		this.treeSpecification = treeSpecification;
		this.treeSite = treeSite;
		this.treeTime = treeTime;
		this.treeMigratetime = treeMigratetime;
		this.migratesite = migratesite;
		this.migratedetaile = migratedetaile;
	}

	// Property accessors
	@Id
	@Column(name = "treeId", unique = true, nullable = false, length = 32)
	public String getTreeId() {
		return this.treeId;
	}

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	@Column(name = "treeName", nullable=false,length = 50)
	public String getTreeName() {
		return this.treeName;
	}

	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}

	@Column(name = "treeUse", nullable=false,length = 50)
	public String getTreeUse() {
		return this.treeUse;
	}

	public void setTreeUse(String treeUse) {
		this.treeUse = treeUse;
	}

	@Column(name = "treeSpecification", length = 1000)
	public String getTreeSpecification() {
		return this.treeSpecification;
	}

	public void setTreeSpecification(String treeSpecification) {
		this.treeSpecification = treeSpecification;
	}

	@Column(name = "treeSite",nullable=false, length = 150)
	public String getTreeSite() {
		return this.treeSite;
	}

	public void setTreeSite(String treeSite) {
		this.treeSite = treeSite;
	}

	@Column(name = "treeTime",nullable=false, length = 50)
	public String getTreeTime() {
		return this.treeTime;
	}

	public void setTreeTime(String treeTime) {
		this.treeTime = treeTime;
	}

	@Column(name = "treeMigratetime", length = 50)
	public String getTreeMigratetime() {
		return this.treeMigratetime;
	}

	public void setTreeMigratetime(String treeMigratetime) {
		this.treeMigratetime = treeMigratetime;
	}

	@Column(name = "migratesite", length = 150)
	public String getMigratesite() {
		return this.migratesite;
	}

	public void setMigratesite(String migratesite) {
		this.migratesite = migratesite;
	}

	@Column(name = "migratedetaile", length = 1000)
	public String getMigratedetaile() {
		return this.migratedetaile;
	}

	public void setMigratedetaile(String migratedetaile) {
		this.migratedetaile = migratedetaile;
	}

}