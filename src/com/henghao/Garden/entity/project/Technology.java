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
 * Technology entity. 技术交底表实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "technology", catalog = "garden")
public class Technology implements java.io.Serializable {

	private static final long serialVersionUID = -4699833985682258813L;
	// 表ID
	private Integer tid;
	// 项目名称
	private String name;
	// 时间
	private String dates;
	// 地点
	private String sites;
	// 内容
	private String content;
	// 现场情况图片编号
	private String photoId;
	// 用户ID
	private String uid;
	// 项目编号
	private Integer pid;
	// 数据状态信息（删除状态不让用户查看）
	private Integer isNo;
	// 图片路径
	private List<Filemassage> url;

	public Technology() {
		this.isNo = 0;
	}

	public Technology(Integer tid, String dates, String sites, String content,
			String photoId, String uid, Integer pid, Integer isNo, String name) {
		super();
		this.tid = tid;
		this.dates = dates;
		this.sites = sites;
		this.content = content;
		this.photoId = photoId;
		this.uid = uid;
		this.pid = pid;
		this.isNo = isNo;
		this.name = name;
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

	@Column(name = "dates", length = 30, nullable = false)
	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	@Column(name = "sites", length = 150, nullable = false)
	public String getSites() {
		return sites;
	}

	public void setSites(String sites) {
		this.sites = sites;
	}

	@Column(name = "content", length = 1000, nullable = false)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "photoId", length = 32, unique = true, nullable = false)
	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
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

	@Column(name = "isNo", length = 1, nullable = false)
	public Integer getIsNo() {
		return isNo;
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
