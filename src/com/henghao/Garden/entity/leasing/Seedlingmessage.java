package com.henghao.Garden.entity.leasing;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;

import com.henghao.Garden.entity.fileMassage.Filemassage;

/**
 * Seedlingmessage entity. 苗木信息表实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "seedlingmassage", catalog = "garden")
public class Seedlingmessage implements java.io.Serializable {

	private static final long serialVersionUID = 19819813558561927L;
	// 表ID
	private Integer sid;
	// 标题名称
	private String titleName;
	// 内容
	private String content;
	// 联系人
	private String contacts;
	// 联系电话
	private String tel;
	// 发布时间
	private String dates;
	// 供应商地址
	private String address;
	// 供应商
	private String supplier;
	// 苗木种类
	private String type;
	// 苗木子种类
	private String subclass;
	// 文件编号
	private String filesId;
	// 文件路径
	private List<Filemassage> url;
	// 用户编号
	private String uid;
	// 状态参数
	private Integer isNo;

	// Constructors

	/** default constructor */
	public Seedlingmessage() {
		this.isNo = 0;
		this.dates = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date());
	}

	/** full constructor */
	public Seedlingmessage(String address, String contacts, String content,
			String dates, String filesId, Integer isNo, String subclass,
			String supplier, String tel, String titleName, String type,
			String uid) {
		this.address = address;
		this.contacts = contacts;
		this.content = content;
		this.dates = dates;
		this.filesId = filesId;
		this.isNo = isNo;
		this.subclass = subclass;
		this.supplier = supplier;
		this.tel = tel;
		this.titleName = titleName;
		this.type = type;
		this.uid = uid;
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

	@Column(name = "address", length = 150, nullable = false)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	@Column(name = "subclass", length = 10)
	public String getSubclass() {
		return this.subclass;
	}

	public void setSubclass(String subclass) {
		this.subclass = subclass;
	}

	@Column(name = "supplier", length = 50, nullable = false)
	public String getSupplier() {
		return this.supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
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

	@Column(name = "type", length = 10, nullable = false)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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