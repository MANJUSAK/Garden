package com.henghao.Garden.entity.conservation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

/**
 * GhManage entity. 管护信息表实体
 * 
 * @author 严彬荣
 */
// 过滤hibernate转换json发生死循环
@JsonIgnoreType
@Entity
@Table(name = "gh_manage", catalog = "garden")
public class GhManage implements java.io.Serializable {

	private static final long serialVersionUID = 5866736487443844732L;
	// 表id
	private Integer gid;
	// 外键关联表实体
	private YhStatus yhStatus;
	// 植物编号
	private String treeId;
	// 养护地点
	private String yhSite;
	// 养护人员
	private String yhWorker;
	// 养护内容
	private String yhDetails;
	// 养护时间
	private String yhTime;
	// 问题发现
	private String yhQuestion;
	// 陆地保洁情况
	private String yhClean;
	// 植物长势
	private String treeGrowup;
	// 用户编号
	private String uid;
	// 备注
	private String yhComment;
	// 养护前照片路径
	private String oldfile;
	// 养护后照片路径
	private String nowfile;

	// Constructors

	/** default constructor */
	public GhManage() {
	}

	/** full constructor */
	public GhManage(YhStatus yhStatus, String treeId, String yhSite,
			String yhWorker, String yhDetails, String yhTime,
			String yhQuestion, String yhClean, String treeGrowup,
			String yhComment, String uid) {
		this.yhStatus = yhStatus;
		this.treeId = treeId;
		this.yhSite = yhSite;
		this.yhWorker = yhWorker;
		this.yhDetails = yhDetails;
		this.yhTime = yhTime;
		this.yhQuestion = yhQuestion;
		this.yhClean = yhClean;
		this.treeGrowup = treeGrowup;
		this.yhComment = yhComment;
		this.uid = uid;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gid", unique = true, nullable = false)
	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "yid")
	public YhStatus getYhStatus() {
		return this.yhStatus;
	}

	public void setYhStatus(YhStatus yhStatus) {
		this.yhStatus = yhStatus;
	}

	@Column(name = "treeId", length = 32)
	public String getTreeId() {
		return this.treeId;
	}

	public void setTreeId(String treeId) {
		this.treeId = treeId;
	}

	@Column(name = "yhSite", length = 150)
	public String getYhSite() {
		return this.yhSite;
	}

	public void setYhSite(String yhSite) {
		this.yhSite = yhSite;
	}

	@Column(name = "yhWorker", length = 20)
	public String getYhWorker() {
		return this.yhWorker;
	}

	public void setYhWorker(String yhWorker) {
		this.yhWorker = yhWorker;
	}

	@Column(name = "yhDetails", length = 300)
	public String getYhDetails() {
		return this.yhDetails;
	}

	public void setYhDetails(String yhDetails) {
		this.yhDetails = yhDetails;
	}

	@Column(name = "yhTime", length = 30)
	public String getYhTime() {
		return this.yhTime;
	}

	public void setYhTime(String yhTime) {
		this.yhTime = yhTime;
	}

	@Column(name = "yhQuestion", length = 10)
	public String getYhQuestion() {
		return this.yhQuestion;
	}

	public void setYhQuestion(String yhQuestion) {
		this.yhQuestion = yhQuestion;
	}

	@Column(name = "yhClean", length = 10)
	public String getYhClean() {
		return this.yhClean;
	}

	public void setYhClean(String yhClean) {
		this.yhClean = yhClean;
	}

	@Column(name = "treeGrowup", length = 10)
	public String getTreeGrowup() {
		return this.treeGrowup;
	}

	public void setTreeGrowup(String treeGrowup) {
		this.treeGrowup = treeGrowup;
	}

	@Column(name = "yhComment", length = 1000)
	public String getYhComment() {
		return this.yhComment;
	}

	public void setYhComment(String yhComment) {
		this.yhComment = yhComment;
	}

	@Column(name = "uid")
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "oldfile", length = 100)
	public String getOldfile() {
		return oldfile;
	}

	public void setOldfile(String oldfile) {
		this.oldfile = oldfile;
	}

	@Column(name = "nowfile", length = 100)
	public String getNowfile() {
		return nowfile;
	}

	public void setNowfile(String nowfile) {
		this.nowfile = nowfile;
	}

}