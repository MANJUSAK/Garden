package com.henghao.Garden.entity.fileMassage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Excelmassage entity. 合同文件信息表实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "compactmassage", catalog = "garden")
public class Compactmassage implements java.io.Serializable {

	private static final long serialVersionUID = -7896941755538144105L;
	// 表ID
	private Integer cid;
	// 文件路径
	private String path;
	// 文件路径编号
	private String pathId;
	// 用户编号
	private String uid;
	// 数据状态信息（删除状态不让用户查看）
	private Integer isNo;

	// Constructors

	/** default constructor */
	public Compactmassage() {
		this.isNo = 0;
	}

	public Compactmassage(String path) {
		super();
		this.path = path;
	}

	/** full constructor */
	public Compactmassage(String path, String pathId, String uid, Integer isNo) {
		this.path = path;
		this.uid = uid;
		this.pathId = pathId;
		this.isNo = isNo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid", unique = true, nullable = false)
	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Column(name = "path", length = 300, nullable = false)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name = "uid", length = 32, nullable = false)
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "pathId", length = 32, nullable = false)
	public String getPathId() {
		return pathId;
	}

	public void setPathId(String pathId) {
		this.pathId = pathId;
	}

	@Column(name = "isNo")
	public Integer getIsNo() {
		return this.isNo;
	}

	public void setIsNo(Integer isNo) {
		this.isNo = isNo;
	}

}