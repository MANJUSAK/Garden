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
 * Declaration entity.申报进度表实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "declaration", catalog = "garden")
public class Declaration implements java.io.Serializable {

	private static final long serialVersionUID = 21953202051955651L;
	// 表ID
	private Integer did;
	// 项目名称
	private String name;
	// 申报日期
	private String dates;
	// 申报图片编号
	private String filesId;
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
	public Declaration() {
		this.isNo = 0;
	}

	/** full constructor */
	public Declaration(Integer did, String name, String dates, String filesId,
			String uid, Integer pid, Integer isNo) {
		super();
		this.did = did;
		this.name = name;
		this.dates = dates;
		this.filesId = filesId;
		this.uid = uid;
		this.pid = pid;
		this.isNo = isNo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "did", unique = true, nullable = false)
	public Integer getDid() {
		return this.did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	@Column(name = "dates", length = 50, nullable = false)
	public String getDates() {
		return this.dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	@Column(name = "filesId", length = 300, unique = true, nullable = false)
	public String getFilesId() {
		return this.filesId;
	}

	public void setFilesId(String filesId) {
		this.filesId = filesId;
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