package com.henghao.Garden.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * function 需求发布文件上传工具类
 * 
 * date 2017.03.20
 * 
 * @author 严彬荣
 */
public class ReleaseFileUploadUtil {

	/**
	 * 定义一个静态私有变量(不初始化，不使用final关键字，使用volatile保证了多线程访问时instance变量的可见性，
	 * 避免了instance初始化时其他变量属性还没赋值完时，被另外线程调用)
	 **/
	private volatile static ReleaseFileUploadUtil instance;

	// 定义一个私有的构造方法
	private ReleaseFileUploadUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 定义一个共有的静态方法，返回该类型实例
	public static ReleaseFileUploadUtil getInstance() {
		// 对象实例化时与否判断（不使用同步代码块，instance不等于null时，直接返回对象，提高运行效率）
		if (instance == null) {
			// 同步代码块（对象未初始化时，使用同步代码块，保证多线程访问时对象在第一次创建后，不再重复被创建）
			synchronized (ReleaseFileUploadUtil.class) {
				// 未初始化，则初始instance变量
				if (instance == null)
					instance = new ReleaseFileUploadUtil();
			}
		}
		return instance;
	}

	private static LinkedList<String> list = new LinkedList<String>();
	private static UUIDUtil uuid = UUIDUtil.getInstance();
	private static File localFile = null;
	private static String filesPath = null;

	// 设备租赁上传工具类
	public static LinkedList<String> equipmentLeasingFileSave(
			HttpServletRequest req) throws IOException {
		// 解析器解析request的上下文
		String path = req.getSession().getServletContext().getRealPath("");
		String rootpath = path.substring(0, path.lastIndexOf("Garden"));
		String upload = "/gardenFile/leasing/equipmentLeasing/"
				+ new SimpleDateFormat("yyyyHHddHHmmssSSS").format(new Date());
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
						filesPath = upload + "/" + localFile.getName();
					} else {
						return list;
					}
				}
				if (file.getSize() > 0) {
					list.add(filesPath);
				}
			}

		}
		return list;
	}

	// 苗木信息文件上传工具类
	public static LinkedList<String> seedlingMassageFileSave(
			HttpServletRequest req) throws IOException {
		// 解析器解析request的上下文
		String path = req.getSession().getServletContext().getRealPath("");
		String rootpath = path.substring(0, path.lastIndexOf("Garden"));
		String upload = "/gardenFile/leasing/seedlingMassage/"
				+ new SimpleDateFormat("yyyyMMdd").format(new Date());
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
						filesPath = upload + "/" + localFile.getName();
					} else {
						return list;
					}
				}
				if (file.getSize() > 0) {
					list.add(filesPath);
				}
			}

		}
		return list;
	}
}
