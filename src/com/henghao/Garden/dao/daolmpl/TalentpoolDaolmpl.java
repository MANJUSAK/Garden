package com.henghao.Garden.dao.daolmpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.henghao.Garden.dao.TalentpoolDao;
import com.henghao.Garden.entity.fileMassage.Talentpoolmassage;
import com.henghao.Garden.entity.talentpool.Corporation;
import com.henghao.Garden.entity.talentpool.Employees;
import com.henghao.Garden.sessionFactory.SessionFactoryDao;

/**
 * function 人才库模块访问数据库Java类
 * 
 * date 2017-05-18
 * 
 * @author 严彬荣
 */

@Repository
public class TalentpoolDaolmpl extends SessionFactoryDao implements
		TalentpoolDao {

	/*
	 * 查询人才库文件信息数据dao方法
	 * 
	 * Parma field 文件编号
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Talentpoolmassage> queryFileMassage(String fileId) {
		DetachedCriteria dc = DetachedCriteria.forClass(
				Talentpoolmassage.class, "t");
		ProjectionList field = Projections.projectionList();
		field.add(Property.forName("t.path").as("path"));
		dc.add(Restrictions.eq("fileId", fileId));
		dc.add(Restrictions.eq("isNo", 0));
		dc.setProjection(field);
		return dc.getExecutableCriteria(super.getSessionfactroy()).list();
	}

	// 查询法人库信息数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Corporation> queryCorporationDao() {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(Corporation.class);
		dc.add(Restrictions.eq("isNo", 0));
		dc.addOrder(Order.desc("cid"));
		return dc.getExecutableCriteria(super.getSessionfactroy()).list();
	}

	// 查询从业人才库信息数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Employees> queryEmployeesDao() {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(Employees.class);
		dc.add(Restrictions.eq("isNo", 0));
		dc.addOrder(Order.desc("eid"));
		return dc.getExecutableCriteria(super.getSessionfactroy()).list();
	}

	// 法人库信息数据录入dao方法
	@Override
	public void saveCorporationDao(Corporation msg) throws Exception {
		// TODO Auto-generated method stub
		super.getSessionfactroy().save(msg);
		super.getSessionfactroy().clear();
	}

	// 从业人员库信息数据录入dao方法
	@Override
	public void saveEmployeesDao(Employees msg) throws Exception {
		// TODO Auto-generated method stub
		super.getSessionfactroy().save(msg);
		super.getSessionfactroy().clear();
	}

}
