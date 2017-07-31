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
 * Supplier entity. 供货商信息表
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "supplier", catalog = "garden")
public class Supplier implements java.io.Serializable {

	private static final long serialVersionUID = -1035936580408593542L;
	// 表ID
	private Integer sid;
	// 项目名称
	private String name;
	// 企业名称
	private String epName;
	// 企业地址
	private String epAdd;
	// 供货日期
	private String epDate;
	// 联系方式
	private String epTel;
	// 图片编号
	private String epCompactId;
	// 用户ID
	private String uid;
	// 项目编号
	private Integer pid;
	// 数据状态信息（删除状态不让用户查看）
	private Integer isNo;
	// 图片路径
	private List<Filemassage> url;

	// Constructors

	/** default constructor */
	public Supplier() {
		this.isNo = 0;
	}

	/** full constructor */
	public Supplier(Integer sid, String epName, String epAdd, String epDate,
			String epTel, String epCompactId, String uid, Integer pid,
			Integer isNo, String name) {
		super();
		this.sid = sid;
		this.epName = epName;
		this.epAdd = epAdd;
		this.epDate = epDate;
		this.epTel = epTel;
		this.epCompactId = epCompactId;
		this.uid = uid;
		this.pid = pid;
		this.isNo = isNo;
		this.name = name;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sid", unique = true, nullable = false)
	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@Column(name = "epName", length = 50, nullable = false)
	public String getEpName() {
		return this.epName;
	}

	public void setEpName(String epName) {
		this.epName = epName;
	}

	@Column(name = "epAdd", length = 150, nullable = false)
	public String getEpAdd() {
		return this.epAdd;
	}

	public void setEpAdd(String epAdd) {
		this.epAdd = epAdd;
	}

	@Column(name = "epTel", length = 15, nullable = false)
	public String getEpTel() {
		return this.epTel;
	}

	public void setEpTel(String epTel) {
		this.epTel = epTel;
	}

	@Column(name = "epDate", length = 30, nullable = false)
	public String getEpDate() {
		return epDate;
	}

	public void setEpDate(String epDate) {
		this.epDate = epDate;
	}

	@Column(name = "epCompactId", length = 32, unique = true, nullable = false)
	public String getEpCompactId() {
		return epCompactId;
	}

	public void setEpCompactId(String epCompactId) {
		this.epCompactId = epCompactId;
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