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
 * Prospect entity.现场施工检验表实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "prospect", catalog = "garden")
public class Prospect implements java.io.Serializable {

	private static final long serialVersionUID = 5519643166411785693L;
	// 表ID
	private Integer ppid;
	// 项目名称
	private String name;
	// 现场检验时间
	private String xcTime;
	// 现场检验地址
	private String xcAdd;
	// 现场检验人员
	private String xcPerson;
	// 现场检验情况图片编号
	private String xcSituationId;
	// 用户id
	private String uid;
	// 项目编号
	private Integer pid;
	// 数据状态信息（删除状态不让用户查看）
	private Integer isNo;
	// 图片路径
	private List<Filemassage> url;

	// Constructors

	/** default constructor */
	public Prospect() {
		this.isNo = 0;
	}

	/** full constructor */

	public Prospect(Integer ppid, String name, String xcTime, String xcAdd,
			String xcPerson, String xcSituationId, String uid, Integer pid,
			Integer isNo) {
		super();
		this.ppid = ppid;
		this.name = name;
		this.xcTime = xcTime;
		this.xcAdd = xcAdd;
		this.xcPerson = xcPerson;
		this.xcSituationId = xcSituationId;
		this.uid = uid;
		this.pid = pid;
		this.isNo = isNo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ppid", unique = true, nullable = false)
	public Integer getPpid() {
		return this.ppid;
	}

	public void setPpid(Integer ppid) {
		this.ppid = ppid;
	}

	@Column(name = "xcTime", length = 30, nullable = false)
	public String getXcTime() {
		return this.xcTime;
	}

	public void setXcTime(String xcTime) {
		this.xcTime = xcTime;
	}

	@Column(name = "xcAdd", length = 150, nullable = false)
	public String getXcAdd() {
		return this.xcAdd;
	}

	public void setXcAdd(String xcAdd) {
		this.xcAdd = xcAdd;
	}

	@Column(name = "xcPerson", length = 20, nullable = false)
	public String getXcPerson() {
		return this.xcPerson;
	}

	public void setXcPerson(String xcPerson) {
		this.xcPerson = xcPerson;
	}

	@Column(name = "xcSituationId", length = 32, unique = true, nullable = false)
	public String getXcSituationId() {
		return this.xcSituationId;
	}

	public void setXcSituationId(String xcSituationId) {
		this.xcSituationId = xcSituationId;
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