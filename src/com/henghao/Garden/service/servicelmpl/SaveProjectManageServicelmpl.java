package com.henghao.Garden.service.servicelmpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.henghao.Garden.dao.QueryProjectManageDao;
import com.henghao.Garden.dao.SaveProjectManageDao;
import com.henghao.Garden.entity.project.*;
import com.henghao.Garden.entity.user.Wallet;
import com.henghao.Garden.resultEntity.Result;
import com.henghao.Garden.service.SaveProjectManageService;

/**
 * function 项目管理信息保存模块业务逻辑Java类
 * 
 * @author 严彬荣
 */
@Service
public class SaveProjectManageServicelmpl implements SaveProjectManageService {

	@Resource
	private SaveProjectManageDao dao;
	@Resource
	private QueryProjectManageDao queryDao;
	// 实例化结果集实体类,并定义为公共结果集
	private Result result = null;

	// 添加我的轨迹信息数据方法
	@Override
	public Result saveMylocusMsgService(Mylocus msg) {
		try {
			this.dao.saveMylocusMsgDao(msg);
			this.result = new Result("保存成功", 0);
		} catch (Exception e) {
			this.result = new Result("服务器繁忙，请稍后重试", 1);
			e.printStackTrace();
		}
		return this.result;
	}

	// 添加会审结果信息数据方法
	@Override
	public Result saveHsResultMsgService(HsResult msg) {
		try {
			this.dao.saveHsResultMsgDao(msg);
			this.result = new Result("保存成功", 0);
		} catch (Exception e) {
			this.result = new Result("服务器繁忙，请稍后重试", 1);
			e.printStackTrace();
		}
		return this.result;
	}

	// 添加开工报告信息数据方法
	@Override
	public Result saveKgReportMsgService(KgReport msg) {
		try {
			this.dao.saveKgReportMsgDao(msg);
			this.result = new Result("保存成功", 0);
		} catch (Exception e) {
			this.result = new Result("系统繁忙，请稍后重试", 1);
			e.printStackTrace();
		}
		return this.result;
	}

	// 添加项目信息数据方法
	@Override
	public Result saveProjectMsgService(Project msg) {
		try {
			Project pro = this.queryDao.queryProjectMsgByNameDao(
					msg.getXmName(), msg.getUid());
			if (pro != null) {
				this.result = new Result("项目名称不可重复", 1);
				return this.result;
			}
			this.dao.saveProjectMsgDao(msg);
			this.result = new Result("保存成功", 0);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = new Result("系统繁忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 添加现场检验信息数据方法
	@Override
	public Result saveCheckoutMsgService(Checkout msg) {
		try {
			this.dao.saveCheckoutMsgDao(msg);
			this.result = new Result("保存成功", 0);
		} catch (Exception e) {
			this.result = new Result("服务器繁忙，请稍后重试！", 1);
			e.printStackTrace();
		}
		return this.result;
	}

	// 添加设备信息数据方法
	@Override
	public Result saveEquipmentMsgService(Equipment msg) {
		try {
			this.dao.saveEquipmentMsgDao(msg);
			this.result = new Result("保存成功", 0);
		} catch (Exception e) {
			this.result = new Result("服务器繁忙，请稍后重试", 1);
			e.printStackTrace();
		}
		return this.result;
	}

	// 添加施工人员信息数据方法
	@Override
	public Result saveSgPersonnelMsgService(SgPersonnel msg) {
		try {
			this.dao.saveSgPersonnelMsgDao(msg);
			this.result = new Result("添加成功", 0);
		} catch (Exception e) {
			this.result = new Result("服务器繁忙，请稍后重试", 1);
			e.printStackTrace();
		}
		return this.result;
	}

	// 添加现场施工检验信息数据方法
	@Override
	public Result saveProspectMsgService(Prospect msg) {
		try {
			this.dao.saveProspectMsgDao(msg);
			this.result = new Result("添加成功", 0);
		} catch (Exception e) {
			this.result = new Result("服务器繁忙，请稍后重试", 1);
			e.printStackTrace();
		}
		return this.result;
	}

	// 添加供货商信息数据方法
	@Override
	public Result saveSupplierMsgService(Supplier msg) {
		try {
			this.dao.saveSupplierMsgDao(msg);
			this.result = new Result("添加成功", 0);
		} catch (Exception e) {
			this.result = new Result("服务器繁忙，请稍后重试", 1);
			e.printStackTrace();
		}
		return this.result;
	}

	// 添加变更管理信息数据方法
	@Override
	public Result saveAlterationMsgService(Alteration msg) {
		try {
			this.dao.saveAlterationMsgDao(msg);
			this.result = new Result("修改成功", 0);
		} catch (Exception e) {
			this.result = new Result("服务器繁忙，请稍后重试", 1);
			e.printStackTrace();
		}
		return this.result;
	}

	// 添加技术交底信息数据方法
	@Override
	public Result saveTechnologyMsgService(Technology msg) {
		try {
			this.dao.saveTechnologyMsgDao(msg);
			this.result = new Result("保存成功", 0);
		} catch (Exception e) {
			this.result = new Result("服务器繁忙，请稍后重试", 1);
			e.printStackTrace();
		}
		return this.result;
	}

	// 用户注册后初始化我的钱包信息数据方法
	@Override
	public Result saveWalletMsgService(Wallet msg) {
		try {
			this.dao.saveWalletMsgDao(msg);
			this.result = new Result("添加成功", 0);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = new Result("服务器繁忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 添加申报进度信息数据方法
	@Override
	public Result saveDeclarationMsgService(Declaration msg) {
		try {
			this.dao.saveDeclarationMsgDao(msg);
			this.result = new Result("添加成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器繁忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 添加结算信息数据方法
	@Override
	public Result saveSettlementMsgService(Settlement msg) {
		try {
			this.dao.saveSettlementMsgDao(msg);
			this.result = new Result("添加成功", 0);
		} catch (Exception e) {
			this.result = new Result("服务器繁忙，请稍后重试", 1);
			e.printStackTrace();
		}
		return this.result;
	}

	// 添加施工日志信息数据方法
	@Override
	public Result saveConstructionLogMsgService(ConstructionLog msg) {
		try {
			this.dao.saveConstructionLogMsgDao(msg);
			this.result = new Result("添加成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.result = new Result("服务器繁忙，请稍后再试", 1);
			e.printStackTrace();
		}
		return this.result;
	}

	// 添加监理日志信息数据方法
	@Override
	public Result saveSupervisionlogMsgService(Supervisionlog msg) {
		try {
			this.dao.saveSupervisionlogMsgDao(msg);
			this.result = new Result("添加成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.result = new Result("服务器繁忙，请稍后再试", 1);
			e.printStackTrace();
		}
		return this.result;
	}

	// 添加竣工验收信息数据方法
	@Override
	public Result saveFinalacceptanceMsgService(Finalacceptance msg) {
		try {
			this.dao.saveFinalacceptanceMsgDao(msg);
			this.result = new Result("添加成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.result = new Result("服务器繁忙，请稍后再试", 1);
			e.printStackTrace();
		}
		return this.result;
	}

	// 添加施工安全日志信息数据方法
	@Override
	public Result saveConstructionSafetyLogMsgService(ConstructionSafetyLog msg) {
		try {
			this.dao.saveConstructionSafetyLogMsgDao(msg);
			this.result = new Result("添加成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("系统繁忙，请稍后再试", 1);
		}
		return this.result;
	}
}
