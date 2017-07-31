package com.henghao.Garden.dao.daolmpl;

import com.henghao.Garden.dao.SaveProjectManageDao;
import com.henghao.Garden.entity.project.*;
import com.henghao.Garden.entity.user.Wallet;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * function 项目管理信息保存模块访问数据库Java类
 * 
 * @author 严彬荣
 */
@Repository
public class SaveProjectManageDaolmpl implements SaveProjectManageDao {

	@Resource
	private SessionFactory factory;

	// 保存我的轨迹信息数据dao方法
	@Override
	public void saveMylocusMsgDao(Mylocus msg) throws Exception {
		this.factory.getCurrentSession().save(msg);
		this.factory.getCurrentSession().clear();
	}

	// 保存项目图纸信息数据dao方法
	@Override
	public void saveHsResultMsgDao(HsResult msg) throws Exception {
		this.factory.getCurrentSession().save(msg);
		this.factory.getCurrentSession().clear();
	}

	// 添加开工报告数据信息dao方法
	@Override
	public void saveKgReportMsgDao(KgReport msg) throws Exception {
		this.factory.getCurrentSession().save(msg);
		this.factory.getCurrentSession().clear();
	}

	// 添加项目数据信息dao方法
	@Override
	public void saveProjectMsgDao(Project msg) throws Exception {
		this.factory.getCurrentSession().save(msg);
		this.factory.getCurrentSession().clear();
	}

	// 添加现场检验信息数据dao方法
	@Override
	public void saveCheckoutMsgDao(Checkout msg) throws Exception {
		this.factory.getCurrentSession().save(msg);
		this.factory.getCurrentSession().clear();
	}

	// 添加设备信息数据dao方法
	@Override
	public void saveEquipmentMsgDao(Equipment msg) throws Exception {
		this.factory.getCurrentSession().save(msg);
		this.factory.getCurrentSession().clear();
	}

	// 添加施工人员信息数据dao方法
	@Override
	public void saveSgPersonnelMsgDao(SgPersonnel msg) throws Exception {
		this.factory.getCurrentSession().save(msg);
		this.factory.getCurrentSession().clear();
	}

	// 添加现场勘探信息数据dao方法
	@Override
	public void saveProspectMsgDao(Prospect msg) throws Exception {
		this.factory.getCurrentSession().save(msg);
		this.factory.getCurrentSession().clear();
	}

	// 添加供货商信息数据dao方法
	@Override
	public void saveSupplierMsgDao(Supplier msg) throws Exception {
		this.factory.getCurrentSession().save(msg);
		this.factory.getCurrentSession().clear();
	}

	// 添加变更管理信息数据dao方法
	@Override
	public void saveAlterationMsgDao(Alteration msg) throws Exception {
		this.factory.getCurrentSession().saveOrUpdate(msg);
		this.factory.getCurrentSession().clear();
	}

	// 添加技术交底信息数据dao方法
	@Override
	public void saveTechnologyMsgDao(Technology msg) throws Exception {
		this.factory.getCurrentSession().save(msg);
		this.factory.getCurrentSession().clear();
	}

	// 用户注册后初始化我的钱包信息数据dao方法
	@Override
	public void saveWalletMsgDao(Wallet msg) throws Exception {
		this.factory.getCurrentSession().save(msg);
		this.factory.getCurrentSession().clear();
	}

	// 添加申报进度信息数据dao方法
	@Override
	public void saveDeclarationMsgDao(Declaration msg) throws Exception {
		this.factory.getCurrentSession().save(msg);
		this.factory.getCurrentSession().clear();
	}

	// 添加结算信息数据dao方法
	@Override
	public void saveSettlementMsgDao(Settlement msg) throws Exception {
		this.factory.getCurrentSession().save(msg);
		this.factory.getCurrentSession().clear();
	}

	// 添加施工日志信息数据dao方法
	@Override
	public void saveConstructionLogMsgDao(ConstructionLog msg) throws Exception {
		this.factory.getCurrentSession().save(msg);
		this.factory.getCurrentSession().clear();
	}

	// 添加监理日志信息数据dao方法
	@Override
	public void saveSupervisionlogMsgDao(Supervisionlog msg) throws Exception {
		this.factory.getCurrentSession().save(msg);
		this.factory.getCurrentSession().clear();
	}

	// 添加竣工验收信息数据dao方法
	@Override
	public void saveFinalacceptanceMsgDao(Finalacceptance msg) throws Exception {
		this.factory.getCurrentSession().save(msg);
		this.factory.getCurrentSession().clear();
	}

	// 添加施工安全日志信息数据dao方法
	@Override
	public void saveConstructionSafetyLogMsgDao(ConstructionSafetyLog msg)
			throws Exception {
		this.factory.getCurrentSession().save(msg);
		this.factory.getCurrentSession().clear();
	}
}
