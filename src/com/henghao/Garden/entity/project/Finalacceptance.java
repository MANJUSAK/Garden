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
 * Finalacceptance entity.竣工验收表实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "finalacceptance", catalog = "garden")
public class Finalacceptance implements java.io.Serializable {

	private static final long serialVersionUID = -866209508410120654L;
	// 表ID
	private Integer fid;
	// 工程名称
	private String projectName;
	// 竣工时间
	private String dates;
	// 验收员
	private String inspectionPersonnel;
	/*
	 * // 验收现场情况 private String inspectionSituation;
	 */
	// 验收图路径编号
	private String completionDrawingId;
	/*
	 * // 验收报告路径编号 private String completionReportId;
	 */
	// 用户编号
	private String uid;
	// 项目编号
	private Integer pid;
	// 状态参数
	private Integer isNo;
	// 文件路径
	private List<Filemassage> url;

	// Constructors

	/** default constructor */
	public Finalacceptance() {
		this.isNo = 0;
	}

	/** full constructor */
	public Finalacceptance(Integer fid, String projectName, String dates,
			String inspectionPersonnel, String completionDrawingId, String uid,
			Integer pid, Integer isNo, List<Filemassage> url) {
		super();
		this.fid = fid;
		this.projectName = projectName;
		this.dates = dates;
		this.inspectionPersonnel = inspectionPersonnel;
		this.completionDrawingId = completionDrawingId;
		this.uid = uid;
		this.pid = pid;
		this.isNo = isNo;
		this.url = url;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fid", unique = true, nullable = false)
	public Integer getFid() {
		return this.fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	@Column(name = "projectName", length = 50, nullable = false)
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "dates", length = 30, nullable = false)
	public String getDates() {
		return this.dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	@Column(name = "inspectionPersonnel", length = 20, nullable = false)
	public String getInspectionPersonnel() {
		return this.inspectionPersonnel;
	}

	public void setInspectionPersonnel(String inspectionPersonnel) {
		this.inspectionPersonnel = inspectionPersonnel;
	}

	/*
	 * @Column(name = "inspectionSituation", length = 300, nullable = false)
	 * public String getInspectionSituation() { return this.inspectionSituation;
	 * }
	 * 
	 * public void setInspectionSituation(String inspectionSituation) {
	 * this.inspectionSituation = inspectionSituation; }
	 */

	@Column(name = "completionDrawingId", length = 32, unique = true, nullable = false)
	public String getCompletionDrawingId() {
		return this.completionDrawingId;
	}

	public void setCompletionDrawingId(String completionDrawingId) {
		this.completionDrawingId = completionDrawingId;
	}

	/*
	 * @Column(name = "completionReportId", length = 32, nullable = false)
	 * public String getCompletionReportId() { return this.completionReportId; }
	 * 
	 * public void setCompletionReportId(String completionReportId) {
	 * this.completionReportId = completionReportId; }
	 */

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

}