package com.henghao.Garden.service.servicelmpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import com.henghao.Garden.dao.YHManageDao;
import com.henghao.Garden.entity.conservation.*;
import com.henghao.Garden.formFilter.YHmanageFormFilter;
import com.henghao.Garden.resultEntity.Result;
import com.henghao.Garden.service.YHManageService;
import com.henghao.Garden.util.DateUtil;

/**
 * function 养护管理模块业务逻辑Java类
 * 
 * @author 严彬荣
 */
@Service
public class YHMangeServiceImpl implements YHManageService {

	// 注入接口
	@Resource
	private YHManageDao dao;
	// 实例化日期工具类
	private DateUtil date = DateUtil.getInstance();
	// 实例化结果集实体类,并定义为公共结果集
	private Result result = null;
	// 实例化泛型集合
	private List<T> list = null;
	// 实例化表单验证工具类
	private YHmanageFormFilter charset = YHmanageFormFilter.getInstance();

	// 查询植物所有信息数据方法
	@Override
	public Result queryAllTreeMassageService() {
		try {
			this.list = this.dao.queryAllTreeMassageDao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 1);
			return this.result;
		}
		if (this.list.size() > 0) {
			// 创建结果集实体，将查询结果封装到实体中
			this.result = new Result(0, list);
		} else {
			// 创建结果集实体，将未查询到的结果封装到实体中
			this.result = new Result("数据不存在！", 1);
		}
		return this.result;
	}

	// 扫描树木信息数据方法
	@Override
	public Result queryTreeMsgByIdService(String chip) {
		TreeMassage treeMsg = null;
		try {
			treeMsg = this.dao.queryTreeMassageByIdDao(chip);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 3);
			return this.result;
		}
		if (treeMsg != null) {
			String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			YhStatus yhMsg = this.dao.queryNowTree(chip, date);
			if (yhMsg != null) {
				int tip = this.date.judge(yhMsg.getYhStatustime());
				if (tip == 1) {
					this.result = new Result("该植物已被养护过了哦！明天再来吧", 2);
					return this.result;
				} else if (tip == 2) {
					this.result = new Result("服务器走丢了！", 3);
					return this.result;
				}
			}
			this.result = new Result(0, treeMsg);
		} else {
			// 创建结果集实体，将未查询到的结果封装到实体中
			this.result = new Result("小主，没有该植物哟", 1);
		}
		return this.result;
	}

	// 查询当天养护工作记录信息数据方法
	@Override
	public Result queryYhStatusmsgService(String date, String uid) {
		try {
			this.list = this.dao.queryYhstatusDao(date, uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 1);
			return this.result;
		}
		if (list.size() > 0) {
			// 创建结果集实体，将查询结果封装到实体中
			this.result = new Result(0, list);
		} else {
			this.result = new Result("您今天还没有对植物进行养护哦！", 1);
		}
		return this.result;
	}

	// 通过养护状态查询养护信息数据方法
	@Override
	public Result queryYhmassageByIdService(String id) {
		YhStatus list = null;
		try {
			list = this.dao.queryYhmassageByIdDao(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 1);
			return this.result;
		}
		if (list != null) {
			// 创建结果集实体，将查询结果封装到实体中
			this.result = new Result(0, list);
		} else {
			this.result = new Result("小主，我们没有你要的数据哦", 1);
		}
		return this.result;
	}

	// 查询管护信息数据方法
	@Override
	public Result queryGhmsgService() {
		try {
			this.list = this.dao.queryGhmsgDao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 1);
			return this.result;
		}
		if (this.list.size() > 0) {
			// 创建结果集实体，将查询结果封装到实体中
			this.result = new Result(0, this.list);
		} else {
			this.result = new Result("你可能还没有对植物进行养护哦！", 1);
		}
		return this.result;
	}

	// 查询管护信息数据通过植物编号方法
	@Override
	public Result queryGhManageMsgByidService(String treeId, int yid, String uid) {
		GhManage ghMsg = null;
		try {
			ghMsg = this.dao.queryGhmsgByidDao(treeId, yid, uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 1);
			return this.result;
		}
		if (ghMsg != null) {
			this.result = new Result(0, ghMsg);
		} else {
			this.result = new Result("你可能还没有对植物进行养护哦！", 1);
		}
		return this.result;
	}

	// 植物信息数据保存方法
	@Override
	public Result saveTreeMassageService(TreeMassage tree) {
		boolean check = this.charset.treeForm(tree);
		if (check == false) {
			this.result = new Result("输入有误，请检查正确后重试", 5);
			return this.result;
		}
		try {
			this.dao.saveTreeMassageDao(tree);
			this.result = new Result("录入成功", 0);
		} catch (Exception e) {
			this.result = new Result("该植物已存在，请勿重复添加！", 1);
		}
		return this.result;
	}

	// 养护工作记录信息数据保存方法
	@Override
	public Result saveYhStatusService(YhStatus msg) {
		boolean check = this.charset.statusForm(msg);
		if (check == false) {
			this.result = new Result("输入有误，请检查正确后重试", 5);
			return this.result;
		}
		try {
			this.dao.saveYhstatusDao(msg);
			this.result = new Result("保存成功", 0);
		} catch (Exception e) {
			this.result = new Result("小主，系统繁忙！请稍后再试", 1);
			e.printStackTrace();
		}
		return this.result;
	}

	// 管护信息数据保存方法
	@Override
	public Result saveGhmsgService(GhManage msg, int yid) {
		boolean check = this.charset.manageForm(msg);
		if (check == false) {
			this.result = new Result("输入有误，请检查正确后重试", 5);
			return this.result;
		}
		try {
			this.dao.updateYhstatusDao(yid);
			this.dao.saveGhmsgDao(msg);
			this.result = new Result("保存成功", 0);
		} catch (Exception e) {
			this.result = new Result("小主，系统繁忙！请稍后再试", 1);
			e.printStackTrace();
		}
		return this.result;
	}

}
