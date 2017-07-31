package com.henghao.Garden.dao.daolmpl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.henghao.Garden.SQLEntity.FileSql;
import com.henghao.Garden.SQLEntity.SQL;
import com.henghao.Garden.dao.SaveFileDao;
import com.henghao.Garden.entity.fileMassage.*;
import com.henghao.Garden.entity.user.Userfile;

/**
 * function 文件信息访问数据库Java类
 * 
 * date 2017-03-10
 * 
 * @author 严彬荣
 */
@Repository
public class SaveFileDaolmpl implements SaveFileDao {
	@Resource
	private SessionFactory factory;
	private SQL sql = new SQL();
	private FileSql fileSql = new FileSql();

	// 文件信息保存dao方法
	@Override
	public StringBuilder SaveFileMassageDao(LinkedList<String> list,
			Filemassage msg) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			if (i != 0 && i % 100 == 0) {
				this.factory.getCurrentSession().flush();
			}
			this.factory.getCurrentSession()
					.createSQLQuery(this.sql.getSaveFileSql())
					.setParameter(0, list.get(i)).setParameter(1, msg.getUid())
					.setParameter(2, msg.getPhotofile())
					.setParameter(3, msg.getIsNo()).executeUpdate();
		}
		this.factory.getCurrentSession().clear();
		// 获取上传文件保存后的文件路径
		StringBuilder path = new StringBuilder(list.get(0).substring(0,
				list.get(0).lastIndexOf("/")));
		list.clear();
		return path;
	}

	// 保存Excel文件信息dao方法
	@Override
	public void SaveExcelmassageDao(Excelmassage msg) throws Exception {
		this.factory.getCurrentSession().save(msg);
		this.factory.getCurrentSession().clear();
	}

	// 保存用户文件dao方法
	@Override
	public void SaveUserFileMassageDao(LinkedList<String> list, Userfile msg)
			throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			if (i != 0 && i % 100 == 0) {
				this.factory.getCurrentSession().flush();
			}
			this.factory.getCurrentSession()
					.createSQLQuery(this.sql.getSaveUserFileSql())
					.setParameter(0, list.get(i))
					.setParameter(1, msg.getFileId()).executeUpdate();
		}
		list.clear();
		this.factory.getCurrentSession().clear();
	}

	// 保存合同管理文件数据dao方法
	@Override
	public StringBuilder SaveCompactmassgeDao(List<String> list,
			Compactmassage msg) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			if (i != 0 && i % 100 == 0) {
				this.factory.getCurrentSession().flush();
			}
			this.factory.getCurrentSession()
					.createSQLQuery(this.fileSql.getSaveCompactSql())
					.setParameter(0, list.get(i))
					.setParameter(1, msg.getPathId())
					.setParameter(2, msg.getUid())
					.setParameter(3, msg.getIsNo()).executeUpdate();
		}
		this.factory.getCurrentSession().clear();
		// 获取上传文件保存后的文件路径
		StringBuilder path = new StringBuilder(list.get(0).substring(0,
				list.get(0).lastIndexOf("/")));
		list.clear();
		return path;
	}

	// 人才库文件保存dao方法
	@Override
	public StringBuilder saveTalentpoolmassageDao(List<String> list,
			Talentpoolmassage msg) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			if (i != 0 && i % 100 == 0) {
				this.factory.getCurrentSession().flush();
			}
			this.factory.getCurrentSession()
					.createSQLQuery(this.fileSql.getSaveTalentpoolSql())
					.setParameter(0, list.get(i))
					.setParameter(1, msg.getFileId())
					.setParameter(2, msg.getIsNo()).executeUpdate();
		}
		this.factory.getCurrentSession().clear();
		// 获取上传文件保存后的文件路径
		StringBuilder path = new StringBuilder(list.get(0).substring(0,
				list.get(0).lastIndexOf("/")));
		list.clear();
		return path;
	}
}
