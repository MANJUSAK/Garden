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
 * function 项目管理文件上传工具类
 * 
 * date 2017.03.08
 * 
 * @author 严彬荣
 */

public class ProjectFileUploadUtil {
	/**
	 * 定义一个静态私有变量(不初始化，不使用final关键字，使用volatile保证了多线程访问时instance变量的可见性，
	 * 避免了instance初始化时其他变量属性还没赋值完时，被另外线程调用)
	 **/
	private volatile static ProjectFileUploadUtil instance;

	// 定义一个私有的构造方法
	private ProjectFileUploadUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 定义一个共有的静态方法，返回该类型实例
	public static ProjectFileUploadUtil getInstance() {
		// 对象实例化时与否判断（不使用同步代码块，instance不等于null时，直接返回对象，提高运行效率）
		if (instance == null) {
			// 同步代码块（对象未初始化时，使用同步代码块，保证多线程访问时对象在第一次创建后，不再重复被创建）
			synchronized (ProjectFileUploadUtil.class) {
				// 未初始化，则初始instance变量
				if (instance == null)
					instance = new ProjectFileUploadUtil();
			}
		}
		return instance;
	}

	private static LinkedList<String> list = new LinkedList<String>();
	private static UUIDUtil uuid = UUIDUtil.getInstance();
	private static String filesPath = null;
	private static File files = null;
	private static String upload = null;

	// 会审结果上传工具类

