package com.henghao.Garden.dao.daolmpl;

import com.henghao.Garden.SQLEntity.SQL;
import com.henghao.Garden.dao.DemandReleaseDao;
import com.henghao.Garden.entity.fileMassage.Filemassage;
import com.henghao.Garden.entity.leasing.*;
import com.henghao.Garden.sessionFactory.SessionFactoryDao;

import org.hibernate.criterion.*;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * function 需求发布模块访问数据库Java类
 * 
 * date 2017-03-28
 * 
 * @author 严彬荣
 */

@Repository
public class DemandReleaseDaolmpl extends SessionFactoryDao implements
		DemandReleaseDao {

	private SQL sql = new SQL();

	// 查询需求发布文件信息dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Filemassage> queryFilemessageDao(String uuid) {
		DetachedCriteria dc = DetachedCriteria.forClass(Filemassage.class, "f");
		ProjectionList field = Projections.projectionList();
		field.add(Property.forName("f.path").as("path"));
		dc.add(Restrictions.eq("photofile", uuid));
		dc.setProjection(field);
		return dc.getExecutableCriteria(super.getSessionfactroy()).list();
	}

	// 查询设备租赁信息数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Equipmentleasing> queryEquipmentLeasingDao() {
		// TODO Auto-generated method stub
		DetachedCriteria dc = DetachedCriteria.forClass(Equipmentleasing.class);
		dc.add(Restrictions.eq("isNo", 0));
		dc.addOrder(Order.desc("eid"));
		return dc.getExecutableCriteria(super.getSessionfactroy()).list();
	}

	// 查询用户发布的设备租赁信息dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Equipmentleasing> queryEquipmentLeasingByIdDao(String uid) {
		DetachedCriteria dc = DetachedCriteria.forClass(Equipmentleasing.class);
		dc.add(Restrictions.and(Restrictions.eq("uid", uid),
				Restrictions.eq("isNo", 0)));
		dc.addOrder(Order.desc("eid"));
		return dc.getExecutableCriteria(super.getSessionfactroy()).list();
	}

	// 查询发布苗木信息公共数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Seedlingmessage> querySeedlingmessageDao() {
		DetachedCriteria dc = DetachedCriteria.forClass(Seedlingmessage.class);
		dc.add(Restrictions.eq("isNo", 0));
		dc.addOrder(Order.desc("sid"));
		return dc.getExecutableCriteria(super.getSessionfactroy()).list();
	}

	// 按类型查询苗木信息公共数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Seedlingmessage> querySeedlingmessageByTypeDao(String type,
			String subclass) {
		DetachedCriteria dc = DetachedCriteria.forClass(Seedlingmessage.class);
		dc.add(Restrictions.and(Restrictions.eq("type", type),
				Restrictions.eq("isNo", 0)));
		if (subclass != null) {
			dc.add(Restrictions.eq("subclass", subclass));
		}
		dc.addOrder(Order.desc("sid"));
		return dc.getExecutableCriteria(super.getSessionfactroy()).list();
	}

	// 查询用户发布苗木信息数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Seedlingmessage> querySeedlingmessageByIdDao(String uid) {
		DetachedCriteria dc = DetachedCriteria.forClass(Seedlingmessage.class);
		dc.add(Restrictions.and(Restrictions.eq("uid", uid),
				Restrictions.eq("isNo", 0)));
		dc.addOrder(Order.desc("sid"));
		return dc.getExecutableCriteria(super.getSessionfactroy()).list();
	}

	// 查询发布招标信息公共数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Bid> queryBidDao() {
		DetachedCriteria dc = DetachedCriteria.forClass(Bid.class);
		dc.add(Restrictions.eqOrIsNull("isNo", 0));
		dc.addOrder(Order.desc("bid"));
		return dc.getExecutableCriteria(super.getSessionfactroy())
				.setFirstResult(0).setMaxResults(100).list();
	}

	// 查询发布人员招聘信息公共数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Recruit> queryRecruitDao() {
		DetachedCriteria dc = DetachedCriteria.forClass(Recruit.class);
		dc.add(Restrictions.eq("isNo", 0));
		dc.addOrder(Order.desc("rid"));
		return dc.getExecutableCriteria(super.getSessionfactroy()).list();
	}

	// 查询发布人员招聘信息数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Recruit> queryRecruitByIdDao(String uid) {
		DetachedCriteria dc = DetachedCriteria.forClass(Recruit.class);
		dc.add(Restrictions.and(Restrictions.eq("uid", uid),
				Restrictions.eq("isNo", 0)));
		dc.addOrder(Order.desc("rid"));
		return dc.getExecutableCriteria(super.getSessionfactroy()).list();
	}

	// 添加设备租赁发布信息数据dao方法
	@Override
	public void saveEquipmentLeasingDao(Equipmentleasing msg) throws Exception {
		super.getSessionfactroy().save(msg);
		super.getSessionfactroy().clear();
	}

	// 添加苗木发布信息数据dao方法
	@Override
	public void saveSeedlingmessageDao(Seedlingmessage msg) throws Exception {
		super.getSessionfactroy().save(msg);
		super.getSessionfactroy().clear();
	}

	// 添加人员招聘发布信息数据dao方法
	@Override
	public void saveRecruitDao(Recruit msg) throws Exception {
		super.getSessionfactroy().save(msg);
		super.getSessionfactroy().clear();
	}

	// 抓取招标信息数据dao方法
	@Override
	public void saveBidsDao(List<Bid> msg) throws Exception {
		for (int i = 0; i < msg.size(); i++) {

			if (i % 100 == 0) {
				super.getSessionfactroy().flush();
			}
			super.getSessionfactroy()
					.createSQLQuery(this.sql.getSaveBidMsgSql())
					.setParameter(0, msg.get(i).getTitleName())
					.setParameter(1, msg.get(i).getContent())
					.setParameter(2, msg.get(i).getContacts())
					.setParameter(3, msg.get(i).getTel())
					.setParameter(4, msg.get(i).getDates())
					.setParameter(5, msg.get(i).getUid()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

}
