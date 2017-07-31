package com.henghao.Garden.entity.project;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.henghao.Garden.entity.fileMassage.Filemassage;

/**
 * Alteration entity. 变更管理表实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "alteration", catalog = "garden")
public class Alteration implements java.io.Serializable {

	private static final long serialVersionUID = 2490755206245864043L;
	// 表ID
	private Integer aid;
	// 项目名称
	private String name;
	// 确认方
	private String confirmingParty;
	// 变更时间
	private String times;
	// 变更依据图片路径编号
	private String files;
	// 用户ID
	private String uid;
	// 项目信息编号
	private Integer pid;
	// 数据状态信息（删除状态不让用户查看）
	private Integer isNo;
	// 图片路径
	private List<Filemassage> url;

	// Constructors

	/** default constructor */
	public Alteration() {
		this.isNo = 0;
	}

	/** full constructor */
	public Alteration(Integer aid, String name, String confirmingParty,
			String times, String files, String uid, Integer pid, Integer isNo) {
		super();
		this.aid = aid;
		this.name = name;
		this.confirmingParty = confirmingParty;
		this.times = times;
		this.files = files;
		this.uid = uid;
		this.pid = pid;
		this.isNo = isNo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aid", unique = true, nullable = false)
	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	@Column(name = "times", length = 30, nullable = false)
	public String getTimes() {
		return this.times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	@Column(name = "confirmingParty", length = 50, nullable = false)
	public String getConfirmingParty() {
		return confirmingParty;
	}

	public void setConfirmingParty(String confirmingParty) {
		this.confirmingParty = confirmingParty;
	}

	@Column(name = "files", length = 32, unique = true, nullable = false)
	public String getFiles() {
		return this.files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	@Column(name = "isNo", nullable = false)
	public Integer getIsNo() {
		return this.isNo;
	}

	public void setIsNo(Integer isNo) {
		this.isNo = isNo;
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

	@Transient
	public List<Filemassage> getUrl() {
		return url;
	}

	public void setUrl(List<Filemassage> url) {
		this.url = url;
	}

	@Transient
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}