package com.henghao.Garden.dao.daolmpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.henghao.Garden.dao.DUDemandReleaseDao;
import com.henghao.Garden.resultEntity.BatchID;
import com.henghao.Garden.sessionFactory.SessionFactoryDao;

/**
 * function 需求发布批量更新删除操作数据库Java类
 * 
 * date 2017-04-12
 * 
 * @author 严彬荣
 */

@Repository
public class DUDemandReleaseDaolmpl extends SessionFactoryDao implements
		DUDemandReleaseDao {

	// 批量删除我发布的设备租赁信息数据dao方法
	@Override
	public void deleteEquipmentleasingDao(List<BatchID> list) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			super.getSessionfactroy()
					.createSQLQuery(
							"update equipmentleasing set isNo=1 where uid=:uid and eid=:eid")
					.setParameter("uid", list.get(0).getUid())
					.setParameter("eid", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 批量删除我发布的苗木信息数据dao方法
	@Override
	public void deleteSeedlingmassageDao(List<BatchID> list) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			super.getSessionfactroy()
					.createSQLQuery(
							"update seedlingmassage set isNo=1 where uid=:uid and sid=:sid")
					.setParameter("uid", list.get(0).getUid())
					.setParameter("sid", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 批量删除我发布的人员招聘信息数据dao方法
	@Override
	public void deleteRecruitDao(List<BatchID> list) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			super.getSessionfactroy()
					.createSQLQuery(
							"update recruit set isNo=1 where uid=:uid and rid=:rid")
					.setParameter("uid", list.get(0).getUid())
					.setParameter("rid", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

}
