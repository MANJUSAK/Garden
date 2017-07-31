package com.henghao.Garden.util;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import com.henghao.Garden.util.UUIDUtil;

public class YhmanagerFileUtil {
	/**
	 * 创建YhmanagerFileUtil类单例
	 * **/
	private volatile static YhmanagerFileUtil instance;

	private YhmanagerFileUtil() {
	}

	public static YhmanagerFileUtil getInstance() {
		if (instance == null) {
			synchronized (DateUtil.class) {
				if (instance == null)
					instance = new YhmanagerFileUtil();
			}
		}
		return instance;
	}

	// 实例化UUID工具类
	private UUIDUtil uuid = UUIDUtil.getInstance();

	/*
	 * 养护管理文件上传
	 * 
	 * @parameter file 上传文件 request http请求
	 */
	public String fileUpload(MultipartFile file, HttpServletRequest request)
			throws Exception {
		if (!file.isEmpty()) {
			// 获取文件名
			String fileName = file.getOriginalFilename().toLowerCase();
			// 判断文件格式是否正确
			if (fileName.endsWith("jpg") || fileName.endsWith("jpeg")
					|| fileName.endsWith("png") || fileName.endsWith("gif")) {
				// 解析服务器上下文
				String path = request.getSession().getServletContext()
						.getRealPath("");
				// 截取系统需要的根目录
				String rootPath = path.substring(0, path.lastIndexOf("G"));
				// 定义文件路径
				String uploadPath = "/gardenFile/yhmanager/img/";
				// 定义文件存放路径
				String folderPath = rootPath + uploadPath;
				// 创建文件夹
				File folder = new File(folderPath);
				if (!folder.exists()) {
					folder.mkdirs();
				}
				// 重命名文件名以免文件名重复
				String name = this.uuid.getUUID().toString();
				// 获取文件名后缀
				String nameSuffix = fileName.substring(fileName
						.lastIndexOf("."));
				String savePath = folder + "/" + name + nameSuffix;
				file.transferTo(new File(savePath));
				return uploadPath + name + nameSuffix;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}
