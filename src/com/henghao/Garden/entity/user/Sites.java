package com.henghao.Garden.entity.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sites entity.签到表实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "sites", catalog = "garden")
public class Sites implements java.io.Serializable {

	private static final long serialVersionUID = -7832413509440034464L;
	// 表ID
	private Integer sid;
	// 关联用户时编号
	private String uid;
	// 备注
	private String comments;
	// 签到日期
	private String dates;
	// 经度
	private String longitude;
	// 地理位置
	private String site;
	// 纬度
	private String latitude;
	// 企业名称
	private String companyName;

	// Constructors

	/** default constructor */
	public Sites() {
		this.dates = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date());
		this.companyName = "恒昊慧筑大数据有限公司";
	}

	/** full constructor */
	public Sites(Integer sid, String uid, String comments, String dates,
			String longitude, String site, String latitude, String companyName) {
		super();
		this.sid = sid;
		this.uid = uid;
		this.comments = comments;
		this.dates = dates;
		this.longitude = longitude;
		this.site = site;
		this.latitude = latitude;
		this.companyName = companyName;
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

	@Column(name = "uid", length = 32, nullable = false)
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "comments", length = 150, nullable = false)
	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name = "dates", length = 50, nullable = false)
	public String getDates() {
		return this.dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	@Column(name = "longitude", length = 50, nullable = false)
	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Column(name = "site", length = 50, nullable = false)
	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Column(name = "latitude", length = 50, nullable = false)
	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column(name = "companyName", length = 150, nullable = false)
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}