package com.henghao.Garden.SQLEntity;

/**
 * function 数据库操作合同管理sql语句辅助类
 * 
 * @author 严彬荣
 */
public class FileSql {

	// 合同文件数据保存sql
	private String saveCompactSql = "insert into compactmassage (path,pathId,uid,isNo) values (?,?,?,?)";

	// 人才库文件数据保存sql
	private String saveTalentpoolSql = "insert into talentpoolmassage (path,fileId,isNo) values (?,?,?)";

	public String getSaveCompactSql() {
		return saveCompactSql;
	}

	public void setSaveCompactSql(String saveCompactSql) {
		this.saveCompactSql = saveCompactSql;
	}

	public String getSaveTalentpoolSql() {
		return saveTalentpoolSql;
	}

	public void setSaveTalentpoolSql(String saveTalentpoolSql) {
		this.saveTalentpoolSql = saveTalentpoolSql;
	}

}
