package com.henghao.Garden.service.servicelmpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.henghao.Garden.dao.DemandReleaseDao;
import com.henghao.Garden.entity.fileMassage.Filemassage;
import com.henghao.Garden.entity.leasing.*;
import com.henghao.Garden.resultEntity.Result;
import com.henghao.Garden.service.DemandReleaseService;

/**
 * function 需求发布模块业务处理Java类
 * 
 * date 2017-03-28
 * 
 * @author 严彬荣
 */
@Service
public class DemandReleaseServicelmpl implements DemandReleaseService {
	@Resource
	private DemandReleaseDao dao;
	// 实例化结果集实体类,并定义为公共结果集
	private Result result = null;
	// 初始化存放文件集合
	List<Filemassage> path = null;

	// 查询发布租赁设备信息数据方法
	@Override
	public Result queryEquipmentLeasingService() {
		List<Equipmentleasing> list = null;
		try {
			list = this.dao.queryEquipmentLeasingDao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					// 获取图片路径
					this.path = this.dao.queryFilemessageDao(list.get(i)
							.getFilesId());
					if (this.path.size() > 0) {
						list.get(i).setUrl(this.path);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.result = new Result(0, list);
		} else {
			this.result = new Result("仿佛跑到火星上去了！", 1);
		}
		return this.result;
	}

	// 查询用户发布的设备租赁信息数据方法
	@Override
	public Result queryEquipmentLeasingByIdService(String uid) {
		List<Equipmentleasing> list = null;
		try {
			list = this.dao.queryEquipmentLeasingByIdDao(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 1);
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					// 获取图片路径
					this.path = this.dao.queryFilemessageDao(list.get(i)
							.getFilesId());
					if (this.path.size() > 0) {
						list.get(i).setUrl(this.path);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.result = new Result(0, list);
		} else {
			this.result = new Result("仿佛跑到火星上去了！", 1);
		}
		return this.result;
	}

	// 查询发布苗木信息公共数据方法
	@Override
	public Result querySeedlingmessageService() {
		List<Seedlingmessage> list = null;
		try {
			list = this.dao.querySeedlingmessageDao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					// 获取图片路径
					this.path = this.dao.queryFilemessageDao(list.get(i)
							.getFilesId());
					if (this.path.size() > 0) {
						list.get(i).setUrl(this.path);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.result = new Result(0, list);
		} else {
			this.result = new Result("仿佛跑到火星上去了！", 1);
		}
		return this.result;
	}

	// 按类型查询苗木信息公共数据方法
	@Override
	public Result querySeedlingmessageByTypeService(String type) {
		List<Seedlingmessage> list = null;
		try {
			list = this.dao.querySeedlingmessageByTypeDao(type, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					// 获取图片路径
					this.path = this.dao.queryFilemessageDao(list.get(i)
							.getFilesId());
					if (this.path.size() > 0) {
						list.get(i).setUrl(this.path);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.result = new Result(0, list);
		} else {
			this.result = new Result("仿佛跑到火星上去了！", 1);
		}
		return this.result;
	}

	// 按多个类型查询苗木信息公共数据方法
	@Override
	public Result querySeedlingmessageByTypeService(String type, String subclass) {
		List<Seedlingmessage> list = null;
		try {
			list = this.dao.querySeedlingmessageByTypeDao(type, subclass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 1);
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					// 获取图片路径
					this.path = this.dao.queryFilemessageDao(list.get(i)
							.getFilesId());
					if (this.path.size() > 0) {
						list.get(i).setUrl(this.path);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.result = new Result(0, list);
		} else {
			this.result = new Result("仿佛跑到火星上去了！", 1);
		}
		return this.result;
	}

	// 查询用户发布的苗木信息数据方法
	@Override
	public Result querySeedlingmessageByIdService(String uid) {
		List<Seedlingmessage> list = null;
		try {
			list = this.dao.querySeedlingmessageByIdDao(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					// 获取图片路径
					this.path = this.dao.queryFilemessageDao(list.get(i)
							.getFilesId());
					if (this.path.size() > 0) {
						list.get(i).setUrl(this.path);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.result = new Result(0, list);
		} else {
			this.result = new Result("仿佛跑到火星上去了！", 1);
		}
		return this.result;
	}

	// 查询发布招标信息公共数据方法
	@Override
	public Result queryBidService() {
		List<Bid> list = null;
		try {
			list = this.dao.queryBidDao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			this.result = new Result(0, list);
		} else {
			this.result = new Result("仿佛跑到火星上去了！", 1);
		}
		return this.result;
	}

	// 查询发布人员招聘信息公共数据方法
	@Override
	public Result queryRecruitService() {
		List<Recruit> list = null;
		try {
			list = this.dao.queryRecruitDao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			this.result = new Result(0, list);
		} else {
			this.result = new Result("仿佛跑到火星上去了！", 1);
		}
		return this.result;
	}

	// 查询用户发布的人员招聘信息数据方法
	@Override
	public Result queryRecruitByIdService(String uid) {
		List<Recruit> list = null;
		try {
			list = this.dao.queryRecruitByIdDao(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			this.result = new Result(0, list);
		} else {
			this.result = new Result("仿佛跑到火星上去了！", 1);
		}
		return this.result;
	}

	// 添加设备租赁发布信息数据方法
	@Override
	public Result saveEquipmentLeasingService(Equipmentleasing msg) {
		try {
			this.dao.saveEquipmentLeasingDao(msg);
			this.result = new Result("发布成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("发布失败，系统忙！请稍后再试", 1);
		}
		return this.result;
	}

	// 添加苗木发布信息数据方法
	@Override
	public Result saveSeedlingmessageService(Seedlingmessage msg) {
		try {
			this.dao.saveSeedlingmessageDao(msg);
			this.result = new Result("发布成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("发布失败，系统忙！请稍后再试", 1);
		}
		return this.result;
	}

	// 添加人员招聘发布信息数据方法
	@Override
	public Result saveRecruitService(Recruit msg) {
		try {
			this.dao.saveRecruitDao(msg);
			this.result = new Result("发布成功", 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("发布失败，系统忙！请稍后再试", 1);
		}
		return this.result;
	}

	// 抓取招标信息数据方法
	@Override
	public Result saveBidsService(List<Bid> msg) {
		try {
			this.dao.saveBidsDao(msg);
			this.result = new Result("抓取数据成功", 0);
		} catch (Exception e) {
			this.result = new Result("系统繁忙", 1);
			e.printStackTrace();
		}
		return this.result;
	}

}
