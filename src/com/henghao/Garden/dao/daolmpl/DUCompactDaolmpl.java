package com.henghao.Garden.dao.daolmpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.henghao.Garden.dao.DUCompactDao;
import com.henghao.Garden.resultEntity.BatchID;
import com.henghao.Garden.sessionFactory.SessionFactoryDao;

/**
 * function 合同管理批量更新删除操作数据库Java类
 * 
 * date 2017-04-24
 * 
 * @author 严彬荣
 */

@Repository
public class DUCompactDaolmpl extends SessionFactoryDao implements DUCompactDao {

	// 批量删除建设类合同数据dao方法
	@Override
	public void deleteBuildCompactDao(List<BatchID> list) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			if (i != 0 && i % 100 == 0) {
				super.getSessionfactroy().flush();
			}
			super.getSessionfactroy()
					.createSQLQuery(
							"update buildCompact set isNo=1 where id=:id")
					.setParameter("id", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 批量删除园林类合同数据dao方法
	@Override
	public void deleteGardenCompactDao(List<BatchID> list) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			if (i != 0 && i % 100 == 0) {
				super.getSessionfactroy().flush();
			}
			super.getSessionfactroy()
					.createSQLQuery(
							"update gardenCompact set isNo=1 where id=:id")
					.setParameter("id", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 批量删除园林工程类合同数据dao方法
	@Override
	public void deleteEngineeringCompactDao(List<BatchID> list)
			throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			if (i != 0 && i % 100 == 0) {
				super.getSessionfactroy().flush();
			}
			super.getSessionfactroy()
					.createSQLQuery(
							"update gardenEngineeringCompact set isNo=1 where id=:id")
					.setParameter("id", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 批量删除景观类合同数据dao方法
	@Override
	public void deleteLandscapeCompactDao(List<BatchID> list) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			if (i != 0 && i % 100 == 0) {
				super.getSessionfactroy().flush();
			}
			super.getSessionfactroy()
					.createSQLQuery(
							"update landscapeCompact set isNo=1 where id=:id")
					.setParameter("id", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

}
