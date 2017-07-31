package com.henghao.Garden.dao.daolmpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.henghao.Garden.SQLEntity.SQL;
import com.henghao.Garden.dao.YHManageDao;
import com.henghao.Garden.entity.conservation.*;

/**
 * function 养护管理模块访问数据库Java类
 * 
 * @author 严彬荣
 */
@Repository
public class YHManageDaoImpl implements YHManageDao {

	@Resource
	private SessionFactory factory;
	private SQL sql = new SQL();

	// 查询全部树木信息方法dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryAllTreeMassageDao() {
		return this.factory.getCurrentSession().createQuery("from TreeMassage")
				.list();
	}

	// 通过养护状态（二维码）查询树木信息dao方法
	@Override
	public TreeMassage queryTreeMassageByIdDao(String chip) {
		return (TreeMassage) this.factory.getCurrentSession()
				.createQuery("from TreeMassage where treeId =:treeId")
				.setParameter("treeId", chip).uniqueResult();
	}

	// 查询养护工作记录信息数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryYhstatusDao(String date, String uid) {
		return this.factory
				.getCurrentSession()
				.createQuery(
						"from YhStatus where uid=:uid and yhStatustime like :date order by yid desc")
				.setParameter("date", "%" + date + "%")
				.setParameter("uid", uid).list();
	}

	// 通过状态查询养护信息数据dao方法
	@Override
	public YhStatus queryYhmassageByIdDao(String uid) {
		return (YhStatus) this.factory.getCurrentSession()
				.createQuery("from YhStatus where uid=:uid order by yid desc")
				.setParameter("uid", uid).uniqueResult();
	}

	// 查询当天已扫过的植物信息dao方法
	@Override
	public YhStatus queryNowTree(String chip, String date) {
		return (YhStatus) this.factory.getCurrentSession()
				.createQuery(this.sql.getQueryNowTreeSql())
				.setParameter(0, chip).setParameter(1, "%" + date + "%")
				.uniqueResult();
	}

	// 查询管护信息数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryGhmsgDao() {
		return this.factory.getCurrentSession()
				.createQuery("from GhManage order by gid desc").list();
	}

	// 查询管护信息数据通过植物编号dao方法
	@Override
	public GhManage queryGhmsgByidDao(String treeId, int yid, String uid) {
		return (GhManage) this.factory
				.getCurrentSession()
				.createQuery(
						"from GhManage where treeId=:treeId and yid=:yid and uid=:uid")
				.setParameter("treeId", treeId).setParameter("yid", yid)
				.setParameter("uid", uid).uniqueResult();
	}

	// 植物信息保存dao方法
	@Override
	public void saveTreeMassageDao(TreeMassage tree) throws Exception {
		this.factory.getCurrentSession()
				.createSQLQuery(sql.getSaveTreeMsgSql())
				.setParameter(0, tree.getTreeId())
				.setParameter(1, tree.getTreeName())
				.setParameter(2, tree.getTreeUse())
				.setParameter(3, tree.getTreeSpecification())
				.setParameter(4, tree.getTreeSite())
				.setParameter(5, tree.getTreeTime())
				.setParameter(6, tree.getTreeMigratetime())
				.setParameter(7, tree.getMigratesite())
				.setParameter(8, tree.getMigratedetaile()).executeUpdate();
		this.factory.getCurrentSession().clear();
	}

	// 养护工作记录信息数据保存dao方法
	@Override
	public void saveYhstatusDao(YhStatus msg) throws Exception {
		this.factory.getCurrentSession().save(msg);
		this.factory.getCurrentSession().clear();
	}

	// 管护信息数据保存dao方法
	@Override
	public void saveGhmsgDao(GhManage msg) throws Exception {
		this.factory.getCurrentSession().save(msg);
		this.factory.getCurrentSession().clear();

	}

	// 更新管护状态dao接口
	@Override
	public void updateYhstatusDao(int yid) throws Exception {
		this.factory.getCurrentSession()
				.createSQLQuery("update yh_status set is_no=1 where yid=:yid")
				.setParameter("yid", yid).executeUpdate();
		this.factory.getCurrentSession().clear();

	}

}
