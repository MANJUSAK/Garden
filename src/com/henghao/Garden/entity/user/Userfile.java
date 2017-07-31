package com.henghao.Garden.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Userfile entity.用户文件实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "userFile", catalog = "garden")
public class Userfile implements java.io.Serializable {

	private static final long serialVersionUID = -6703662878409307566L;
	// 表ID
	private Integer uid;
	// 路径
	private String path;
	// 路径编号
	private String fileId;

	// Constructors

	/** default constructor */
	public Userfile() {
	}

	/** full constructor */
	public Userfile(String path, String fileId) {
		this.path = path;
		this.fileId = fileId;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uid", unique = true, nullable = false)
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Column(name = "path", length = 150, nullable = false)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name = "fileId", length = 32, nullable = false)
	public String getFileId() {
		return this.fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

}