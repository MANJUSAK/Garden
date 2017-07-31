package com.henghao.Garden.dao.daolmpl;

import java.util.List;
import org.hibernate.criterion.*;
import com.henghao.Garden.entity.compact.*;
import org.springframework.stereotype.Repository;
import com.henghao.Garden.dao.CompactManageDao;
import com.henghao.Garden.entity.fileMassage.Compactmassage;
import com.henghao.Garden.sessionFactory.SessionFactoryDao;

/**
 * function 合同管理模块访问数据库Java类
 * 
 * date 2017.04.20
 * 
 * @author 严彬荣
 */
@Repository
public class CompactManageDaolmpl extends SessionFactoryDao implements
		CompactManageDao {

	// 查询合同管理图片信息数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Compactmassage> queryCompactFileMassage(String pathId) {
		DetachedCriteria dc = DetachedCriteria.forClass(Compactmassage.class,
				"c");
		ProjectionList field = Projections.projectionList();
		field.add(Projections.property("c.path").as("path"));
		dc.add(Restrictions.and(Restrictions.eq("pathId", pathId),
				Restrictions.eq("isNo", 0)));
		dc.setProjection(field);
		return dc.getExecutableCriteria(super.getSessionfactroy()).list();
	}

	// 查询建设类合同数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<BuildCompact> queryBuildCompactDao(String uid) {
		DetachedCriteria dc = DetachedCriteria.forClass(BuildCompact.class);
		dc.add(Restrictions.and(Restrictions.eq("uid", uid),
				Restrictions.eq("isNo", 0)));
		dc.addOrder(Order.desc("id"));
		return dc.getExecutableCriteria(super.getSessionfactroy()).list();
	}

	// 查询园林类合同数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<GardenCompact> queryGardenCompact(String uid) {
		DetachedCriteria dc = DetachedCriteria.forClass(GardenCompact.class);
		dc.add(Restrictions.and(Restrictions.eq("uid", uid),
				Restrictions.eq("isNo", 0)));
		dc.addOrder(Order.desc("id"));
		return dc.getExecutableCriteria(super.getSessionfactroy()).list();
	}

	// 查询园林工程类合同数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<GardenEngineeringCompact> queryEngineeringCompact(String uid) {
		DetachedCriteria dc = DetachedCriteria
				.forClass(GardenEngineeringCompact.class);
		dc.add(Restrictions.and(Restrictions.eq("uid", uid),
				Restrictions.eq("isNo", 0)));
		dc.addOrder(Order.desc("id"));
		return dc.getExecutableCriteria(super.getSessionfactroy()).list();
	}

	// 查询景观类合同数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<LandscapeCompact> queryLandscapeCompact(String uid) {
		DetachedCriteria dc = DetachedCriteria.forClass(LandscapeCompact.class);
		dc.add(Restrictions.and(Restrictions.eq("uid", uid),
				Restrictions.eq("isNo", 0)));
		dc.addOrder(Order.desc("id"));
		return dc.getExecutableCriteria(super.getSessionfactroy()).list();
	}

	// 建设类合同数据保存dao方法
	@Override
	public void saveBuildCompactDao(BuildCompact msg) throws Exception {
		super.getSessionfactroy().save(msg);
		super.getSessionfactroy().clear();
	}

	// 园林类合同数据保存dao方法
	@Override
	public void saveGardenCompactDao(GardenCompact msg) throws Exception {
		super.getSessionfactroy().save(msg);
		super.getSessionfactroy().clear();
	}

	// 园林工程类合同数据保存dao方法
	@Override
	public void saveGardenEngineeringCompactDao(GardenEngineeringCompact msg)
			throws Exception {
		super.getSessionfactroy().save(msg);
		super.getSessionfactroy().clear();
	}

	// 景观合同数据保存dao方法
	@Override
	public void saveLandscapeCompact(LandscapeCompact msg) throws Exception {
		super.getSessionfactroy().save(msg);
		super.getSessionfactroy().clear();
	}

}
