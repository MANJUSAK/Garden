package com.henghao.Garden.entity.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Supervisionlog entity.监理日志表实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "supervisionlog", catalog = "garden")
public class Supervisionlog implements java.io.Serializable {

	private static final long serialVersionUID = -1113760786378396604L;
	// 表ID
	private Integer sid;
	// 工程名称
	private String projectName;
	// 监理部位
	private String supervisionPosition;
	// 工程施工进度情况
	private String progressSituation;
	// 监理工作情况
	private String workingSitustion;
	// 存在及处理问题
	private String question;
	// 日期
	private String dates;
	// 记录人
	private String noteTaker;
	// 监理工程师
	private String engineer;
	// 其它有关事项
	private String other;
	// 用户编号
	private String uid;
	// 项目编号
	private Integer pid;
	// 状态参数
	private Integer isNo;

	// Constructors

	/** default constructor */
	public Supervisionlog() {
		this.isNo = 0;
	}

	/** full constructor */
	public Supervisionlog(String projectName, String supervisionPosition,
			String progressSituation, String workingSitustion, String question,
			String dates, String noteTaker, String engineer, String uid,
			Integer pid, String other, Integer isNo) {
		this.projectName = projectName;
		this.supervisionPosition = supervisionPosition;
		this.progressSituation = progressSituation;
		this.workingSitustion = workingSitustion;
		this.question = question;
		this.dates = dates;
		this.noteTaker = noteTaker;
		this.engineer = engineer;
		this.other = other;
		this.uid = uid;
		this.pid = pid;
		this.isNo = isNo;
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

	@Column(name = "projectName", length = 50, nullable = false)
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "supervisionPosition", length = 50, nullable = false)
	public String getSupervisionPosition() {
		return this.supervisionPosition;
	}

	public void setSupervisionPosition(String supervisionPosition) {
		this.supervisionPosition = supervisionPosition;
	}

	@Column(name = "progressSituation", length = 500, nullable = false)
	public String getProgressSituation() {
		return this.progressSituation;
	}

	public void setProgressSituation(String progressSituation) {
		this.progressSituation = progressSituation;
	}

	@Column(name = "workingSitustion", length = 500, nullable = false)
	public String getWorkingSitustion() {
		return this.workingSitustion;
	}

	public void setWorkingSitustion(String workingSitustion) {
		this.workingSitustion = workingSitustion;
	}

	@Column(name = "question", length = 300, nullable = false)
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Column(name = "dates", length = 30, nullable = false)
	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	@Column(name = "noteTaker", length = 15, nullable = false)
	public String getNoteTaker() {
		return noteTaker;
	}

	public void setNoteTaker(String noteTaker) {
		this.noteTaker = noteTaker;
	}

	@Column(name = "engineer", length = 15, nullable = false)
	public String getEngineer() {
		return engineer;
	}

	public void setEngineer(String engineer) {
		this.engineer = engineer;
	}

	@Column(name = "other", length = 300, nullable = false)
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
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

}