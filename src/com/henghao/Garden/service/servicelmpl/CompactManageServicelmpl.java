package com.henghao.Garden.service.servicelmpl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.henghao.Garden.dao.CompactManageDao;
import com.henghao.Garden.entity.compact.*;
import com.henghao.Garden.entity.fileMassage.Compactmassage;
import com.henghao.Garden.formFilter.CompactFormFilter;
import com.henghao.Garden.resultEntity.Result;
import com.henghao.Garden.service.CompactManageService;
import com.henghao.Garden.service.SaveFileService;
import com.henghao.Garden.util.CompactFileUploadUtil;
import com.henghao.Garden.util.DomainNameUtil;
import com.henghao.Garden.util.UUIDUtil;

/**
 * function 合同管理模块业务逻辑Java类
 * 
 * date 2017.04.20
 * 
 * @author 严彬荣
 */
@Service
public class CompactManageServicelmpl implements CompactManageService {

	@Resource
	private CompactManageDao dao;
	@Resource
	private SaveFileService fileService;
	// 实例化保存文件工具类
	private CompactFileUploadUtil fileUpload = CompactFileUploadUtil
			.getInstance();
	// 实例化服务器域名工具类
	private DomainNameUtil http = DomainNameUtil.getInstance();
	// 初始化公共集合
	private List<String> list = null;
	// 实例化UUID工具类
	private UUIDUtil uuid = UUIDUtil.getInstance();
	// 实例化合同文件保存实体类
	private Compactmassage file = new Compactmassage();
	// 实例化公共结果集实体
	private Result result = null;
	// 实例化公共集合
	private List<Compactmassage> url = null;
	// 实例化表单验证工具类
	private CompactFormFilter charset = CompactFormFilter.getInstance();

