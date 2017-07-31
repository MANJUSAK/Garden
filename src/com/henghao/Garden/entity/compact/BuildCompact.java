package com.henghao.Garden.entity.compact;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.henghao.Garden.entity.fileMassage.Compactmassage;
import com.henghao.Garden.util.UUIDUtil;

/**
 * GhCompact entity. 建设类合同实体类
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "buildCompact", catalog = "garden")
public class BuildCompact implements java.io.Serializable {

	private static final long serialVersionUID = 3145800087438710960L;

	// 表id
	private Integer id;
	// 合同编号
	private String compactId;
	// 用户id
	private String uid;
	// 合同图片编号
	private String pictureId;
	// 合同项目名称
	private String projectName;
	// 合同文档
	// private String document;
	// 合同类型
	private String genre;
	// 录入时间
	private String dates;
	// 审核状态
	private String checking;
	/*
	 * // 发送者姓名 private String sendName; // 发送者手机号 private String sendTel; //
	 * 接受者姓名 private String recipientName; // 接受者id private String recipientId;
	 * // 接受者身份证号 private String recipientTel; // 发起合同状态（0表示发起或1表示接受） private
	 * Integer opens;
	 */
	// 审核状态参数
	private Integer parameter;
	// 备注
	private String comment;
	// 状态参数
	private Integer isNo;
	// 图片路径集合
	private List<Compactmassage> url;

	// Constructors

	/** default constructor */
	public BuildCompact() {
		this.parameter = 1;
		this.isNo = 0;
		this.compactId = UUIDUtil.getInstance().getUUID().toString();
		this.checking = "正在审核";
		// this.opens = 0;
		this.dates = new SimpleDateFormat("yyyy-MM-dd HH:mm")
				.format(new Date());
	}

	/** full constructor */
	public BuildCompact(Integer id, String compactId, String uid,
			String pictureId, String projectName, String genre, String dates,
			String checking, Integer parameter, String comment, Integer isNo,
			List<Compactmassage> url) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.compactId = compactId;
		this.uid = uid;
		this.pictureId = pictureId;
		this.genre = genre;
		this.dates = dates;
		this.checking = checking;
		this.parameter = parameter;
		this.comment = comment;
		this.isNo = isNo;
		this.url = url;
	}

	// Property accessors

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "compactId", unique = true, nullable = false, length = 32)
	public String getCompactId() {
		return compactId;
	}

	public void setCompactId(String compactId) {
		this.compactId = compactId;
	}

	@Column(name = "uid", nullable = false, length = 32)
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "pictureId", unique = true, length = 32)
	public String getPictureId() {
		return pictureId;
	}

	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}

	/*
	 * @Column(name = "document", length = 300) public String getDocument() {
	 * return document; }
	 * 
	 * public void setDocument(String document) { this.document = document; }
	 */

	@Column(name = "projectName", nullable = false, length = 150)
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "genre", nullable = false, length = 50)
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Column(name = "isNo")
	public Integer getIsNo() {
		return isNo;
	}

	public void setIsNo(Integer isNo) {
		this.isNo = isNo;
	}

	@Column(name = "dates", nullable = false, length = 20)
	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	@Column(name = "checking", nullable = false, length = 5)
	public String getChecking() {
		return checking;
	}

	public void setChecking(String checking) {
		this.checking = checking;
	}

	/*
	 * @Column(name = "sendName", length = 20) public String getSendName() {
	 * return sendName; }
	 * 
	 * public void setSendName(String sendName) { this.sendName = sendName; }
	 * 
	 * @Column(name = "sendTel", length = 15) public String getSendTel() {
	 * return sendTel; }
	 * 
	 * public void setSendTel(String sendTel) { this.sendTel = sendTel; }
	 * 
	 * @Column(name = "recipientId", length = 32) public String getRecipientId()
	 * { return recipientId; }
	 * 
	 * public void setRecipientId(String recipientId) { this.recipientId =
	 * recipientId; }
	 * 
	 * @Column(name = "recipientName", length = 20) public String
	 * getRecipientName() { return recipientName; }
	 * 
	 * public void setRecipientName(String recipientName) { this.recipientName =
	 * recipientName; }
	 * 
	 * @Column(name = "recipientTel", length = 15) public String
	 * getRecipientTel() { return recipientTel; }
	 * 
	 * public void setRecipientTel(String recipientTel) { this.recipientTel =
	 * recipientTel; }
	 * 
	 * @Column(name = "opens", nullable = false) public Integer getOpens() {
	 * return opens; }
	 * 
	 * public void setOpens(Integer opens) { this.opens = opens; }
	 */

	@Column(name = "parameter", nullable = false)
	public Integer getParameter() {
		return parameter;
	}

	public void setParameter(Integer parameter) {
		this.parameter = parameter;
	}

	@Column(name = "comment", length = 500)
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Transient
	public List<Compactmassage> getUrl() {
		return url;
	}

	public void setUrl(List<Compactmassage> url) {
		this.url = url;
	}

}