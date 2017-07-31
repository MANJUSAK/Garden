package com.henghao.Garden.service.servicelmpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.henghao.Garden.dao.QueryProjectManageDao;
import com.henghao.Garden.entity.fileMassage.Excelmassage;
import com.henghao.Garden.entity.fileMassage.Filemassage;
import com.henghao.Garden.entity.project.*;
import com.henghao.Garden.entity.user.Wallet;
import com.henghao.Garden.entityvo.ConstructionSafetyLogVo;
import com.henghao.Garden.resultEntity.Result;
import com.henghao.Garden.service.QueryProjectManageService;

/**
 * function 项目管理信息查询模块业务逻辑Java类
 * 
 * @author 严彬荣
 */
@Service
public class QueryProjectManageServicelmpl implements QueryProjectManageService {

	@Resource
	private QueryProjectManageDao dao;
	// 实例化结果集实体类,并定义为公共结果集
	private Result result = null;
	// 定义存放文件公共集合
	private List<Filemassage> url = null;

	// 查询我的轨迹信息数据方法
	@Override
	public Result queryMylocusMsgService(String uid) {
		List<Mylocus> list = null;
		try {
			list = this.dao.queryMylocusMsgDao(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			this.result = new Result(0, list);
		} else {
			this.result = new Result("没有相关数据", 1);
		}
		return this.result;
	}

	// 查询会审结果信息数据方法
	@Override
	public Result queryHsResultMsgService(String uid) {
		List<HsResult> list = null;
		try {
			list = this.dao.queryHsResultMsgDao(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					// 根据文件路径编号查询文件路径
					this.url = this.dao.queryFilemassage(list.get(i)
							.getHsImgId());
					if (this.url.size() > 0) {
						// 将文件路径封装到实体
						list.get(i).setUrl(this.url);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.result = new Result(0, list);
		} else {
			this.result = new Result("没有相关数据！", 1);
		}
		return this.result;
	}

	// 查询开工报告信息数据方法
	@Override
	public Result queryKgReportMsgService(String uid) {
		List<KgReport> list = null;
		try {
			list = this.dao.queryKgReportMsgDao(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			this.result = new Result(0, list);
		} else {
			this.result = new Result("没有相关数据", 1);
		}
		return this.result;
	}

	// 查询项目信息数据方法
	@Override
	public Result queryProjectMsgService(String uid) {
		List<Project> list = null;
		try {
			list = this.dao.queryProjectMsgDao(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			this.result = new Result(0, list);
		} else {
			this.result = new Result("请添加项目信息", 1);
		}

		return this.result;
	}

	// 查询项目信息通过项目名称方法
	@Override
	public Result queryProjectMsgByNameService(String xmName, String uid) {
		Project msg = null;
		try {
			msg = this.dao.queryProjectMsgByNameDao(xmName, uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (msg != null) {
			this.result = new Result(0, msg);
		} else {
			this.result = new Result("请添加项目信息", 1);
		}
		return this.result;
	}

	// 查询现场检验信息数据方法
	@Override
	public Result queryCheckoutMsgService(String uid) {
		List<Checkout> list = null;
		try {
			list = this.dao.queryCheckoutMsgDao(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					// 根据文件路径编号查询文件路径
					this.url = this.dao.queryFilemassage(list.get(i)
							.getGxImgId());
					if (this.url.size() > 0)
						// 将文件路径封装到实体
						list.get(i).setUrl(this.url);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.result = new Result(0, list);
		} else {
			this.result = new Result("没有相关数据", 1);
		}
		return this.result;
	}

	// 查询设备信息数据方法
	@Override
	public Result queryEquipmentMsgService(String uid) {
		List<Equipment> list = null;
		try {
			list = this.dao.queryEquipmentMsgDao(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			this.result = new Result(0, list);
		} else {
			this.result = new Result("没有相关数据", 1);
		}
		return this.result;
	}

	// 查询施工人员信息数据方法
	@Override
	public Result querySgPersonnelMsgServiec(String uid) {
		List<SgPersonnel> list = null;
		try {
			list = this.dao.querySgPersonnelMsgDao(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			this.result = new Result(0, list);
		} else {
			this.result = new Result("没有相关数据", 1);
		}
		return this.result;
	}

	// 查看现场施工检验信息数据方法
	@Override
	public Result queryProspectMsgService(String uid) {
		List<Prospect> list = null;
		try {
			list = this.dao.queryProspectMsgDao(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					// 根据文件路径编号查询文件路径
					this.url = this.dao.queryFilemassage(list.get(i)
							.getXcSituationId());
					if (this.url.size() > 0)
						// 将文件路径封装到实体
						list.get(i).setUrl(this.url);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.result = new Result(0, list);
		} else {
			this.result = new Result("没有相关数据", 1);
		}
		return this.result;
	}

	// 查询供货商信息数据方法
	@Override
	public Result querySupplierMsgService(String uid) {
		List<Supplier> list = null;
		try {
			list = this.dao.querySupplierMsgDao(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					// 根据文件路径编号查询文件路径
					this.url = this.dao.queryFilemassage(list.get(i)
							.getEpCompactId());
					if (this.url.size() > 0)
						// 将文件路径封装到实体
						list.get(i).setUrl(this.url);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.result = new Result(0, list);
		} else {
			this.result = new Result("没有相关数据", 1);
		}
		return this.result;
	}

	// 查询变更管理信息数据方法
	@Override
	public Result queryAlterationMsgService(String uid) {
		List<Alteration> list = null;
		try {
			list = this.dao.queryAlterationMagDao(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					// 根据文件路径编号查询文件路径
					this.url = this.dao
							.queryFilemassage(list.get(i).getFiles());
					if (this.url.size() > 0)
						// 将文件路径封装到实体
						list.get(i).setUrl(this.url);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.result = new Result(0, list);
		} else {
			this.result = new Result("没有相关数据", 1);
		}
		return this.result;
	}

	// 查询技术交底信息数据方法
	@Override
	public Result queryTechnologyMsgService(String uid) {
		List<Technology> list = null;
		try {
			list = this.dao.queryTechnologyMsgDao(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					// 根据文件路径编号查询文件路径
					this.url = this.dao.queryFilemassage(list.get(i)
							.getPhotoId());
					if (this.url.size() > 0)
						// 将文件路径封装到实体
						list.get(i).setUrl(this.url);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.result = new Result(0, list);
		} else {
			this.result = new Result("没有相关数据", 1);
		}
		return this.result;
	}

	// 查询我的钱包信息数据方法
	@Override
	public Result queryWalletMsgService(String uid) {
		List<Wallet> list = null;
		try {
			list = this.dao.queryWalletMsgDao(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			this.result = new Result(0, list);
		} else {
			this.result = new Result("系统忙，请稍后重试", 1);
		}
		return this.result;
	}

	// 查询申报进度信息数据方法
	@Override
	public Result queryDeclarationMsgService(String uid) {
		List<Declaration> list = null;
		try {
			list = this.dao.queryDeclarationMsgDao(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					// 根据文件路径编号查询文件路径
					this.url = this.dao.queryFilemassage(list.get(i)
							.getFilesId());
					if (this.url.size() > 0)
						// 将文件路径封装到实体
						list.get(i).setUrl(this.url);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.result = new Result(0, list);
		} else {
			this.result = new Result("没有相关数据", 1);
		}
		return this.result;
	}

	// 查询结算信息数据方法
	@Override
	public Result querySettlementMsgService(String uid) {
		List<Settlement> list = null;
		try {
			list = this.dao.querySettlementMsgDao(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					// 根据文件路径编号查询文件路径
					this.url = this.dao.queryFilemassage(list.get(i)
							.getSettlementBookId());
					if (this.url.size() > 0)
						// 将文件封装到实体中
						list.get(i).setUrl(this.url);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.result = new Result(0, list);
		} else {
			this.result = new Result("没有相关数据", 1);
		}
		return this.result;
	}

	// 查询施工日志信息数据方法
	@Override
	public Result queryConstructionLogMsgService(String uid) {
		List<ConstructionLog> list = null;
		try {
			list = this.dao.queryConstructionLogMsgDao(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			this.result = new Result(0, list);
		} else {
			this.result = new Result("没有相关数据", 1);
		}
		return this.result;
	}

	// 通过用户编号查询文件信息方法
	@Override
	public Excelmassage queryFileMsgService(String uid) {
		return this.dao.queryFileMsgDao(uid);
	}

	// 查询监理日志信息数据方法
	@Override
	public Result querySupervisionlogMsgService(String uid) {
		List<Supervisionlog> list = null;
		try {
			list = this.dao.querySupervisionlogMsgDao(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			this.result = new Result(0, list);
		} else {
			this.result = new Result("没有相关数据", 1);
		}
		return this.result;
	}

	// 查询竣工验收信息数据方法
	@Override
	public Result queryFinalacceptanceMsgService(String uid) {
		List<Finalacceptance> list = null;
		try {
			list = this.dao.queryFinalacceptanceMsgDao(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					// 将获取的文件路径编号查询文件地址
					this.url = this.dao.queryFilemassage(list.get(i)
							.getCompletionDrawingId());
					if (this.url.size() > 0)
						// 将文件地址封装到竣工验收实体
						list.get(i).setUrl(this.url);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.result = new Result(0, list);
		} else {
			this.result = new Result("没有相关数据", 1);
		}
		return this.result;
	}

	// 查询施工安全日志概要信息数据方法
	@Override
	public Result querySummaryLogMsgService(String uid) {
		List<ConstructionSafetyLogVo> list = null;
		try {
			list = this.dao.querySummaryLogMsgDao(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了！", 2);
			return this.result;
		}
		if (list.size() > 0) {
			this.result = new Result(0, list);
		} else {
			this.result = new Result("没有相关数据", 1);
		}
		return this.result;
	}

}
