package com.henghao.Garden.resultEntity;

/**
 * 合同管理批量集实体
 * 
 * @author 严彬荣
 */
public class CompactBath {
	// 批量合同ID
	private Integer[] ids;
	// 审核状态
	private String result;
	// 审核备注
	private String comment;

	/*
	 * // 发送者姓名 private String[] name; // 发送者手机号 private String[] tel; // 合同文档
	 * private String[] document; // 合同类型 private String[] genre; // 推送时间
	 * private String[] dates;
	 */

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	/*
	 * public String[] getName() { return name; }
	 * 
	 * public void setName(String[] name) { this.name = name; }
	 * 
	 * public String[] getTel() { return tel; }
	 * 
	 * public void setTel(String[] tel) { this.tel = tel; }
	 * 
	 * public String[] getDocument() { return document; }
	 * 
	 * public void setDocument(String[] document) { this.document = document; }
	 * 
	 * public String[] getGenre() { return genre; }
	 * 
	 * public void setGenre(String[] genre) { this.genre = genre; }
	 * 
	 * public String[] getDates() { return dates; }
	 * 
	 * public void setDates(String[] dates) { this.dates = dates; }
	 */

}
