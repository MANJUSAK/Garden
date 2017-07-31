package com.henghao.Garden.entity.fileMassage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Talentpoolmassage entity.人才库文件保存路径信息表实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "talentpoolmassage", catalog = "garden")
public class Talentpoolmassage implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4528651329306759346L;
	// 表ID
	private Integer tid;
	// 路径
	private String path;
	// 图片路径编号
	private String fileId;
	// 数据状态信息（删除状态不让用户查看）
	private Integer isNo;

	// Constructors

	/** default constructor */
	public Talentpoolmassage() {
		this.isNo = 0;
	}

	public Talentpoolmassage(String path) {
		super();
		this.path = path;
	}

	/** full constructor */
	public Talentpoolmassage(String path, String fileId, Integer isNo) {
		this.path = path;
		this.fileId = fileId;
		this.isNo = isNo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tid", unique = true, nullable = false)
	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	@Column(name = "path", length = 300)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name = "fileId", length = 32)
	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	@Column(name = "isNo", length = 1)
	public Integer getIsNo() {
		return isNo;
	}

	public void setIsNo(Integer isNo) {
		this.isNo = isNo;
	}

}