	// 查询建设类合同管理信息数据接口
	@Override
	public Result queryBuildCompactService(String uid,
			HttpServletRequest request) {
		List<BuildCompact> list = null;
		try {
			list = this.dao.queryBuildCompactDao(uid);
		} catch (Exception e) {
			this.result = new Result("服务器走丢了", 2);
			e.printStackTrace();
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					// 查询合同相关图片文件
					this.url = this.dao.queryCompactFileMassage(list.get(i)
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
			this.result = new Result("没有相关数据", 1);
		}
		return this.result;
	}

	// 查询园林类合同数据方法
	@Override
	public Result queryGardenCompactService(String uid,
			HttpServletRequest request) {
		List<GardenCompact> list = null;
		try {
			list = this.dao.queryGardenCompact(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.result = new Result("服务器走丢了", 2);
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					this.url = this.dao.queryCompactFileMassage(list.get(i)
							.getPictureId());
					if (this.url.size() > 0)
						list.get(i).setUrl(url);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.result = new Result(0, list);
			this.result.setPath(this.http.getDomainName(request));
		} else {
			this.result = new Result("没有相关数据", 1);
		}
		return this.result;
	}

	// 查询园林工程类合同
	@Override
	public Result queryEngineeringCompactService(String uid,
			HttpServletRequest request) {
		List<GardenEngineeringCompact> list = null;
		try {
			list = this.dao.queryEngineeringCompact(uid);
		} catch (Exception e) {
			e.printStackTrace();
			this.result = new Result("服务器走丢了", 2);
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					this.url = this.dao.queryCompactFileMassage(list.get(i)
							.getPictureId());
					if (this.url.size() > 0)
						list.get(i).setUrl(url);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.result = new Result(0, list);
			this.result.setPath(this.http.getDomainName(request));
		} else {
			this.result = new Result("没有相关数据", 1);
		}
		return this.result;
	}

	// 查询景观类合同数据接口
	@Override
	public Result queryLandscapeCompact(String uid, HttpServletRequest request) {
		List<LandscapeCompact> list = null;
		try {
			list = this.dao.queryLandscapeCompact(uid);
		} catch (Exception e) {
			this.result = new Result("服务器走丢了", 2);
			e.printStackTrace();
			return this.result;
		}
		if (list.size() > 0) {
			try {
				for (int i = 0, length = list.size(); i < length; i++) {
					this.url = this.dao.queryCompactFileMassage(list.get(i)
							.getPictureId());
					if (this.url.size() > 0)
						list.get(i).setUrl(url);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.result = new Result(0, list);
			this.result.setPath(this.http.getDomainName(request));
		} else {
			this.result = new Result("没有相关数据", 1);
		}
		return this.result;
	}

	// 保存建设类合同数据方法
	@Override
	public Result saveBuildCompactService(BuildCompact msg,
			MultipartFile[] files, HttpServletRequest request) {
		// 表单信息验证是否符合要求
		boolean check = this.charset.compactForm(msg.getProjectName(),
				msg.getGenre(), msg.getUid());
		if (check == false) {
			this.result = new Result("输入有误，请检查正确后重试", 5);
			return this.result;
		}
		try {
			this.list = this.fileUpload.pictureCompactFileUpload(files,
					request, "buildCompact");
		} catch (Exception e) {
			e.printStackTrace();
			this.result = new Result("文件上传，请重试", 4);
			return this.result;
		}
		if (this.list.size() > 0) {
			// 获取用户ID
			this.file.setUid(msg.getUid());
			// 设置图片路径保存编号
			msg.setPictureId(this.uuid.getUUID().toString());
			// 将文件路径编号保存到合同文件表中
			this.file.setPathId(msg.getPictureId());
			boolean tip = this.fileService.SaveCompactmassge(this.list,
					this.file, request);
			if (tip == false) {
				this.result = new Result("服务器走丢了，请稍后重试", 1);
				return this.result;
			}
		} else {
			this.result = new Result("文档为空或格式不正确", 2);
			return this.result;
		}
		try {
			this.dao.saveBuildCompactDao(msg);
			this.result = new Result("录入成功，请耐心等待审核，我们最晚将于7个工作日返回审核结果", 0);
		} catch (Exception e) {
			this.result = new Result("服务器走丢了", 1);
			e.printStackTrace();
		}
		return this.result;
	}

	// 保存园林类合同数据方法
	@Override
	public Result saveGardenCompactService(GardenCompact msg,
			MultipartFile[] files, HttpServletRequest request) {
		// 表单信息验证是否符合要求
		boolean check = this.charset.compactForm(msg.getProjectName(),
				msg.getGenre(), msg.getUid());
		if (check == false) {
			this.result = new Result("输入有误，请检查正确后重试", 5);
			return this.result;
		}
		try {
			this.list = this.fileUpload.pictureCompactFileUpload(files,
					request, "gardenCompact");
		} catch (Exception e) {
			e.printStackTrace();
			this.result = new Result("文件上传，请重试", 4);
			return this.result;
		}
		if (this.list.size() > 0) {
			// 获取用户ID
			this.file.setUid(msg.getUid());
			// 设置图片路径保存编号
			msg.setPictureId(this.uuid.getUUID().toString());
			// 将文件路径编号保存到合同文件表中
			this.file.setPathId(msg.getPictureId());
			boolean tip = this.fileService.SaveCompactmassge(this.list,
					this.file, request);
			if (tip == false) {
				this.result = new Result("服务器走丢了，请稍后重试", 1);
				return this.result;
			}
		} else {
			this.result = new Result("文档为空或格式不正确", 2);
			return this.result;
		}
		try {
			this.dao.saveGardenCompactDao(msg);
			this.result = new Result("录入成功，请耐心等待审核，我们最晚将于7个工作日返回审核结果", 0);
		} catch (Exception e) {
			this.result = new Result("服务器走丢了", 1);
			e.printStackTrace();
		}
		return this.result;
	}

	// 保存园林工程类合同数据方法
	@Override
	public Result saveGardenEngineeringCompactService(
			GardenEngineeringCompact msg, MultipartFile[] files,
			HttpServletRequest request) {
		// 表单信息验证是否符合要求
		boolean check = this.charset.compactForm(msg.getProjectName(),
				msg.getGenre(), msg.getUid());
		if (check == false) {
			this.result = new Result("输入有误，请检查正确后重试", 5);
			return this.result;
		}
		try {
			this.list = this.fileUpload.pictureCompactFileUpload(files,
					request, "engineeringCompact");
		} catch (Exception e) {
			e.printStackTrace();
			this.result = new Result("文件上传，请重试", 4);
			return this.result;
		}
		if (this.list.size() > 0) {
			// 获取用户ID
			this.file.setUid(msg.getUid());
			// 设置图片路径保存编号
			msg.setPictureId(this.uuid.getUUID().toString());
			// 将文件路径编号保存到合同文件表中
			this.file.setPathId(msg.getPictureId());
			boolean tip = this.fileService.SaveCompactmassge(this.list,
					this.file, request);
			if (tip == false) {
				this.result = new Result("服务器走丢了，请稍后重试", 1);
				return this.result;
			}
		} else {
			this.result = new Result("文档为空或格式不正确", 2);
			return this.result;
		}
		try {
			this.dao.saveGardenEngineeringCompactDao(msg);
			this.result = new Result("录入成功，请耐心等待审核，我们最晚将于7个工作日返回审核结果", 0);
		} catch (Exception e) {
			this.result = new Result("服务器走丢了", 1);
			e.printStackTrace();
		}
		return this.result;
	}

	// 保存景观类合同数据方法
	@Override
	public Result saveLandscapeCompactService(LandscapeCompact msg,
			MultipartFile[] files, HttpServletRequest request) {
		// 表单信息验证是否符合要求
		boolean check = this.charset.compactForm(msg.getProjectName(),
				msg.getGenre(), msg.getUid());
		if (check == false) {
			this.result = new Result("输入有误，请检查正确后重试", 5);
			return this.result;
		}
		try {
			this.list = this.fileUpload.pictureCompactFileUpload(files,
					request, "landscapeCompact");
		} catch (Exception e) {
			e.printStackTrace();
			this.result = new Result("文件上传，请重试", 4);
			return this.result;
		}
		if (this.list.size() > 0) {
			// 获取用户ID
			this.file.setUid(msg.getUid());
			// 设置图片路径保存编号
			msg.setPictureId(this.uuid.getUUID().toString());
			// 将文件路径编号保存到合同文件表中
			this.file.setPathId(msg.getPictureId());
			boolean tip = this.fileService.SaveCompactmassge(this.list,
					this.file, request);
			if (tip == false) {
				this.result = new Result("服务器走丢了，请稍后重试", 1);
				return this.result;
			}
		} else {
			this.result = new Result("文档为空或格式不正确", 2);
			return this.result;
		}
		try {
			this.dao.saveLandscapeCompact(msg);
			this.result = new Result("录入成功，请耐心等待审核，我们最晚将于7个工作日返回审核结果", 0);
		} catch (Exception e) {
			this.result = new Result("服务器走丢了", 1);
			e.printStackTrace();
		}
		return this.result;
	}
}
