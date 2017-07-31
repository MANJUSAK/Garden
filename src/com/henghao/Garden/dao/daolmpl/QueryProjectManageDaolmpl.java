package com.henghao.Garden.dao.daolmpl;

import org.hibernate.criterion.*;

import com.henghao.Garden.SQLEntity.SQL;
import com.henghao.Garden.dao.QueryProjectManageDao;
import com.henghao.Garden.entity.fileMassage.*;
import com.henghao.Garden.entity.project.*;
import com.henghao.Garden.entity.user.Wallet;
import com.henghao.Garden.entityvo.ConstructionSafetyLogVo;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

/**
 * function 项目模块信息查询访问数据库Java类
 * 
 * @author 严彬荣
 */
@Repository
public class QueryProjectManageDaolmpl implements QueryProjectManageDao {

	// 注入session工厂
	@Resource
	private SessionFactory factory;

	private SQL sql = new SQL();

	// 查询我的轨迹数据信息dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Mylocus> queryMylocusMsgDao(String uid) {
		return this.factory
				.getCurrentSession()
				.createQuery(
						"from Mylocus where uid=:uid and isNo=0 order by mid desc")
				.setParameter("uid", uid).list();
	}

	// 查询会审结果数据信息dao方法
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<HsResult> queryHsResultMsgDao(String uid) {
		return this.factory.getCurrentSession()
				.createSQLQuery(this.sql.getHsResultSql())
				.setResultTransformer(Transformers.aliasToBean(HsResult.class))
				.setParameter("uid", uid).list();
	}

	// 查询开工报告数据信息dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<KgReport> queryKgReportMsgDao(String uid) {
		return this.factory.getCurrentSession()
				.createSQLQuery(this.sql.getKgReportSql())
				.setParameter("uid", uid)
				.setResultTransformer(Transformers.aliasToBean(KgReport.class))
				.list();
	}

	// 查询项目信息数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Project> queryProjectMsgDao(String uid) {
		return this.factory
				.getCurrentSession()
				.createQuery(
						"from Project where uid=:uid and isNo=0 order by pid desc")
				.setParameter("uid", uid).list();
	}

	// 查询项目信息通过项目名称dao方法
	@Override
	public Project queryProjectMsgByNameDao(String xmName, String uid) {
		return (Project) this.factory
				.getCurrentSession()
				.createQuery(
						"select new Project(pid,xmName) from Project where xm_name=:name and uid=:uid and isNo=0")
				.setParameter("name", xmName).setParameter("uid", uid)
				.uniqueResult();
	}

	// 查询现场检验数据信息dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Checkout> queryCheckoutMsgDao(String uid) {
		return this.factory
				.getCurrentSession()
				.createQuery(
						"from Checkout where uid=:uid and isNo=0 order by cid desc")
				.setParameter("uid", uid).list();
	}

	// 查询设备信息数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Equipment> queryEquipmentMsgDao(String uid) {
		return this.factory
				.getCurrentSession()
				.createSQLQuery(this.sql.getEquipmentSql())
				.setParameter("uid", uid)
				.setResultTransformer(Transformers.aliasToBean(Equipment.class))
				.list();
	}

	// 查询施工人员信息数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<SgPersonnel> querySgPersonnelMsgDao(String uid) {
		return this.factory
				.getCurrentSession()
				.createSQLQuery(this.sql.getSgPersonnelSql())
				.setParameter("uid", uid)
				.setResultTransformer(
						Transformers.aliasToBean(SgPersonnel.class)).list();
	}

	// 查询现场施工检验信息数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Prospect> queryProspectMsgDao(String uid) {
		return this.factory.getCurrentSession()
				.createSQLQuery(this.sql.getProspectSql())
				.setParameter("uid", uid)
				.setResultTransformer(Transformers.aliasToBean(Prospect.class))
				.list();
	}

	// 查询供货商信息数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> querySupplierMsgDao(String uid) {
		return this.factory.getCurrentSession()
				.createSQLQuery(this.sql.getSupplierSql())
				.setParameter("uid", uid)
				.setResultTransformer(Transformers.aliasToBean(Supplier.class))
				.list();
	}

	// 查询项目管理文件信息dao方法
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Filemassage> queryFilemassage(String uuid) {
		DetachedCriteria dc = DetachedCriteria.forClass(Filemassage.class, "f");
		ProjectionList field = Projections.projectionList();
		field.add(Projections.property("f.path").as("path"));
		dc.add(Restrictions.eq("photofile", uuid));
		dc.setProjection(field);
		return dc.getExecutableCriteria(this.factory.getCurrentSession())
				.list();
	}

	// 查询变更管理信息数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Alteration> queryAlterationMagDao(String uid) {
		return this.factory
				.getCurrentSession()
				.createSQLQuery(this.sql.getAlterationSql())
				.setParameter("uid", uid)
				.setResultTransformer(
						Transformers.aliasToBean(Alteration.class)).list();
	}

	// 查询技术交底信息数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Technology> queryTechnologyMsgDao(String uid) {
		return this.factory
				.getCurrentSession()
				.createSQLQuery(this.sql.getTechnologySql())
				.setParameter("uid", uid)
				.setResultTransformer(
						Transformers.aliasToBean(Technology.class)).list();
	}

	// 查询我的钱包信息数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Wallet> queryWalletMsgDao(String uid) {
		return this.factory
				.getCurrentSession()
				.createQuery(
						"from Wallet where uid=:uid and isNo=0 order by wid desc")
				.setParameter("uid", uid).list();
	}

	// 查询申报进度信息dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Declaration> queryDeclarationMsgDao(String uid) {
		return this.factory
				.getCurrentSession()
				.createSQLQuery(this.sql.getDeclarationSql())
				.setParameter("uid", uid)
				.setResultTransformer(
						Transformers.aliasToBean(Declaration.class)).list();
	}

	// 查询结算信息数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Settlement> querySettlementMsgDao(String uid) {
		return this.factory
				.getCurrentSession()
				.createSQLQuery(this.sql.getSettlementSql())
				.setParameter("uid", uid)
				.setResultTransformer(
						Transformers.aliasToBean(Settlement.class)).list();
	}

	// 查询施工日志信息数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<ConstructionLog> queryConstructionLogMsgDao(String uid) {
		return this.factory
				.getCurrentSession()
				.createSQLQuery(this.sql.getConstructionLogSql())
				.setParameter("uid", uid)
				.setResultTransformer(
						Transformers.aliasToBean(ConstructionLog.class)).list();
	}

	// 通过用户编号查询文件信息dao方法
	@Override
	public Excelmassage queryFileMsgDao(String uid) {
		return (Excelmassage) this.factory.getCurrentSession()
				.createQuery("from Excelmassage where uid=:uid and isNo=0")
				.setParameter("uid", uid).uniqueResult();
	}

	// 查询监理日志信息数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Supervisionlog> querySupervisionlogMsgDao(String uid) {
		return this.factory
				.getCurrentSession()
				.createQuery(
						"from Supervisionlog where uid=:uid and isNo=0 order by sid desc")
				.setParameter("uid", uid).list();
	}

	// 查询竣工验收信息数据dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Finalacceptance> queryFinalacceptanceMsgDao(String uid) {
		return this.factory
				.getCurrentSession()
				.createQuery(
						"from Finalacceptance where uid=:uid and isNo=0 order by fid desc")
				.setParameter("uid", uid).list();
	}

	// 查询施工安全日志概要信息dao方法
	@SuppressWarnings("unchecked")
	@Override
	public List<ConstructionSafetyLogVo> querySummaryLogMsgDao(String uid) {
		return this.factory
				.getCurrentSession()
				.createSQLQuery(this.sql.getSummaryOfConstructionLogSql())
				.setParameter("uid", uid)
				.setResultTransformer(
						Transformers.aliasToBean(ConstructionSafetyLogVo.class))
				.list();
	}
}
