package com.henghao.Garden.dao.daolmpl;

import org.hibernate.criterion.*;

import com.henghao.Garden.dao.JudgeProjectMassageDao;
import com.henghao.Garden.entity.project.*;
import com.henghao.Garden.sessionFactory.SessionFactoryDao;

import org.springframework.stereotype.Repository;

/**
 * function 后台判断添加项目信息是否存在访问数据库Java类
 * 
 * @author 严彬荣
 */

@Repository
public class JudgeProjectMassageDaolmpl extends SessionFactoryDao implements
		JudgeProjectMassageDao {

	// 判断会审结果是否存在dao方法
	@Override
	public int judgeHsResultMsg(String uid, int pid) {
		// 初始化DetachedCriteria高级查询
		DetachedCriteria dc = DetachedCriteria.forClass(HsResult.class, "a");
		// 初始化查询所需字段方法
		ProjectionList field = Projections.projectionList();
		// 设置需要查询的字段
		field.add((Projections.property("a.isNo").as("isNo")));
		// 设置查询时的条件
		dc.add(Restrictions.and(Restrictions.eq("pid", pid),
				Restrictions.eq("uid", uid), Restrictions.eq("isNo", 0)));
		// 将查询字段返回给DetachedCriteria
		dc.setProjection(field);
		// 返回查询结果
		return dc.getExecutableCriteria(super.getSessionfactroy()).list()
				.size();
	}

	// 判断开工报告是否存在dao方法
	@Override
	public int judgeKgReportMsg(String uid, int pid) {
		// 初始化detachedCriteria高级查询
		DetachedCriteria dc = DetachedCriteria.forClass(KgReport.class, "a");
		// 初始化字段查询方法
		ProjectionList field = Projections.projectionList();
		// 设置需要查询的字段
		field.add((Projections.property("a.pid").as("pid")));
		// 设置查询时的条件
		dc.add(Restrictions.and(Restrictions.eq("uid", uid),
				Restrictions.eq("pid", pid), Restrictions.eq("isNo", 0)));
		// 将设置的字段添加到detachedCriteria
		dc.setProjection(field);
		// 结算高级查询返回结果
		return dc.getExecutableCriteria(super.getSessionfactroy()).list()
				.size();
	}

	// 判断技术交底是否存在dao方法
	@Override
	public int judgeTechnologyMsg(String uid, int pid) {
		// 初始化detachedCriteria高级查询
		DetachedCriteria dc = DetachedCriteria.forClass(Technology.class, "a");
		// 初始化字段查询方法
		ProjectionList field = Projections.projectionList();
		// 设置需要查询的字段
		field.add((Projections.property("a.pid").as("pid")));
		// 设置查询时的条件
		dc.add(Restrictions.and(Restrictions.eq("uid", uid),
				Restrictions.eq("pid", pid), Restrictions.eq("isNo", 0)));
		// 将设置的字段添加到detachedCriteria
		dc.setProjection(field);
		// 返回结果
		return dc.getExecutableCriteria(super.getSessionfactroy()).list()
				.size();
	}

	// 判断项目结算是否存在dao方法
	@Override
	public int judgeSettlementMsg(String uid, int pid) {
		// 初始化detachedCriteria高级查询
		DetachedCriteria dc = DetachedCriteria.forClass(Settlement.class, "a");
		// 初始化字段查询方法
		ProjectionList field = Projections.projectionList();
		// 设置需要查询的字段
		field.add((Projections.property("a.pid").as("pid")));
		// 设置查询时的条件
		dc.add(Restrictions.and(Restrictions.eq("uid", uid),
				Restrictions.eq("pid", pid), Restrictions.eq("isNo", 0)));
		// 将设置的字段添加到detachedCriteria
		dc.setProjection(field);
		// 返回结果
		return dc.getExecutableCriteria(super.getSessionfactroy()).list()
				.size();
	}

	// 判断竣工验收是否存在dao方法
	@Override
	public int judgeFinalacceptanceMsg(String uid, int pid) {
		// 初始化detachedCriteria高级查询
		DetachedCriteria dc = DetachedCriteria.forClass(Finalacceptance.class,
				"a");
		// 初始化字段查询方法
		ProjectionList field = Projections.projectionList();
		// 设置需要查询的字段
		field.add((Projections.property("a.pid").as("pid")));
		// 设置查询时的条件
		dc.add(Restrictions.and(Restrictions.eq("uid", uid),
				Restrictions.eq("pid", pid), Restrictions.eq("isNo", 0)));
		// 将设置的字段添加到detachedCriteria
		dc.setProjection(field);
		// 返回结果
		return dc.getExecutableCriteria(super.getSessionfactroy()).list()
				.size();
	}

}
