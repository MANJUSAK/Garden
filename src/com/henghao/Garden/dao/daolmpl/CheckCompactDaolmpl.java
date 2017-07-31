package com.henghao.Garden.dao.daolmpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.henghao.Garden.dao.CheckCompactDao;
import com.henghao.Garden.entity.compact.*;
import com.henghao.Garden.entity.user.Users;
import com.henghao.Garden.resultEntity.CompactBath;
import com.henghao.Garden.sessionFactory.SessionFactoryDao;

/**
 * function 合同管理审核访问数据库Java类
 * 
 * date 2017.04.21
 * 
 * @author 严彬荣
 */
@Repository
public class CheckCompactDaolmpl extends SessionFactoryDao implements
		CheckCompactDao {

	// 查询待审核建设类合同数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<BuildCompact> checkBuildCompact() {
		DetachedCriteria dc = DetachedCriteria.forClass(BuildCompact.class);
		dc.add(Restrictions.eq("parameter", 1));
		dc.add(Restrictions.eq("isNo", 0));
		dc.addOrder(Order.desc("id"));
		return dc.getExecutableCriteria(super.getSessionfactroy()).list();
	}

	// 查询待审核园林类合同数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<GardenCompact> checkGardenCompact() {
		DetachedCriteria dc = DetachedCriteria.forClass(GardenCompact.class);
		dc.add(Restrictions.eq("parameter", 1));
		dc.addOrder(Order.desc("id"));
		dc.add(Restrictions.eq("isNo", 0));
		return dc.getExecutableCriteria(super.getSessionfactroy()).list();
	}

	// 查询待审核园林工程类合同数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<GardenEngineeringCompact> checkEngineeringCompact() {
		DetachedCriteria dc = DetachedCriteria
				.forClass(GardenEngineeringCompact.class);
		dc.add(Restrictions.eq("parameter", 1));
		dc.addOrder(Order.desc("id"));
		dc.add(Restrictions.eq("isNo", 0));
		return dc.getExecutableCriteria(super.getSessionfactroy()).list();
	}

	// 查询待审核景观类合同数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<LandscapeCompact> checkLandscapeCompact() {
		DetachedCriteria dc = DetachedCriteria.forClass(LandscapeCompact.class);
		dc.add(Restrictions.eq("parameter", 1));
		dc.addOrder(Order.desc("id"));
		dc.add(Restrictions.eq("isNo", 0));
		return dc.getExecutableCriteria(super.getSessionfactroy()).list();
	}

	// 查找推送合同的用户dao方法
	@Override
	public Users queryUser(String name, String idCard) {
		DetachedCriteria dc = DetachedCriteria.forClass(Users.class, "u");
		ProjectionList field = Projections.projectionList();
		field.add(Property.forName("u.uid").as("uid"));
		field.add(Property.forName("u.legalPersonIDcard").as(
				"legalPersonIDcard"));
		field.add(Property.forName("u.tel").as("tel"));
		field.add(Property.forName("u.contact").as("contact"));
		dc.add(Restrictions.and(Restrictions.eq("contact", name),
				Restrictions.eq("legalPersonIDcard", idCard)));
		dc.setProjection(field);
		return (Users) dc.getExecutableCriteria(super.getSessionfactroy())
				.setResultTransformer(Transformers.aliasToBean(Users.class))
				.uniqueResult();
	}

	// 建设类合同审核结果的公示dao接口
	@Override
	public void updateBuildCompact(CompactBath ids) throws Exception {
		for (int i = 0; i < ids.getIds().length; i++) {
			if (i != 0 && i % 100 == 0) {
				super.getSessionfactroy().flush();
			}
			super.getSessionfactroy()
					.createSQLQuery(
							"update buildCompact set checking=:checking,parameter=:parameter,comment=:comment where id=:id ")
					.setParameter("checking", ids.getResult())
					.setParameter("parameter", 0)
					.setParameter("comment", ids.getComment())
					.setParameter("id", ids.getIds()[i]).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 园林类合同审核结果的公示dao接口
	@Override
	public void updateGardenCompact(CompactBath ids) throws Exception {
		for (int i = 0; i < ids.getIds().length; i++) {
			if (i != 0 && i % 100 == 0) {
				super.getSessionfactroy().flush();
			}
			super.getSessionfactroy()
					.createSQLQuery(
							"update gardenCompact set checking=:checking,parameter=:parameter,comment=:comment where id=:id")
					.setParameter("checking", ids.getResult())
					.setParameter("parameter", 0)
					.setParameter("comment", ids.getComment())
					.setParameter("id", ids.getIds()[i]).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 园林工程类合同审核结果的公示dao接口
	@Override
	public void updateEngineeringCompact(CompactBath ids) throws Exception {
		for (int i = 0; i < ids.getIds().length; i++) {
			if (i != 0 && i % 100 == 0) {
				super.getSessionfactroy().flush();
			}
			super.getSessionfactroy()
					.createSQLQuery(
							"update gardenEngineeringCompact set checking=:checking,parameter=:parameter,comment=:comment where id=:id")
					.setParameter("checking", ids.getResult())
					.setParameter("parameter", 0)
					.setParameter("comment", ids.getComment())
					.setParameter("id", ids.getIds()[i]).executeUpdate();
		}
		super.getSessionfactroy().clear();

	}

	// 景观类合同审核结果的公示dao接口
	@Override
	public void updateLandscapeCompact(CompactBath ids) throws Exception {
		for (int i = 0; i < ids.getIds().length; i++) {
			if (i != 0 && i % 100 == 0) {
				super.getSessionfactroy().flush();
			}
			super.getSessionfactroy()
					.createSQLQuery(
							"update landscapeCompact set checking=:checking,parameter=:parameter,comment=:comment where id=:id")
					.setParameter("checking", ids.getResult())
					.setParameter("parameter", 0)
					.setParameter("comment", ids.getComment())
					.setParameter("id", ids.getIds()[i]).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

}
