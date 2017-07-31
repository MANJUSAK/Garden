package com.henghao.Garden.entity.leasing;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Blueprint entity. 人员招聘表实体
 * 
 * @author 严彬荣
 */

@Entity
@Table(name = "recruit", catalog = "garden")
public class Recruit implements java.io.Serializable {

	private static final long serialVersionUID = -2516641992334710599L;
	// 表ID
	private Integer rid;
	// 职位
	private String position;
	// 企业名称
	private String companyName;
	// 企业地址
	private String companyAdress;
	// 工作地点
	private String workingAdress;
	// 联系人
	private String contact;
	// 联系电话
	private String tel;
	// 发布日期
	private String dates;
	// 招聘详情
	private String detail;
	// 用户编号
	private String uid;
	// 状态参数
	private Integer isNo;

	public Recruit() {
		super();
		this.isNo = 0;
		this.dates = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date());
		// TODO Auto-generated constructor stub
	}

	public Recruit(Integer rid, String position, String companyName,
			String companyAdress, String workingAdress, String contact,
			String tel, String dates, String detail, String uid, Integer isNo) {
		super();
		this.rid = rid;
		this.position = position;
		this.companyName = companyName;
		this.companyAdress = companyAdress;
		this.workingAdress = workingAdress;
		this.contact = contact;
		this.tel = tel;
		this.dates = dates;
		this.detail = detail;
		this.uid = uid;
		this.isNo = isNo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rid", unique = true, nullable = false)
	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	@Column(name = "position", length = 20, nullable = false)
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name = "companyAdress", length = 150, nullable = false)
	public String getCompanyAdress() {
		return companyAdress;
	}

	public void setCompanyAdress(String companyAdress) {
		this.companyAdress = companyAdress;
	}

	@Column(name = "companyName", length = 50, nullable = false)
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "workingAdress", length = 150, nullable = false)
	public String getWorkingAdress() {
		return workingAdress;
	}

	public void setWorkingAdress(String workingAdress) {
		this.workingAdress = workingAdress;
	}

	@Column(name = "contact", length = 15, nullable = false)
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name = "tel", length = 12, nullable = false)
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "dates", length = 50, nullable = false)
	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	@Column(name = "detail", length = 1000, nullable = false)
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Column(name = "uid", length = 32, nullable = false)
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "isNo", length = 1, nullable = false)
	public Integer getIsNo() {
		return isNo;
	}

	public void setIsNo(Integer isNo) {
		this.isNo = isNo;
	}

}
