package com.henghao.Garden.entity.conservation;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

/**
 * YhStatus entity. 养护工作记录表实体
 * 
 * @author 严彬荣
 */
// 过滤hibernate转换json发生死循环
@JsonIgnoreType
@Entity
@Table(name = "yh_status", catalog = "garden")
public class YhStatus implements java.io.Serializable {

	private static final long serialVersionUID = -7995876625780547453L;
	// 表ID
	private Integer yid;
	// 植物编号
	private String treeId;
	// 养护行为
	private String yhStatusname;
	// 养护时间
	private String yhStatustime;
	// 养护地点
	private String yhStatussite;
	// 用户编号
	private String uid;
	// 管护信息状态
	private Integer isNo;
	private Set<GhManage> ghManages = new HashSet<GhManage>(0);

	// Constructors

	/** default constructor */
	public YhStatus() {
		this.isNo = 0;
	}

	/** full constructor */
	public YhStatus(String treeId, String yhStatusname, String yhStatustime,
			String yhStatussite, Integer isNo, Set<GhManage> ghManages) {
		this.treeId = treeId;
		this.yhStatusname = yhStatusname;
		this.yhStatustime = yhStatustime;
		this.yhStatussite = yhStatussite;
		this.isNo = isNo;
		this.ghManages = ghManages;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "yid", unique = true, nullable = false)
	public Integer getYid() {
		return this.yid;
	}

	public void setYid(Integer yid) {
		this.yid = yid;
	}

	@Column(name = "treeId", length = 50)
	public String getTreeId() {
		return this.treeId;
	}

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	@Column(name = "yhStatusname", length = 50)
	public String getYhStatusname() {
		return this.yhStatusname;
	}

	public void setYhStatusname(String yhStatusname) {
		this.yhStatusname = yhStatusname;
	}

	@Column(name = "yhStatustime", length = 50)
	public String getYhStatustime() {
		return this.yhStatustime;
	}

	public void setYhStatustime(String yhStatustime) {
		this.yhStatustime = yhStatustime;
	}

	@Column(name = "yhStatussite", length = 50)
	public String getYhStatussite() {
		return this.yhStatussite;
	}

	public void setYhStatussite(String yhStatussite) {
		this.yhStatussite = yhStatussite;
	}

	@Column(name = "uid", length = 50)
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "is_no")
	public Integer getIsNo() {
		return this.isNo;
	}

	public void setIsNo(Integer isNo) {
		this.isNo = isNo;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "yhStatus")
	public Set<GhManage> getGhManages() {
		return this.ghManages;
	}

	public void setGhManages(Set<GhManage> ghManages) {
		this.ghManages = ghManages;
	}

}