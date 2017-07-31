package com.henghao.Garden.formFilter;

import com.henghao.Garden.entity.conservation.GhManage;
import com.henghao.Garden.entity.conservation.TreeMassage;
import com.henghao.Garden.entity.conservation.YhStatus;

/**
 * function 养护管理表单验证工具类
 * 
 * date 2017.05.25
 * 
 * @author 严彬荣
 */
public class YHmanageFormFilter {
	/* 创建本类为单例模式 */
	private volatile static YHmanageFormFilter instance;

	private YHmanageFormFilter() {
	}

	public static YHmanageFormFilter getInstance() {
		if (instance == null) {
			synchronized (YHmanageFormFilter.class) {
				if (instance == null)
					instance = new YHmanageFormFilter();
			}
		}
		return instance;
	}

	// 植物信息表单验证
	public boolean treeForm(TreeMassage msg) {
		if (msg.getTreeId() == null || msg.getTreeSite() == null
				|| msg.getTreeName() == null || msg.getTreeUse() == null
				|| msg.getTreeTime() == null) {
			return false;
		}
		if (msg.getTreeId().length() <= 0 || msg.getTreeId().length() > 32) {
			return false;
		} else if (msg.getTreeName().length() <= 0
				|| msg.getTreeName().length() > 50) {
			return false;
		} else if (msg.getTreeSite().length() <= 0
				|| msg.getTreeSite().length() > 50) {
			return false;
		} else if (msg.getTreeSpecification().length() <= 0
				|| msg.getTreeSpecification().length() > 300) {
			return false;
		} else if (msg.getTreeTime().length() <= 0
				|| msg.getTreeTime().length() > 50) {
			return false;
		} else if (msg.getTreeUse().length() <= 0
				|| msg.getTreeUse().length() > 50) {
			return false;
		} else {
			return true;
		}
	}

	// 养护工作记录表单验证
	public boolean statusForm(YhStatus msg) {
		if (msg.getTreeId() == null || msg.getYhStatusname() == null
				|| msg.getYhStatussite() == null
				|| msg.getYhStatustime() == null || msg.getUid() == null) {
			return false;
		}
		if (msg.getTreeId().length() <= 0 || msg.getTreeId().length() > 32) {
			return false;
		} else if (msg.getYhStatusname().length() <= 0
				|| msg.getYhStatusname().length() > 50) {
			return false;
		} else if (msg.getYhStatussite().length() <= 0
				|| msg.getYhStatussite().length() > 50) {
			return false;
		} else if (msg.getYhStatustime().length() <= 0
				|| msg.getYhStatustime().length() > 50) {
			return false;
		} else if (msg.getUid().length() <= 0 || msg.getUid().length() > 32) {
			return false;
		} else {
			return true;
		}
	}

	// 管护信息表单验证
	public boolean manageForm(GhManage msg) {
		if (msg.getTreeId() == null || msg.getTreeGrowup() == null
				|| msg.getYhWorker() == null || msg.getYhQuestion() == null
				|| msg.getYhClean() == null || msg.getYhTime() == null
				|| msg.getYhSite() == null || msg.getYhComment() == null
				|| msg.getUid() == null) {
			return false;
		}
		if (msg.getTreeGrowup().length() <= 0
				|| msg.getTreeGrowup().length() > 10) {
			return false;
		} else if (msg.getTreeId().length() <= 0
				|| msg.getTreeId().length() > 32) {
			return false;
		} else if (msg.getYhClean().length() <= 0
				|| msg.getYhClean().length() > 10) {
			return false;
		} else if (msg.getYhComment().length() > 150) {
			return false;
		} else if (msg.getYhDetails().length() <= 0
				|| msg.getYhDetails().length() > 300) {
			return false;
		} else if (msg.getYhQuestion().length() <= 0
				|| msg.getYhQuestion().length() > 10) {
			return false;
		} else if (msg.getYhSite().length() <= 0
				|| msg.getYhSite().length() > 50) {
			return false;
		} else if (msg.getYhTime().length() <= 0
				|| msg.getYhTime().length() > 30) {
			return false;
		} else if (msg.getYhWorker().length() <= 0
				|| msg.getYhWorker().length() > 10) {
			return false;
		} else if (msg.getUid().length() <= 0 || msg.getUid().length() > 32) {
			return false;
		} else {
			return true;
		}
	}
}
