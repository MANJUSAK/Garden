package com.henghao.Garden.service.servicelmpl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.henghao.Garden.dao.CheckCompactDao;
import com.henghao.Garden.dao.CompactManageDao;
import com.henghao.Garden.entity.compact.BuildCompact;
import com.henghao.Garden.entity.compact.GardenCompact;
import com.henghao.Garden.entity.compact.GardenEngineeringCompact;
import com.henghao.Garden.entity.compact.LandscapeCompact;
import com.henghao.Garden.entity.fileMassage.Compactmassage;
import com.henghao.Garden.resultEntity.CompactBath;
import com.henghao.Garden.resultEntity.Result;
import com.henghao.Garden.service.CheckCompactService;
import com.henghao.Garden.util.DomainNameUtil;

/**
 * function 合同管理审核业务逻辑Java类
 * 
 * date 2017.04.21
 * 
 * @author 严彬荣
 */
@Service
public class CheckCompactServicelmpl implements CheckCompactService {

	@Resource
	private CheckCompactDao dao;
	@Resource
	private CompactManageDao fileDao;
	// 实例化服务器域名工具类
	private DomainNameUtil http = DomainNameUtil.getInstance();
	// 实例化公共结果集实体
	private Result result = null;
	// 实例化公共集合
	private List<Compactmassage> url = null;

	// 查询待审核的建设类合同方法
	@Override
	public Result checkBuildCompact(HttpServletRequest request) {
		List<BuildCompact> list = null;
		try {
			list = this.dao.checkBuildCompact();
		} catch (Exception e) {
			this.result = new Result("系统忙，请稍后再试", 2);
			e.printStackTrace();
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					// 查询合同相关图片文件
					this.url = this.fileDao.queryCompactFileMassage(list.get(i)
							.getPictureId());
					if (this.url.size() > 0)
						// 封装到实体
						list.get(i).setUrl(url);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.result = new Result(0, list);
			this.result.setPath(this.http.getDomainName(request));
		} else {
			this.result = new Result("没有待审核数据", 1);
		}
		return this.result;
	}

	// 查询待审核的园林类合同方法
	@Override
	public Result checkGardenCompact(HttpServletRequest request) {
		List<GardenCompact> list = null;
		try {
			list = this.dao.checkGardenCompact();
		} catch (Exception e) {
			this.result = new Result("系统忙，请稍后再试", 2);
			e.printStackTrace();
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					// 查询合同相关图片文件
					this.url = this.fileDao.queryCompactFileMassage(list.get(i)
							.getPictureId());
					if (this.url.size() > 0)
						// 封装到实体
						list.get(i).setUrl(url);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.result = new Result(0, list);
			this.result.setPath(this.http.getDomainName(request));
		} else {
			this.result = new Result("没有待审核数据", 1);
		}
		return this.result;
	}

	// 查询待审核的园林工程类合同方法
	@Override
	public Result checkEngineeringCompact(HttpServletRequest request) {
		List<GardenEngineeringCompact> list = null;
		try {
			list = this.dao.checkEngineeringCompact();
		} catch (Exception e) {
			this.result = new Result("系统忙，请稍后再试", 2);
			e.printStackTrace();
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {

					// 查询合同相关图片文件
					this.url = this.fileDao.queryCompactFileMassage(list.get(i)
							.getPictureId());
					if (this.url.size() > 0)
						// 封装到实体
						list.get(i).setUrl(url);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.result = new Result(0, list);
			this.result.setPath(this.http.getDomainName(request));
		} else {
			this.result = new Result("没有待审核数据", 1);
		}
		return this.result;
	}

	// 查询待审核的景观类合同方法
	@Override
	public Result checkLandscapeCompact(HttpServletRequest request) {
		List<LandscapeCompact> list = null;
		try {
			list = this.dao.checkLandscapeCompact();
		} catch (Exception e) {
			this.result = new Result("系统忙，请稍后再试", 2);
			e.printStackTrace();
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					// 查询合同相关图片文件
					this.url = this.fileDao.queryCompactFileMassage(list.get(i)
							.getPictureId());
					if (this.url.size() > 0)
						// 封装到实体
						list.get(i).setUrl(url);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.result = new Result(0, list);
			this.result.setPath(this.http.getDomainName(request));
		} else {
			this.result = new Result("没有待审核数据", 1);
		}
		return this.result;
	}

	// 建设类合同审核结果的公示方法
	@Override
	public Result updateBuildCompact(CompactBath ids) {
		try {
			this.dao.updateBuildCompact(ids);
			this.result = new Result("审核结果提交成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("系统忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 园林类合同审核结果的公示方法
	@Override
	public Result updateGardenCompact(CompactBath ids) {
		try {
			this.dao.updateGardenCompact(ids);
			this.result = new Result("审核结果提交成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("系统忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 园林工程类合同审核结果的公示方法
	@Override
	public Result updateEngineeringCompact(CompactBath ids) {
		try {
			this.dao.updateEngineeringCompact(ids);
			this.result = new Result("审核结果提交成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("系统忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 景观类合同审核结果的公示方法
	@Override
	public Result updateLandscapeCompact(CompactBath ids) {
		try {
			this.dao.updateLandscapeCompact(ids);
			this.result = new Result("审核结果提交成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("系统忙，请稍后重试", 1);
		}
		return this.result;
	}

}
