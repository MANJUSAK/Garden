package com.henghao.Garden.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * function 用户注册文件上传工具类
 * 
 * date 2017.02.28
 * 
 * @author 严彬荣
 */
public class UserFileUtil {
	/**
	 * 创建UserFileUitl类单例
	 * **/
	private volatile static UserFileUtil instance;

	private UserFileUtil() {
	}

	public static UserFileUtil getInstance() {
		if (instance == null) {
			synchronized (UserFileUtil.class) {
				if (instance == null)
					instance = new UserFileUtil();
			}
		}
		return instance;
	}

	private static LinkedList<String> list = new LinkedList<String>();
	private static UUIDUtil uuid = UUIDUtil.getInstance();

	// 企业用户注册文件保存方法
	public static LinkedList<String> enterpriseFileSave(HttpServletRequest req)
			throws IOException {
		File localFile = null;
		String enterprisePath = null;
		// 解析器解析request的上下文
		String path = req.getSession().getServletContext().getRealPath("");
		String rootpath = path.substring(0, path.lastIndexOf("Garden")) + "/";
		String upload = "/gardenFile/user/IDCard";
		String savePath = rootpath + "/" + upload;
		File file2 = new File(savePath);
		if (!file2.exists()) {
			file2.mkdirs();
		}
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				req.getSession().getServletContext());
		// 先判断request中是否包涵multipart类型的数据，
		if (multipartResolver.isMultipart(req)) {
			// 再将request中的数据转化成multipart类型的数据
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) req;
			@SuppressWarnings("rawtypes")
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile((String) iter.next());
				if (file.getSize() > 0) {
					String fileName = file.getOriginalFilename().toLowerCase();
					if (fileName.endsWith("jpg") || fileName.endsWith("jpeg")
							|| fileName.endsWith("png")
							|| fileName.endsWith("gif")) {
						String suffix = fileName.substring(fileName
								.indexOf("."));
						localFile = new File(file2 + "/" + uuid.getUUID()
								+ suffix);
						if (localFile.exists()) {
							localFile = new File(file2 + "/1" + fileName);
						}
						if (!localFile.exists()) {
							localFile.createNewFile();
						}
						// 写文件到本地
						// 将文件copy上传到服务器
						file.transferTo(localFile);
						enterprisePath = upload + "/" + localFile.getName();
					} else {
						return null;
					}
				}
				if (file.getSize() > 0) {
					list.add(enterprisePath);
				}
			}
		}
		return list;
	}
}
