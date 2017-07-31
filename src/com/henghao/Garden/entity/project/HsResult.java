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
 * HsResult entity. 会审结果表实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "hs_result", catalog = "garden")
public class HsResult implements java.io.Serializable {

	private static final long serialVersionUID = -5830521831149583412L;
	// 表id
	private Integer hid;
	// 项目名称
	private String name;
	// 会审单位
	private String hsDeparment;
	// 会审图片编号
	private String hsImgId;
	// 用户id
	private String uid;
	// 项目编号
	private Integer pid;
	// 数据状态信息（删除状态不让用户查看）
	private Integer isNo;
	// 图片路径
	private List<Filemassage> url;

	// Constructors

	/** default constructor */
	public HsResult() {
		this.isNo = 0;
	}

	/** full constructor */
	public HsResult(Integer hid, String name, String hsDeparment,
			String hsImgId, String uid, Integer pid, Integer isNo) {
		this.hid = hid;
		this.name = name;
		this.hsDeparment = hsDeparment;
		this.hsImgId = hsImgId;
		this.uid = uid;
		this.pid = pid;
		this.isNo = isNo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hid", unique = true, nullable = false)
	public Integer getHid() {
		return this.hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	@Column(name = "hsDeparment", length = 150, nullable = false)
	public String getHsDeparment() {
		return this.hsDeparment;
	}

	public void setHsDeparment(String hsDeparment) {
		this.hsDeparment = hsDeparment;
	}

	@Column(name = "hsImgId", length = 32, unique = true, nullable = false)
	public String getHsImgId() {
		return this.hsImgId;
	}

	public void setHsImgId(String hsImgId) {
		this.hsImgId = hsImgId;
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