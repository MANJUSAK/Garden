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
 * Wallet entity. 施工的钱包实体
 * 
 * @author 严彬荣
 */
@Entity
@Table(name = "wallet", catalog = "garden")
public class Wallet implements java.io.Serializable {

	private static final long serialVersionUID = 9042735673263274379L;
	// 表ID
	private Integer wid;
	// 用户ID
	private String uid;
	// 金额
	private Double money;
	// 类型
	private Integer types;
	// 备注
	private String comment;
	// 交易时间
	private String transactionTime;
	// 数据状态信息（删除状态不让用户查看）
	private Integer isNo;

	// Constructors

	/** default constructor */
	public Wallet() {
		this.isNo = 0;
		this.money = 0.00;
		this.types = -1;
		this.transactionTime = new SimpleDateFormat("yyyy-MM-dd HH:mm")
				.format(new Date());
	}

	/** full constructor */
	public Wallet(Integer wid, String uid, Double money, Integer types,
			String comment, String transactionTime, Integer isNo) {
		super();
		this.wid = wid;
		this.uid = uid;
		this.money = money;
		this.types = types;
		this.comment = comment;
		this.transactionTime = transactionTime;
		this.isNo = isNo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wid", unique = true, nullable = false)
	public Integer getWid() {
		return this.wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	@Column(name = "uid", nullable = false, length = 32)
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "money", precision = 22, scale = 6, nullable = false)
	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	@Column(name = "types", nullable = false)
	public Integer getTypes() {
		return types;
	}

	public void setTypes(Integer types) {
		this.types = types;
	}

	@Column(name = "comment", length = 500)
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "transactionTime", length = 20, nullable = false)
	public String getTransactionTime() {
		return this.transactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	@Column(name = "is_no", nullable = false)
	public Integer getIsNo() {
		return this.isNo;
	}

	public void setIsNo(Integer isNo) {
		this.isNo = isNo;
	}

}