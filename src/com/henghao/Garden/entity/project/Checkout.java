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
 * Checkout entity.工序报验信息表实体
 * 
 * @author 严彬荣
 */

@Entity
@Table(name = "checkout", catalog = "garden")
public class Checkout implements java.io.Serializable {

	private static final long serialVersionUID = 6258172253156217915L;
	// 表id
	private Integer cid;
	// 工程名称
	private String gxName;
	// 工序名称
	private String gxProcedure;
	// 人员类型
	private String personnelType;
	// 交接者
	private String receiver;
	// 工作岗位
	private String workPost;
	// 施工日期
	private String gxTime;
	// 影像资料图编号
	private String gxImgId;
	// 项目信息编号pid
	private Integer pid;
	// 用户ID
	private String uid;
	// 数据状态信息（删除状态不让用户查看）
	private Integer isNo;
	// 图片路径
	private List<Filemassage> url;

	// Constructors

	/** default constructor */
	public Checkout() {
		this.isNo = 0;
	}

	/** full constructor */
	public Checkout(String gxName, String gxProcedure, String workPost,
			String gxTime, String gxImgId, String receiver, String uid,
			Integer pid, String personnelType, Integer isNo) {
		this.gxName = gxName;
		this.gxProcedure = gxProcedure;
		this.workPost = workPost;
		this.gxTime = gxTime;
		this.gxImgId = gxImgId;
		this.uid = uid;
		this.isNo = isNo;
		this.pid = pid;
		this.personnelType = personnelType;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid", unique = true, nullable = false)
	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Column(name = "gx_name", length = 50, nullable = false)
	public String getGxName() {
		return this.gxName;
	}

	public void setGxName(String gxName) {
		this.gxName = gxName;
	}

	@Column(name = "gx_procedure", length = 50, nullable = false)
	public String getGxProcedure() {
		return this.gxProcedure;
	}

	public void setGxProcedure(String gxProcedure) {
		this.gxProcedure = gxProcedure;
	}

	@Column(name = "receiver", length = 10, nullable = false)
	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	@Column(name = "workPost", length = 10, nullable = false)
	public String getWorkPost() {
		return this.workPost;
	}

	public void setWorkPost(String workPost) {
		this.workPost = workPost;
	}

	@Column(name = "gx_time", length = 20, nullable = false)
	public String getGxTime() {
		return this.gxTime;
	}

	public void setGxTime(String gxTime) {
		this.gxTime = gxTime;
	}

	@Column(name = "gx_imgId", length = 32, unique = true, nullable = false)
	public String getGxImgId() {
		return this.gxImgId;
	}

	public void setGxImgId(String gxImgId) {
		this.gxImgId = gxImgId;
	}

	@Column(name = "uid", nullable = false)
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

}