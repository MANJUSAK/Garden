package com.henghao.Garden.entity.fileMassage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Filemassage entity.文件保存路径信息表实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "filemassage", catalog = "garden")
public class Filemassage implements java.io.Serializable {

	private static final long serialVersionUID = -3743121156960394505L;
	// 表ID
	private Integer fid;
	// 路径
	private String path;
	// 图片路径编号
	private String Photofile;
	// 用户ID
	private String uid;
	// 数据状态信息（删除状态不让用户查看）
	private Integer isNo;

	// Constructors

	/** default constructor */
	public Filemassage() {
		this.isNo = 0;
	}

	/** full constructor */
	public Filemassage(String path, String uid, String Photofile, Integer isNo) {
		this.path = path;
		this.uid = uid;
		this.Photofile = Photofile;
		this.isNo = isNo;
	}

	public Filemassage(String path) {
		super();
		this.path = path;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fid", unique = true, nullable = false)
	public Integer getFid() {
		return this.fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	@Column(name = "path", length = 300)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name = "Photofile", length = 500)
	public String getPhotofile() {
		return Photofile;
	}

	public void setPhotofile(String photofile) {
		Photofile = photofile;
	}

	@Column(name = "uid")
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "isNo", length = 1)
	public Integer getIsNo() {
		return isNo;
	}

	public void setIsNo(Integer isNo) {
		this.isNo = isNo;
	}

}