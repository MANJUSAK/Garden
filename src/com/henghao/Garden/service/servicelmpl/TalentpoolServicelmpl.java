package com.henghao.Garden.service.servicelmpl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.henghao.Garden.dao.TalentpoolDao;
import com.henghao.Garden.entity.fileMassage.Talentpoolmassage;
import com.henghao.Garden.entity.talentpool.*;
import com.henghao.Garden.formFilter.TalentpoolFormFilter;
import com.henghao.Garden.resultEntity.Result;
import com.henghao.Garden.service.SaveFileService;
import com.henghao.Garden.service.TalentpoolService;
import com.henghao.Garden.util.DomainNameUtil;
import com.henghao.Garden.util.TalentpoolFileUploadUtil;
import com.henghao.Garden.util.UUIDUtil;

/**
 * function 人才库模块业务逻辑Java类
 * 
 * 
 * date 2017-05-18
 * 
 * @author 严彬荣
 */
@Service
public class TalentpoolServicelmpl implements TalentpoolService {

	@Resource
	private TalentpoolDao dao;
	@Resource
	private SaveFileService fileService;
	// 实例化文件保存工具类
	private TalentpoolFileUploadUtil fileUpload = TalentpoolFileUploadUtil
			.getInstance();
	// 实例化文件保存实体类
	private Talentpoolmassage file = new Talentpoolmassage();
	// 实例化UUID工具类
	private UUIDUtil uuid = UUIDUtil.getInstance();
	// 实例化公共集合
	private List<String> list = null;
	// 实例化服务器域名工具类
	private DomainNameUtil http = DomainNameUtil.getInstance();
	// 实例化公共结果集
	private Result result = null;
	// 实例化文件路径集合
	private List<Talentpoolmassage> url = null;
	// 实例化表单验证工具类
	private TalentpoolFormFilter charset = TalentpoolFormFilter.getInstance();

	// 查询法人库信息数据方法
	@Override
	public Result queryCorporationService(HttpServletRequest request) {
		List<Corporation> list = null;
		try {
			list = this.dao.queryCorporationDao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.result = new Result("系统繁忙，请稍后重试！", 2);
			e.printStackTrace();
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					this.url = this.dao.queryFileMassage(list.get(i)
							.getFileId());
					if (this.url.size() > 0) {
						list.get(i).setUrl(this.url);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.result = new Result(0, list);
			this.result.setPath(this.http.getDomainName(request));
			return this.result;
		} else {
			this.result = new Result("没有相关数据", 1);
			return this.result;
		}
	}

	// 查询从业人库信息数据方法
	@Override
	public Result queryEmployeesService(HttpServletRequest request) {
		List<Employees> list = null;
		try {
			list = this.dao.queryEmployeesDao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.result = new Result("系统繁忙，请稍后重试！", 2);
			e.printStackTrace();
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					this.url = this.dao.queryFileMassage(list.get(i)
							.getFileId());
					if (this.url.size() > 0) {
						list.get(i).setUrl(this.url);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.result = new Result(0, list);
			this.result.setPath(this.http.getDomainName(request));
			return this.result;
		} else {
			this.result = new Result("没有相关数据", 1);
			return this.result;
		}
	}

	// 法人库信息数据录入方法
	@Override
	public Result saveCorporationService(MultipartFile[] files,
			HttpServletRequest request, Corporation msg) {
		boolean check = this.charset.corporationForm(msg);
		if (check == false) {
			this.result = new Result("输入有误，请检查正确后重试", 5);
			return this.result;
		}
		try {
			this.list = this.fileUpload.fileUpload(files, request,
					"corporation");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("文件上传失败，请重试", 2);
			return this.result;
		}
		if (this.list != null) {
			msg.setFileId(this.uuid.getUUID().toString());
			this.file.setFileId(msg.getFileId());
			boolean tip = this.fileService.SaveTalentpoolmassge(list,
					this.file, request);
			if (tip == false) {
				this.result = new Result("系统繁忙，请稍后重试", 2);
				return this.result;
			}
			try {
				this.dao.saveCorporationDao(msg);
				this.result = new Result("信息录入成功", 0);
				return this.result;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.result = new Result("系统繁忙，请稍后重试", 2);
				return this.result;
			}
		} else {
			this.result = new Result("文件格式为空或格式不正确", 3);
			return this.result;
		}
	}

	// 从业人员库信息数据录入方法
	@Override
	public Result saveEmployeesService(MultipartFile[] files,
			HttpServletRequest request, Employees msg) {
		boolean check = this.charset.employeesForm(msg);
		if (check == false) {
			this.result = new Result("输入有误，请检查正确后重试", 5);
			return this.result;
		}
		try {
			this.list = this.fileUpload.fileUpload(files, request, "employees");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("文件上传失败，请重试", 2);
			return this.result;
		}
		if (this.list != null) {
			msg.setFileId(this.uuid.getUUID().toString());
			this.file.setFileId(msg.getFileId());
			boolean tip = this.fileService.SaveTalentpoolmassge(list,
					this.file, request);
			if (tip == false) {
				this.result = new Result("系统繁忙，请稍后重试", 2);
				return this.result;
			}
			try {
				this.dao.saveEmployeesDao(msg);
				this.result = new Result("信息录入成功", 0);
				return this.result;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.result = new Result("系统繁忙，请稍后重试", 2);
				return this.result;
			}
		} else {
			msg.setFileId(this.uuid.getUUID().toString());
			try {
				this.dao.saveEmployeesDao(msg);
				this.result = new Result("信息录入成功", 0);
				return this.result;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.result = new Result("系统繁忙，请稍后重试", 2);
				return this.result;
			}
		}
	}
}
