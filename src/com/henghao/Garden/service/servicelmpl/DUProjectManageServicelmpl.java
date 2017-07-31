package com.henghao.Garden.service.servicelmpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.henghao.Garden.dao.DUProjectManageDao;
import com.henghao.Garden.resultEntity.BatchID;
import com.henghao.Garden.resultEntity.Result;
import com.henghao.Garden.service.DUProjectManageService;

/**
 * function 项目管理模块更新删除业务逻辑Java类
 * 
 * @author 严彬荣
 */

@Service
public class DUProjectManageServicelmpl implements DUProjectManageService {

	/*
	 * private volatile static DUProjectManageServicelmpl instance;
	 * 
	 * private DUProjectManageServicelmpl() { }
	 * 
	 * public static DUProjectManageServicelmpl getinstance() { if (instance ==
	 * null) { synchronized (DUProjectManageServicelmpl.class) { if (instance ==
	 * null) instance = new DUProjectManageServicelmpl(); } } return instance; }
	 */

	@Resource
	private DUProjectManageDao dao;
	// 实例化结果集实体类,并定义为公共结果集
	private Result result = null;

	// 删除变更管理信息数据方法
	@Override
	public Result deleteAlterationService(List<BatchID> list) {
		try {
			this.dao.deleteAlterationDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("系统繁忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 删除工序报验信息数据方法
	@Override
	public Result deleteCheckoutService(List<BatchID> list) {
		try {
			this.dao.deleteCheckoutDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("系统繁忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 删除施工日志信息数据方法
	@Override
	public Result deleteConstructionLogService(List<BatchID> list) {
		try {
			this.dao.deleteConstructionLogDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("系统繁忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 删除安全施工日志信息数据方法
	@Override
	public Result deleteConstructionSafetyLogService(List<BatchID> list) {
		try {
			this.dao.deleteConstructionSafetyLogDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("系统繁忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 删除进度申报信息数据方法
	@Override
	public Result deleteDeclarationService(List<BatchID> list) {
		try {
			this.dao.deleteDeclarationDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("系统繁忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 删除设备信息信息数据方法
	@Override
	public Result deleteEquipmentService(List<BatchID> list) {
		try {
			this.dao.deleteEquipmentDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("系统繁忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 删除竣工验收信息数据方法
	@Override
	public Result deleteFinalacceptanceService(List<BatchID> list) {
		try {
			this.dao.deleteFinalacceptanceDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("系统繁忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 删除会审结果信息数据方法
	@Override
	public Result deleteHsResultService(List<BatchID> list) {
		try {
			this.dao.deleteHsResultDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("系统繁忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 删除开工报告信息数据方法
	@Override
	public Result deleteKgReportService(List<BatchID> list) {
		try {
			this.dao.deleteKgReportDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("系统繁忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 删除我的轨迹信息数据方法
	@Override
	public Result deleteMylocusService(List<BatchID> list) {
		try {
			this.dao.deleteMylocusDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("系统繁忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 批量删除项目信息信息数据方法
	@Override
	public Result deleteProjectService(List<BatchID> list) {
		try {
			this.dao.deleteProjectDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("系统繁忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 删除现场施工检验信息数据方法
	@Override
	public Result deleteProspectService(List<BatchID> list) {
		try {
			this.dao.deleteProspectDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("系统繁忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 删除项目结算信息数据方法
	@Override
	public Result deleteSettlementService(List<BatchID> list) {
		try {
			this.dao.deleteSettlementDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("系统繁忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 删除施工人员信息数据方法
	@Override
	public Result deleteSgPersonnelService(List<BatchID> list) {
		try {
			this.dao.deleteSgPersonnelDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("系统繁忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 删除监理日志信息数据方法
	@Override
	public Result deleteSupervisionlogService(List<BatchID> list) {
		try {
			this.dao.deleteSupervisionlogDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("系统繁忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 删除供货商信息数据方法
	@Override
	public Result deleteSupplierService(List<BatchID> list) {
		try {
			this.dao.deleteSupplierDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("系统繁忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 删除技术交底信息数据方法
	@Override
	public Result deleteTechnologyService(List<BatchID> list) {
		try {
			this.dao.deleteTechnologyDao(list);
			this.result = new Result("删除成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("系统繁忙，请稍后重试", 1);
		}
		return this.result;
	}
}
