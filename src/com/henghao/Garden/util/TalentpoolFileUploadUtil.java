package com.henghao.Garden.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * function 合同管理文件上传工具类
 * 
 * date 2017.05.18
 * 
 * @author 严彬荣
 */
public class TalentpoolFileUploadUtil {

	/* 创建Talentpool工具类单例 */
	private volatile static TalentpoolFileUploadUtil instance;

	private TalentpoolFileUploadUtil() {
	}

	public static TalentpoolFileUploadUtil getInstance() {
		if (instance == null) {
			synchronized (TalentpoolFileUploadUtil.class) {
				if (instance == null)
					instance = new TalentpoolFileUploadUtil();
			}
		}
		return instance;
	}

	// 初始化公共集合
	private List<String> list = new ArrayList<String>();
	// 实例化UUID工具类
	private UUIDUtil uuid = UUIDUtil.getInstance();
	private StringBuilder sb = null;

	/*
	 * 人才库文件上传
	 * 
	 * @Parma file 上传的文件， req http请求， folder 文件夹名字
	 */
	public List<String> fileUpload(MultipartFile[] file,
			HttpServletRequest req, String folder) throws Exception {
		// 解析器解析request的上下文
		String path = req.getSession().getServletContext().getRealPath("");
		String rootpath = path.substring(0, path.lastIndexOf("Garden")) + "/";
		String upload = "/gardenFile/talentpool/"
				+ folder
				+ "/"
				+ new SimpleDateFormat("yyyyMMddHHmmssSSSSHHmmssSSSS")
						.format(new Date());
		String savePath = rootpath + "/" + upload;
		File file1 = new File(savePath);
		if (!file1.exists()) {
			file1.mkdirs();
		}
		for (int i = 0, length = file.length; i < length; i++) {
			if (!file[i].isEmpty()) {
				String name = file[i].getOriginalFilename().toLowerCase();
				this.sb = new StringBuilder(name.substring(name.indexOf(".")));
				if (name.endsWith("jpg") || name.endsWith("jpeg")
						|| name.endsWith("png") || name.endsWith("gif")) {
					String paths = "/" + this.uuid.getUUID() + sb;
					file[i].transferTo(new File(file1 + paths));
					list.add(new StringBuilder(upload + paths).toString());
				} else {
					return null;
				}
			} else {
				return null;
			}
		}
		return this.list;
	}
}
