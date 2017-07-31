package com.henghao.Garden.entity.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * SgPersonnel entity. 施工人员信息表
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "sg_personnel", catalog = "garden")
public class SgPersonnel implements java.io.Serializable {

	private static final long serialVersionUID = 8423953718247378127L;
	// 表ID
	private Integer sid;
	// 项目名称
	private String name;
	// 姓名
	private String psName;
	// 身份证号码
	private String psIdcard;
	// 联系方式
	private String psTel;
	// 人员类型
	private String personnelType;
	// 工作岗位
	private String workPost;
	// 用户id
	private String uid;
	// 项目编号
	private Integer pid;
	// 数据状态信息（删除状态不让用户查看）
	private Integer isNo;

	// Constructors

	/** default constructor */
	public SgPersonnel() {
		this.isNo = 0;
	}

	/** full constructor */
	public SgPersonnel(String psName, String psIdcard, String psTel,
			String uid, Integer pid, String personnelType, String workPost,
			Integer idNo, String name) {
		this.psName = psName;
		this.psIdcard = psIdcard;
		this.psTel = psTel;
		this.uid = uid;
		this.pid = pid;
		this.personnelType = personnelType;
		this.workPost = workPost;
		this.isNo = idNo;
		this.name = name;
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

	@Column(name = "psName", length = 50, nullable = false)
	public String getPsName() {
		return this.psName;
	}

	public void setPsName(String psName) {
		this.psName = psName;
	}

	@Column(name = "psIdcard", length = 20, nullable = false)
	public String getPsIdcard() {
		return this.psIdcard;
	}

	public void setPsIdcard(String psIdcard) {
		this.psIdcard = psIdcard;
	}

	@Column(name = "psTel", length = 15, nullable = false)
	public String getPsTel() {
		return this.psTel;
	}

	public void setPsTel(String psTel) {
		this.psTel = psTel;
	}

	@Column(name = "uid", nullable = false, length = 32)
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "personnelType", length = 10, nullable = false)
	public String getPersonnelType() {
		return personnelType;
	}

	public void setPersonnelType(String personnelType) {
		this.personnelType = personnelType;
	}

	@Column(name = "workPost", length = 10, nullable = false)
	public String getWorkPost() {
		return workPost;
	}

	public void setWorkPost(String workPost) {
		this.workPost = workPost;
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

}