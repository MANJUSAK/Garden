package com.henghao.Garden.formFilter;

import com.henghao.Garden.entity.project.*;

/**
 * function 项目管理表单验证工具类
 * 
 * date 2017.05.25
 * 
 * @author 严彬荣
 */
public class ProjectFormFilter {
	/* 创建本类为单例模式 */
	private volatile static ProjectFormFilter instance;

	private ProjectFormFilter() {
	}

	public static ProjectFormFilter getInstance() {
		if (instance == null) {
			synchronized (ProjectFormFilter.class) {
				if (instance == null)
					instance = new ProjectFormFilter();
			}
		}
		return instance;
	}

	// 手机号正则
	private final String TEL = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[^4,5-9]))\\d{8}$";
	// 身份证号码正则
	private final String IDCARD = "(^\\d{18}$)|(^\\d{15}$)";

	// 施工人员表单验证
	public boolean sgPersonnelForm(SgPersonnel msg) {
		if (msg.getPersonnelType() == null || msg.getPsIdcard() == null
				|| msg.getPsName() == null || msg.getPsTel() == null
				|| msg.getUid() == null || msg.getPid() == null
				|| msg.getWorkPost() == null) {
			return false;
		}
		if (msg.getPersonnelType().length() < 1
				|| msg.getPersonnelType().length() > 10) {
			return false;
		} else if (!msg.getPsIdcard().matches(this.IDCARD)) {
			return false;
		} else if (msg.getPsName().length() < 1
				|| msg.getPsName().length() > 50) {
			return false;
		} else if (!msg.getPsTel().matches(this.TEL)) {
			return false;
		} else if (msg.getUid().length() < 1 || msg.getUid().length() > 32) {
			return false;
		} else if (msg.getWorkPost().length() < 1
				|| msg.getWorkPost().length() > 10) {
			return false;
		} else if (msg.getPid().longValue() < 1
				|| msg.getPid().longValue() > 1000000000) {
			return false;
		} else {
			return true;
		}
	}

	// 项目信息表单验证
	public boolean projectForm(Project msg) {
		if (msg.getCompletionTime() == null
				|| msg.getConstructionUnit() == null
				|| msg.getStartTime() == null || msg.getUid() == null
				|| msg.getXmAdd() == null || msg.getXmContact() == null
				|| msg.getXmName() == null || msg.getXmPerson() == null
				|| msg.getXmPersonNum() == null) {
			return false;
		}
		if (msg.getCompletionTime().length() < 1
				|| msg.getCompletionTime().length() > 30) {
			return false;
		} else if (msg.getConstructionUnit().length() < 1
				|| msg.getConstructionUnit().length() > 50) {
			return false;
		} else if (msg.getStartTime().length() < 1
				|| msg.getStartTime().length() > 30) {
			return false;
		} else if (msg.getUid().length() < 1 || msg.getUid().length() > 32) {
			return false;
		} else if (msg.getXmAdd().length() < 1 || msg.getXmAdd().length() > 150) {
			return false;
		} else if (msg.getXmContact().length() < 1
				|| msg.getXmContact().length() > 15) {
			return false;
		} else if (msg.getXmName().length() < 1
				|| msg.getXmName().length() > 150) {
			return false;
		} else if (msg.getXmPerson().length() < 1
				|| msg.getXmPerson().length() > 30) {
			return false;
		} else if (msg.getXmPersonNum().longValue() < 1
				|| msg.getXmPersonNum().longValue() > 100000000) {
			return false;
		} else {
			return true;
		}
	}

	// 我的轨迹表单验证
	public boolean locusForm(Mylocus msg) {
		if (msg.getDates() == null || msg.getDetails() == null
				|| msg.getPersonnel() == null || msg.getUid() == null
				|| msg.getWorkType() == null) {
			return false;
		}
		if (msg.getDates().length() < 1 || msg.getDates().length() > 30) {
			return false;
		} else if (msg.getDetails().length() < 1
				|| msg.getDetails().length() > 300) {
			return false;
		} else if (msg.getPersonnel().length() < 1
				|| msg.getPersonnel().length() > 50) {
			return false;
		} else if (msg.getUid().length() < 1 || msg.getUid().length() > 32) {
			return false;
		} else if (msg.getWorkType().length() < 1
				|| msg.getWorkType().length() > 20) {
			return false;
		} else {
			return true;
		}
	}

	// 设备信息表单验证
	public boolean equipmentForm(Equipment msg) {
		if (msg.getSbName() == null || msg.getSbNum() == null
				|| msg.getSbPurpose() == null || msg.getSbSource() == null
				|| msg.getSbSpec() == null || msg.getUid() == null
				|| msg.getPid() == null) {
			return false;
		}
		if (msg.getSbName().length() < 1 || msg.getSbName().length() > 50) {
			return false;
		} else if (msg.getSbNum().longValue() < 1
				|| msg.getSbNum().longValue() > 1000000000) {
			return false;
		} else if (msg.getSbPurpose().length() < 1
				|| msg.getSbPurpose().length() > 50) {
			return false;
		} else if (msg.getSbSource().length() < 1
				|| msg.getSbSource().length() > 50) {
			return false;
		} else if (msg.getSbSpec().length() < 1
				|| msg.getSbSpec().length() > 300) {
			return false;
		} else if (msg.getUid().length() < 1 || msg.getUid().length() > 32) {
			return false;
		} else if (msg.getPid().longValue() < 1
				|| msg.getPid().longValue() > 1000000000) {
			return false;
		} else {
			return true;
		}
	}

	// 施工日志表单验证
	public boolean constructionLogForm(ConstructionLog msg) {
		if (msg.getBuilder() == null || msg.getDates() == null
				|| msg.getProactContent() == null
				|| msg.getTechnicalIndex() == null || msg.getUid() == null
				|| msg.getPid() == null || msg.getWorkingCondition() == null
				|| msg.getPrincipal() == null) {
			return false;
		}
		if (msg.getBuilder().length() < 1 || msg.getBuilder().length() > 15) {
			return false;
		} else if (msg.getDates().length() < 1 || msg.getDates().length() > 30) {
			return false;
		} else if (msg.getPrincipal().length() < 1
				|| msg.getPrincipal().length() > 10) {
			return false;
		} else if (msg.getProactContent().length() < 1
				|| msg.getProactContent().length() > 500) {
			return false;
		} else if (msg.getTechnicalIndex().length() < 1
				|| msg.getTechnicalIndex().length() > 500) {
			return false;
		} else if (msg.getUid().length() < 1 || msg.getUid().length() > 32) {
			return false;
		} else if (msg.getWorkingCondition().length() < 1
				|| msg.getWorkingCondition().length() > 500) {
			return false;
		} else if (msg.getPid().longValue() < 1
				|| msg.getPid().longValue() > 1000000000) {
			return false;
		} else {
			return true;
		}
	}

	// 监理日志表单验证
	public boolean supervisionlogForm(Supervisionlog msg) {
		if (msg.getDates() == null || msg.getEngineer() == null
				|| msg.getNoteTaker() == null || msg.getOther() == null
				|| msg.getProgressSituation() == null
				|| msg.getProjectName() == null || msg.getQuestion() == null
				|| msg.getSupervisionPosition() == null || msg.getUid() == null
				|| msg.getPid() == null || msg.getWorkingSitustion() == null) {
			return false;
		}
		if (msg.getDates().length() < 1 || msg.getDates().length() > 30) {
			return false;
		} else if (msg.getEngineer().length() < 1
				|| msg.getEngineer().length() > 15) {
			return false;
		} else if (msg.getNoteTaker().length() < 1
				|| msg.getNoteTaker().length() > 15) {
			return false;
		} else if (msg.getOther().length() < 1 || msg.getOther().length() > 300) {
			return false;
		} else if (msg.getProgressSituation().length() < 1
				|| msg.getProgressSituation().length() > 500) {
			return false;
		} else if (msg.getProjectName().length() < 1
				|| msg.getProjectName().length() > 50) {
			return false;
		} else if (msg.getQuestion().length() < 1
				|| msg.getQuestion().length() > 300) {
			return false;
		} else if (msg.getSupervisionPosition().length() < 1
				|| msg.getSupervisionPosition().length() > 50) {
			return false;
		} else if (msg.getUid().length() < 1 || msg.getUid().length() > 32) {
			return false;
		} else if (msg.getWorkingSitustion().length() < 1
				|| msg.getWorkingSitustion().length() > 500) {
			return false;
		} else if (msg.getPid().longValue() < 1
				|| msg.getPid().longValue() > 1000000000) {
			return false;
		} else {
			return true;
		}
	}

	// 施工安全日志表单验证
	public boolean constructionSafetyLogForm(ConstructionSafetyLog msg) {
		if (msg.getConstructionDynamic() == null
				|| msg.getConstructionSite() == null || msg.getDates() == null
				|| msg.getFillPeople() == null || msg.getPid() == null
				|| msg.getSafetyProblems() == null
				|| msg.getSafetySituation() == null || msg.getUid() == null) {
			return false;
		}
		if (msg.getConstructionDynamic().length() < 1
				|| msg.getConstructionDynamic().length() > 500) {
			return false;
		} else if (msg.getConstructionSite().length() < 1
				|| msg.getConstructionSite().length() > 50) {
			return false;
		} else if (msg.getDates().length() < 1 || msg.getDates().length() > 30) {
			return false;
		} else if (msg.getFillPeople().length() < 1
				|| msg.getDates().length() > 15) {
			return false;
		} else if (msg.getPid().longValue() < 1 || msg.getPid() > 1000000000) {
			return false;
		} else if (msg.getSafetyProblems().length() < 1
				|| msg.getSafetyProblems().length() > 300) {
			return false;
		} else if (msg.getSafetySituation().length() < 1
				|| msg.getSafetySituation().length() > 500) {
			return false;
		} else if (msg.getUid().length() < 1 || msg.getUid().length() > 32) {
			return false;
		} else {
			return true;
		}
	}

	// 进度申报表单验证
	public boolean declarationForm(Declaration msg) {
		if (msg.getDates() == null || msg.getPid() == null
				|| msg.getUid() == null) {
			return false;
		}
		if (msg.getDates().length() < 1 || msg.getDates().length() > 30) {
			return false;
		} else if (msg.getPid().longValue() < 1
				|| msg.getPid().longValue() > 100000000) {
			return false;
		} else if (msg.getUid().length() < 1 || msg.getUid().length() > 32) {
			return false;
		} else {
			return true;
		}
	}

	// 会审结果表单验证
	public boolean hsResultForm(HsResult msg) {
		if (msg.getHsDeparment() == null || msg.getPid() == null
				|| msg.getUid() == null) {
			return false;
		}
		if (msg.getHsDeparment().length() < 1
				|| msg.getHsDeparment().length() > 150) {
			return false;
		} else if (msg.getPid().longValue() < 1
				|| msg.getPid().longValue() > 1000000000) {
			return false;
		} else if (msg.getUid().length() < 1 || msg.getUid().length() > 32) {
			return false;
		} else {
			return true;
		}
	}

	// 开工报告表单验证
	public boolean kgReportForm(KgReport msg) {
		if (msg.getKgTime() == null || msg.getPid() == null
				|| msg.getUid() == null) {
			return false;
		}
		if (msg.getKgTime().length() < 1 || msg.getKgTime().length() > 30) {
			return false;
		} else if (msg.getPid().longValue() < 1
				|| msg.getPid().longValue() > 1000000000) {
			return false;
		} else if (msg.getUid().length() < 1 || msg.getUid().length() > 32) {
			return false;
		} else {
			return true;
		}
	}

	// 工序报验表单验证
	public boolean checkoutForm(Checkout msg) {
		if (msg.getGxName() == null || msg.getGxProcedure() == null
				|| msg.getGxTime() == null || msg.getPersonnelType() == null
				|| msg.getPid() == null || msg.getReceiver() == null
				|| msg.getUid() == null || msg.getWorkPost() == null) {
			return false;
		}
		if (msg.getGxName().length() < 1 || msg.getGxName().length() > 50) {
			return false;
		} else if (msg.getGxProcedure().length() < 1
				|| msg.getGxProcedure().length() > 50) {
			return false;
		} else if (msg.getGxTime().length() < 1
				|| msg.getGxTime().length() > 20) {
			return false;
		} else if (msg.getPersonnelType().length() < 1
				|| msg.getPersonnelType().length() > 10) {
			return false;
		} else if (msg.getPid().longValue() < 1
				|| msg.getPid().longValue() > 1000000000) {
			return false;
		} else if (msg.getReceiver().length() < 1
				|| msg.getReceiver().length() > 10) {
			return false;
		} else if (msg.getUid().length() < 1 || msg.getUid().length() > 32) {
			return false;
		} else if (msg.getWorkPost().length() < 1
				|| msg.getWorkPost().length() > 10) {
			return false;
		} else {
			return true;
		}
	}

	// 现场勘察表单验证
	public boolean prospectForm(Prospect msg) {
		if (msg.getPid() == null || msg.getUid() == null
				|| msg.getXcAdd() == null || msg.getXcPerson() == null
				|| msg.getXcTime() == null) {
			return false;
		}
		if (msg.getPid().longValue() < 1
				|| msg.getPid().longValue() > 1000000000) {
			return false;
		} else if (msg.getUid().length() < 1 || msg.getUid().length() > 32) {
			return false;
		} else if (msg.getXcAdd().length() < 1 || msg.getXcAdd().length() > 150) {
			return false;
		} else if (msg.getXcPerson().length() < 1
				|| msg.getXcPerson().length() > 20) {
			return false;
		} else if (msg.getXcTime().length() < 1
				|| msg.getXcTime().length() > 30) {
			return false;
		} else {
			return true;
		}
	}

	// 供货商表单验证
	public boolean supplierForm(Supplier msg) {
		if (msg.getEpAdd() == null || msg.getEpDate() == null
				|| msg.getEpName() == null || msg.getEpTel() == null
				|| msg.getPid() == null || msg.getUid() == null) {
			return false;
		}
		if (msg.getEpAdd().length() < 1 || msg.getEpAdd().length() > 150) {
			return false;
		} else if (msg.getEpDate().length() < 1
				|| msg.getEpDate().length() > 30) {
			return false;
		} else if (msg.getEpName().length() < 1
				|| msg.getEpName().length() > 50) {
			return false;
		} else if (!msg.getEpTel().matches(this.TEL)) {
			return false;
		} else if (msg.getPid().longValue() < 1
				|| msg.getPid().longValue() > 1000000000) {
			return false;
		} else if (msg.getUid().length() < 1 || msg.getUid().length() > 32) {
			return false;
		} else {
			return true;
		}
	}

	// 变更管理表单验证
	public boolean alterationForm(Alteration msg) {
		if (msg.getConfirmingParty() == null || msg.getPid() == null
				|| msg.getTimes() == null || msg.getUid() == null) {
			return false;
		}
		if (msg.getConfirmingParty().length() < 1
				|| msg.getConfirmingParty().length() > 50) {
			return false;
		} else if (msg.getPid().longValue() < 1
				|| msg.getPid().longValue() > 1000000000) {
			return false;
		} else if (msg.getTimes().length() < 1 || msg.getTimes().length() > 30) {
			return false;
		} else if (msg.getUid().length() < 1 || msg.getUid().length() > 32) {
			return false;
		} else {
			return true;
		}
	}

	// 技术交底表单验证
	public boolean technologyForm(Technology msg) {
		if (msg.getContent() == null || msg.getDates() == null
				|| msg.getPid() == null || msg.getSites() == null
				|| msg.getUid() == null) {
			return false;
		}
		if (msg.getContent().length() < 1 || msg.getContent().length() > 1000) {
			return false;
		} else if (msg.getDates().length() < 1 || msg.getDates().length() > 30) {
			return false;
		} else if (msg.getPid().longValue() < 1
				|| msg.getPid().longValue() > 1000000000) {
			return false;
		} else if (msg.getSites().length() < 1 || msg.getSites().length() > 150) {
			return false;
		} else if (msg.getUid().length() < 1 || msg.getUid().length() > 32) {
			return false;
		} else {
			return true;
		}
	}

	// 项目结算表单验证
	public boolean settlementForm(Settlement msg) {
		if (msg.getDates() == null || msg.getPid() == null
				|| msg.getUid() == null) {
			return false;
		}
		if (msg.getDates().length() < 1 || msg.getDates().length() > 30) {
			return false;
		} else if (msg.getPid().longValue() < 1
				|| msg.getPid().longValue() > 1000000000) {
			return false;
		} else if (msg.getUid().length() < 1 || msg.getUid().length() > 32) {
			return false;
		} else {
			return true;
		}
	}

	// 竣工验收表单验证
	public boolean finalacceptanceForm(Finalacceptance msg) {
		if (msg.getDates() == null || msg.getInspectionPersonnel() == null
				|| msg.getPid() == null || msg.getProjectName() == null
				|| msg.getUid() == null) {
			return false;
		}
		if (msg.getDates().length() < 1 || msg.getDates().length() > 30) {
			return false;
		} else if (msg.getInspectionPersonnel().length() < 1
				|| msg.getInspectionPersonnel().length() > 20) {
			return false;
		} else if (msg.getPid().longValue() < 1
				|| msg.getPid().longValue() > 1000000000) {
			return false;
		} else if (msg.getProjectName().length() < 1
				|| msg.getProjectName().length() > 50) {
			return false;
		} else if (msg.getUid().length() < 1 || msg.getUid().length() > 32) {
			return false;
		} else {
			return true;
		}
	}
}
