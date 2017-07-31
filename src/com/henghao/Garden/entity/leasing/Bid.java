package com.henghao.Garden.entity.leasing;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Bid entity. 招标信息表实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "bid", catalog = "garden")
public class Bid implements java.io.Serializable {

	private static final long serialVersionUID = 4860555715142399736L;
	// 表ID
	private Integer bid;
	// 标题名称
	private String titleName;
	// 招标内容
	private String content;
	// 联系人
	private String contacts;
	// 联系电话
	private String tel;
	// 日期
	private String dates;
	// 用户ID
	private String uid;
	// 状态参数（删除状态不给用户查询信息）
	private Integer isNo;

	// Constructors

	/** default constructor */
	public Bid() {
		this.isNo = 0;
	}

	/** full constructor */
	public Bid(Integer bid, String titleName, String content, String contacts,
			String tel, String dates, String uid, Integer isNo) {
		super();
		this.bid = bid;
		this.titleName = titleName;
		this.content = content;
		this.contacts = contacts;
		this.tel = tel;
		this.dates = dates;
		this.uid = uid;
		this.isNo = isNo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bid", unique = true, nullable = false)
	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	@Column(name = "titleName", length = 50)
	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	@Column(name = "content", length = 5000)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "contacts", length = 10)
	public String getContacts() {
		return this.contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	@Column(name = "tel", length = 11)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "dates", length = 30)
	public String getDates() {
		return this.dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	@Column(name = "uid")
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "isNo")
	public Integer getIsNo() {
		return this.isNo;
	}

	public void setIsNo(Integer isNo) {
		this.isNo = isNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bid == null) ? 0 : bid.hashCode());
		result = prime * result
				+ ((contacts == null) ? 0 : contacts.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((dates == null) ? 0 : dates.hashCode());
		result = prime * result + ((isNo == null) ? 0 : isNo.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result
				+ ((titleName == null) ? 0 : titleName.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bid other = (Bid) obj;
		if (bid == null) {
			if (other.bid != null)
				return false;
		} else if (!bid.equals(other.bid))
			return false;
		if (contacts == null) {
			if (other.contacts != null)
				return false;
		} else if (!contacts.equals(other.contacts))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (dates == null) {
			if (other.dates != null)
				return false;
		} else if (!dates.equals(other.dates))
			return false;
		if (isNo == null) {
			if (other.isNo != null)
				return false;
		} else if (!isNo.equals(other.isNo))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (titleName == null) {
			if (other.titleName != null)
				return false;
		} else if (!titleName.equals(other.titleName))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}

}