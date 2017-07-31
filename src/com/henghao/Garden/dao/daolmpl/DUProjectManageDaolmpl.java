package com.henghao.Garden.dao.daolmpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.henghao.Garden.dao.DUProjectManageDao;
import com.henghao.Garden.resultEntity.BatchID;
import com.henghao.Garden.sessionFactory.SessionFactoryDao;

/**
 * function 项目管理模块更新批量删除访问数据dao方法库Java类
 * 
 * 
 * date 2017-04-12
 * 
 * @author 严彬荣
 */

@Repository
public class DUProjectManageDaolmpl extends SessionFactoryDao implements
		DUProjectManageDao {

	// 批量删除变更管理信息数据dao方法
	@Override
	public void deleteAlterationDao(List<BatchID> list) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			super.getSessionfactroy()
					.createSQLQuery(
							"update alteration set isNo=1 where uid=:uid and aid=:aid")
					.setParameter("uid", list.get(0).getUid())
					.setParameter("aid", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 批量删除工序报验信息数据dao方法
	@Override
	public void deleteCheckoutDao(List<BatchID> list) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			super.getSessionfactroy()
					.createSQLQuery(
							"update checkout set isNo=1 where uid=:uid and cid=:cid")
					.setParameter("uid", list.get(0).getUid())
					.setParameter("cid", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 批量删除施工日志信息数据dao方法
	@Override
	public void deleteConstructionLogDao(List<BatchID> list) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			super.getSessionfactroy()
					.createSQLQuery(
							"update constructionLog set isNo=1 where uid=:uid and cid=:cid")
					.setParameter("uid", list.get(0).getUid())
					.setParameter("cid", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 批量删除安全施工日志信息数据dao方法
	@Override
	public void deleteConstructionSafetyLogDao(List<BatchID> list)
			throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			super.getSessionfactroy()
					.createSQLQuery(
							"update constructionSafetyLog set isNo=1 where uid=:uid and cid=:cid")
					.setParameter("uid", list.get(0).getUid())
					.setParameter("cid", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 批量删除进度申报信息数据dao方法
	@Override
	public void deleteDeclarationDao(List<BatchID> list) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			super.getSessionfactroy()
					.createSQLQuery(
							"update declaration set isNo=1 where uid=:uid and did=:did")
					.setParameter("uid", list.get(0).getUid())
					.setParameter("did", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 批量删除设备信息信息数据dao方法
	@Override
	public void deleteEquipmentDao(List<BatchID> list) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			super.getSessionfactroy()
					.createSQLQuery(
							"update equipment set isNo=1 where uid=:uid and eid=:eid")
					.setParameter("uid", list.get(0).getUid())
					.setParameter("eid", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 批量删除竣工验收信息数据dao方法
	@Override
	public void deleteFinalacceptanceDao(List<BatchID> list) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			super.getSessionfactroy()
					.createSQLQuery(
							"update finalacceptance set isNo=1 where uid=:uid and fid=:fid")
					.setParameter("uid", list.get(0).getUid())
					.setParameter("fid", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 批量删除会审结果信息数据dao方法
	@Override
	public void deleteHsResultDao(List<BatchID> list) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			super.getSessionfactroy()
					.createSQLQuery(
							"update hs_result set isNo=1 where uid=:uid and hid=:hid")
					.setParameter("uid", list.get(0).getUid())
					.setParameter("hid", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 批量删除开工报告信息数据dao方法
	@Override
	public void deleteKgReportDao(List<BatchID> list) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			super.getSessionfactroy()
					.createSQLQuery(
							"update kg_report set isNo=1 where uid=:uid and kid=:kid")
					.setParameter("uid", list.get(0).getUid())
					.setParameter("kid", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 批量删除我的轨迹信息数据dao方法
	@Override
	public void deleteMylocusDao(List<BatchID> list) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			super.getSessionfactroy()
					.createSQLQuery(
							"update my_locus set isNo=1 where uid=:uid and mid=:mid")
					.setParameter("uid", list.get(0).getUid())
					.setParameter("mid", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 批量批量删除项目信息信息数据dao方法
	@Override
	public void deleteProjectDao(List<BatchID> list) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			super.getSessionfactroy()
					.createSQLQuery(
							"update project set isNo=1 where uid=:uid and pid=:pid")
					.setParameter("uid", list.get(0).getUid())
					.setParameter("pid", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 批量删除现场施工检验信息数据dao方法
	@Override
	public void deleteProspectDao(List<BatchID> list) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			super.getSessionfactroy()
					.createSQLQuery(
							"update prospect set isNo=1 where uid=:uid and ppid=:pid")
					.setParameter("uid", list.get(0).getUid())
					.setParameter("pid", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 批量删除项目结算信息数据dao方法
	@Override
	public void deleteSettlementDao(List<BatchID> list) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			super.getSessionfactroy()
					.createSQLQuery(
							"update settlement set isNo=1 where uid=:uid and sid=:sid")
					.setParameter("uid", list.get(0).getUid())
					.setParameter("sid", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 批量删除施工人员信息数据dao方法
	@Override
	public void deleteSgPersonnelDao(List<BatchID> list) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			super.getSessionfactroy()
					.createSQLQuery(
							"update sg_personnel set isNo=1 where uid=:uid and sid=:sid")
					.setParameter("uid", list.get(0).getUid())
					.setParameter("sid", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 批量删除监理日志信息数据dao方法
	@Override
	public void deleteSupervisionlogDao(List<BatchID> list) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			super.getSessionfactroy()
					.createSQLQuery(
							"update supervisionlog set isNo=1 where uid=:uid and sid=:sid")
					.setParameter("uid", list.get(0).getUid())
					.setParameter("sid", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 批量删除供货商信息数据dao方法
	@Override
	public void deleteSupplierDao(List<BatchID> list) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			super.getSessionfactroy()
					.createSQLQuery(
							"update supplier set isNo=1 where uid=:uid and sid=:sid")
					.setParameter("uid", list.get(0).getUid())
					.setParameter("sid", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

	// 批量删除技术交底信息数据dao方法
	@Override
	public void deleteTechnologyDao(List<BatchID> list) throws Exception {
		for (int i = 0, length = list.size(); i < length; i++) {
			super.getSessionfactroy()
					.createSQLQuery(
							"update technology set isNo=1 where uid=:uid and tid=:tid")
					.setParameter("uid", list.get(0).getUid())
					.setParameter("tid", list.get(i).getId()).executeUpdate();
		}
		super.getSessionfactroy().clear();
	}

}
