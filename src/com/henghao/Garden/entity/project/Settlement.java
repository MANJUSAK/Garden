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
 * Settlement entity.项目结算表实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "settlement", catalog = "garden")
public class Settlement implements java.io.Serializable {

	private static final long serialVersionUID = -5181886075645241312L;
	// 表ID
	private Integer sid;
	// 项目名称
	private String name;
	// 结算日期
	private String dates;
	// 结算书编号
	private String settlementBookId;
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
	public Settlement() {
		this.isNo = 0;
	}

	/** full constructor */
	public Settlement(Integer sid, String name, String dates,
			String settlementBookId, String uid, Integer isNo, Integer pid) {
		this.sid = sid;
		this.name = name;
		this.dates = dates;
		this.settlementBookId = settlementBookId;
		this.uid = uid;
		this.pid = pid;
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

	@Column(name = "dates", length = 50, nullable = false)
	public String getDates() {
		return this.dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	@Column(name = "SettlementBookId", length = 32, unique = true, nullable = false)
	public String getSettlementBookId() {
		return this.settlementBookId;
	}

	public void setSettlementBookId(String settlementBookId) {
		this.settlementBookId = settlementBookId;
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Transient
	public List<Filemassage> getUrl() {
		return url;
	}

	public void setUrl(List<Filemassage> url) {
		this.url = url;
	}

}