	public static LinkedList<String> HsResultFileSave(HttpServletRequest req)
			throws IOException {
		// 解析器解析request的上下文
		String path = req.getSession().getServletContext().getRealPath("");
		String rootpath = path.substring(0, path.lastIndexOf("Garden")) + "/";
		String upload = "/gardenFile/project/hsResult/"
				+ new SimpleDateFormat("yyyyMMddHHmmssSSSSHHmmssSSSS")
						.format(new Date());
		String savePath = rootpath + "/" + upload;
		File file1 = new File(savePath);
		if (!file1.exists()) {
			file1.mkdirs();
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
						files = new File(file1 + "/"
								+ uuid.getUUID().toString() + suffix);
						if (files.exists()) {
							files = new File(file1 + uuid.getUUID().toString()
									+ suffix);
						}
						if (!files.exists()) {
							files.createNewFile();
						}
						// 写文件到本地
						// 将文件copy上传到服务器
						file.transferTo(files);
						filesPath = upload + "/" + files.getName();
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

	// 申报进度文件上传工具类
	public static LinkedList<String> DeclarationFileSave(
			final HttpServletRequest req) throws IOException {
		// 解析器解析request的上下文
		String path = req.getSession().getServletContext().getRealPath("");
		String rootpath = path.substring(0, path.lastIndexOf("Garden")) + "/";
		upload = "/gardenFile/project/declaration/"
				+ new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date());
		String savePath = rootpath + "/" + upload;
		File file1 = new File(savePath);
		if (!file1.exists()) {
			file1.mkdirs();
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
						files = new File(file1 + "/"
								+ uuid.getUUID().toString() + suffix);
						if (files.exists()) {
							files = new File(file1 + uuid.getUUID().toString()
									+ suffix);
						}
						if (!files.exists()) {
							files.createNewFile();
						}
						// 写文件到本地
						// 将文件copy上传到服务器
						file.transferTo(files);
						filesPath = upload + "/" + files.getName();
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

	// 开工报告文件上传工具类
	public static String kgReportSave(HttpServletRequest req)
			throws IOException {
		// 解析器解析request的上下文
		String path = req.getSession().getServletContext().getRealPath("");
		String rootpath = path.substring(0, path.lastIndexOf("Garden")) + "/";
		String upload = "/gardenFile/project/kgReport";
		String savePath = rootpath + "/" + upload;
		files = new File(savePath);
		if (!files.exists()) {
			files.mkdirs();
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
					String suffix = file.getOriginalFilename().toLowerCase();
					if (suffix.endsWith("txt") || suffix.endsWith("pdf")
							|| suffix.endsWith("doc")
							|| suffix.endsWith("docx")) {
						String fileName = uuid.getUUID().toString() + "."
								+ suffix.substring(suffix.lastIndexOf(".") + 1);
						files = new File(files + "/");
						if (files.exists()) {
							files = new File(files + "/1" + fileName);
						}
						if (!files.exists()) {
							files.createNewFile();
						}
						// 写文件到本地
						// 将文件copy上传到服务器
						file.transferTo(files);
						filesPath = upload + "/" + files.getName();
					} else {
						return null;
					}
				}
			}
		}
		return filesPath;
	}

	// 工序报验文件上传工具类

	public static LinkedList<String> checkoutFileSave(HttpServletRequest req)
			throws IOException {
		// 解析器解析request的上下文
		String path = req.getSession().getServletContext().getRealPath("");
		String rootpath = path.substring(0, path.lastIndexOf("Garden")) + "/";
		String upload = "/gardenFile/project/checkout/"
				+ new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date());
		String savePath = rootpath + "/" + upload;
		File file1 = new File(savePath);
		if (!file1.exists()) {
			file1.mkdirs();
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
						files = new File(file1 + "/"
								+ uuid.getUUID().toString() + suffix);
						if (files.exists()) {
							files = new File(file1 + "/1" + fileName);
						}
						if (!files.exists()) {
							files.createNewFile();
						}
						// 写文件到本地
						// 将文件copy上传到服务器
						file.transferTo(files);
						filesPath = upload + "/" + files.getName();
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

	// 现场勘探文件上传工具类

	public static LinkedList<String> ProspectFileSave(HttpServletRequest req)
			throws IOException {
		// 解析器解析request的上下文
		String path = req.getSession().getServletContext().getRealPath("");
		String rootpath = path.substring(0, path.lastIndexOf("Garden")) + "/";
		String upload = "/gardenFile/project/prospect/"
				+ new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date());
		String savePath = rootpath + "/" + upload;
		File file1 = new File(savePath);
		if (!file1.exists()) {
			file1.mkdirs();
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
						files = new File(file1 + "/"
								+ uuid.getUUID().toString() + suffix);
						if (files.exists()) {
							files = new File(file1 + "/1" + fileName);
						}
						if (!files.exists()) {
							files.createNewFile();
						}
						// 写文件到本地
						// 将文件copy上传到服务器
						file.transferTo(files);
						filesPath = upload + "/" + files.getName();
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

	// 供货商文件上传工具类

	public static LinkedList<String> SupplierFileSave(HttpServletRequest req)
			throws IOException {
		// 解析器解析request的上下文
		String path = req.getSession().getServletContext().getRealPath("");
		String rootpath = path.substring(0, path.lastIndexOf("Garden")) + "/";
		String upload = "/gardenFile/project/supplier/"
				+ new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date());
		String savePath = rootpath + "/" + upload;
		File file1 = new File(savePath);
		if (!file1.exists()) {
			file1.mkdirs();
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
						files = new File(file1 + "/"
								+ uuid.getUUID().toString() + suffix);
						if (files.exists()) {
							files = new File(file1 + "/1" + fileName);
						}
						if (!files.exists()) {
							files.createNewFile();
						}
						// 写文件到本地
						// 将文件copy上传到服务器
						file.transferTo(files);
						filesPath = upload + "/" + files.getName();
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

	// 变更管理文件上传工具类

	public static LinkedList<String> AlterationFileSave(HttpServletRequest req)
			throws IOException {
		// 解析器解析request的上下文
		String path = req.getSession().getServletContext().getRealPath("");
		String rootpath = path.substring(0, path.lastIndexOf("Garden")) + "/";
		String upload = "/gardenFile/project/alteration/"
				+ new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date());
		String savePath = rootpath + "/" + upload;
		File file1 = new File(savePath);
		if (!file1.exists()) {
			file1.mkdirs();
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
						files = new File(file1 + "/"
								+ uuid.getUUID().toString() + suffix);
						if (files.exists()) {
							files = new File(file1 + "/1" + fileName);
						}
						if (!files.exists()) {
							files.createNewFile();
						}
						// 写文件到本地
						// 将文件copy上传到服务器
						file.transferTo(files);
						filesPath = upload + "/" + files.getName();
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

	// 技术交底文件上传工具类

	public static LinkedList<String> TechnologyFileSave(HttpServletRequest req)
			throws IOException {
		// 解析器解析request的上下文
		String path = req.getSession().getServletContext().getRealPath("");
		String rootpath = path.substring(0, path.lastIndexOf("Garden")) + "/";
		String upload = "/gardenFile/project/technology/"
				+ new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date());
		String savePath = rootpath + "/" + upload;
		File file1 = new File(savePath);
		if (!file1.exists()) {
			file1.mkdirs();
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
						files = new File(file1 + "/"
								+ uuid.getUUID().toString() + suffix);
						if (files.exists()) {
							files = new File(file1 + "/1" + fileName);
						}
						if (!files.exists()) {
							files.createNewFile();
						}
						// 写文件到本地
						// 将文件copy上传到服务器
						file.transferTo(files);
						filesPath = upload + "/" + files.getName();
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

	// 结算文件上传工具类

	public static LinkedList<String> SettlementFileSave(HttpServletRequest req)
			throws IOException {

		// 解析器解析request的上下文
		String path = req.getSession().getServletContext().getRealPath("");
		String rootpath = path.substring(0, path.lastIndexOf("Garden")) + "/";
		String upload = "/gardenFile/project/settlement/"
				+ new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date());
		String savePath = rootpath + "/" + upload;
		File file1 = new File(savePath);
		if (!file1.exists()) {
			file1.mkdirs();
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
						files = new File(file1 + "/"
								+ uuid.getUUID().toString() + suffix);
						if (files.exists()) {
							files = new File(file1 + "/1" + fileName);
						}
						if (!files.exists()) {
							files.createNewFile();
						}
						// 写文件到本地
						// 将文件copy上传到服务器
						file.transferTo(files);
						filesPath = upload + "/" + files.getName();
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

	// 竣工验收文件上传工具类
	public static LinkedList<String> FinalacceptanceFileSave(
			HttpServletRequest req) throws IOException {
		// 解析器解析request的上下文
		String path = req.getSession().getServletContext().getRealPath("");
		String rootpath = path.substring(0, path.lastIndexOf("Garden")) + "/";
		String upload = "/gardenFile/project/acceptance/"
				+ new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date());
		String savePath = rootpath + "/" + upload;
		File file1 = new File(savePath);
		if (!file1.exists()) {
			file1.mkdirs();
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
						files = new File(file1 + "/"
								+ uuid.getUUID().toString() + suffix);
						if (files.exists()) {
							files = new File(file1 + "/1" + fileName);
						}
						if (!files.exists()) {
							files.createNewFile();
						}
						// 写文件到本地
						// 将文件copy上传到服务器
						file.transferTo(files);
						filesPath = upload + "/" + files.getName();
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
