package com.henghao.Garden.entity.leasing;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;
import javax.persistence.Id;
import javax.persistence.Table;

import com.henghao.Garden.entity.fileMassage.Filemassage;

/**
 * Equipmentleasing entity. 设备租赁信息表实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "equipmentleasing", catalog = "garden")
public class Equipmentleasing implements java.io.Serializable {

	private static final long serialVersionUID = -1074379682060336770L;
	// 表ID
	private Integer eid;
	// 标题名称
	private String titleName;
	// 内容
	private String content;
	// 发布时间
	private String dates;
	// 联系人
	private String contacts;
	// 联系电话
	private String tel;
	// 图片文件编号
	private String filesId;
	// 用户编号
	private String uid;
	// 状态参数
	private Integer isNo;
	// 文件路径
	private List<Filemassage> url;

	// Constructors

	/** default constructor */
	public Equipmentleasing() {
		this.isNo = 0;
		this.dates = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date());
	}

	/** full constructor */
	public Equipmentleasing(String contacts, String content, String dates,
			String filesId, Integer isNo, String tel, String titleName,
			String uid) {
		this.contacts = contacts;
		this.content = content;
		this.dates = dates;
		this.filesId = filesId;
		this.isNo = isNo;
		this.tel = tel;
		this.titleName = titleName;
		this.uid = uid;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eid", unique = true, nullable = false)
	public Integer getEid() {
		return this.eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	@Column(name = "contacts", length = 15, nullable = false)
	public String getContacts() {
		return this.contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	@Column(name = "content", length = 1000, nullable = false)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "dates", length = 50, nullable = false)
	public String getDates() {
		return this.dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	@Column(name = "filesId", length = 32, nullable = false)
	public String getFilesId() {
		return this.filesId;
	}

	public void setFilesId(String filesId) {
		this.filesId = filesId;
	}

	@Column(name = "isNo", nullable = false)
	public Integer getIsNo() {
		return this.isNo;
	}

	public void setIsNo(Integer isNo) {
		this.isNo = isNo;
	}

	@Column(name = "tel", length = 15, nullable = false)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "titleName", length = 50, nullable = false)
	public String getTitleName() {
		return this.titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	@Column(name = "uid", nullable = false)
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Transient
	public List<Filemassage> getUrl() {
		return url;
	}

	public void setUrl(List<Filemassage> url) {
		this.url = url;
	}

}