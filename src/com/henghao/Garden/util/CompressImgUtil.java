package com.henghao.Garden.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * function 图片压缩工具类
 * 
 * date 2017.04.01
 * 
 * @author 严彬荣
 */
public class CompressImgUtil {

	/**
	 * 创建CompressImgUtil单例
	 * 
	 **/

	private volatile static CompressImgUtil instance;

	private CompressImgUtil() { // 初始化变量
		inputDir = "";
		outputDir = "";
		inputFileName = "";
		outputFileName = "";
		outputWidth = 2048;
		outputHeight = 2048;
	}

	public static CompressImgUtil getInstance() {
		if (instance == null) {
			synchronized (CompressImgUtil.class) {
				if (instance == null)
					instance = new CompressImgUtil();
			}
		}
		return instance;
	}

	private File file = null; // 文件对象
	private String inputDir; // 输入图路径
	private String outputDir; // 输出图路径
	private String inputFileName; // 输入图文件名
	private String outputFileName; // 输出图文件名
	private int outputWidth; // 默认输出图片宽
	private int outputHeight; // 默认输出图片高
	private boolean proportion = true; // 是否等比缩放标记(默认为等比缩放)

	public void getConpressImg(String path, HttpServletRequest request) {
		CompressImgUtil mypic = new CompressImgUtil();
		// 获取服务器存放路径
		String rootpath = request.getSession().getServletContext()
				.getRealPath("");
		// 截取文件服务器路径
		String tomcatPath = rootpath.substring(0, rootpath.lastIndexOf("G"));
		// 源文件夹路径
		String inputDir = tomcatPath + path;
		// 压缩输出文件路径
		String outputDir = tomcatPath + path;

		// 设置图片宽度
		Integer width = Integer.parseInt("4096");
		// 设置图片高度
		Integer height = Integer.parseInt("4096");
		// 获取文件夹
		File file = new File(inputDir);
		// mypic.compressPic(inputDir, outputDir, file.getName(),
		// file.getName(),
		// width, height, true);
		// File file1 = new File(outputDir);
		// if (!file1.exists()) {
		// file1.mkdir();
		// }
		// 获取文件夹下的文件
		File[] fileList = file.listFiles();
		for (int i = 0, length = fileList.length; i < length; i++) {
			// 文件大于1M执行压缩
			if (fileList[i].length() >= 1048576) {
				// 执行图片压缩
				mypic.compressPic(inputDir, outputDir, fileList[i].getName(),
						fileList[i].getName(), width, height, true);
			}
		}
	}

	public String compressPic(String inputDir, String outputDir,
			String inputFileName, String outputFileName) {
		this.setInputDir(inputDir);
		this.setOutputDir(outputDir);
		this.inputFileName = inputFileName;
		this.outputFileName = outputFileName;
		return compressPic();
	}

	public String compressPic(String inputDir, String outputDir,
			String inputFileName, String outputFileName, int width, int height,
			boolean gp) {
		this.setInputDir(inputDir);
		this.setOutputDir(outputDir);
		// 输入图文件名
		this.inputFileName = inputFileName;
		// 输出图文件名
		this.outputFileName = outputFileName;
		// 设置图片长宽
		setWidthAndHeight(width, height);
		// 是否是等比缩放 标记
		this.proportion = gp;
		return compressPic();
	}

	/*
	 * 获得图片大小 传入参数 String path ：图片路径
	 */
	public long getPicSize(String path) {
		file = new File(path);
		return file.length();
	}

	// 图片处理
	public String compressPic() {
		try {
			// 获得源文件
			file = new File(inputDir + inputFileName);
			if (!file.exists()) {
				return "file is not exist";
			}
			Image img = ImageIO.read(file);
			// 判断图片格式是否正确
			if (img.getWidth(null) == -1) {
				return "no";
			} else {
				int newWidth;
				int newHeight;
				// 判断是否是等比缩放
				if (this.proportion == true) {
					// 为等比缩放计算输出的图片宽度及高度
					double rate1 = ((double) img.getWidth(null))
							/ (double) outputWidth + 0.1;
					double rate2 = ((double) img.getHeight(null))
							/ (double) outputHeight + 0.1;
					// 根据缩放比率大的进行缩放控制
					double rate = rate1 > rate2 ? rate1 : rate2;
					newWidth = (int) (((double) img.getWidth(null)) / rate);
					newHeight = (int) (((double) img.getHeight(null)) / rate);
				} else {
					newWidth = outputWidth; // 输出的图片宽度
					newHeight = outputHeight; // 输出的图片高度
				}
				BufferedImage tag = new BufferedImage((int) newWidth,
						(int) newHeight, BufferedImage.TYPE_INT_RGB);

				/*
				 * Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
				 */
				tag.getGraphics().drawImage(
						img.getScaledInstance(newWidth, newHeight,
								Image.SCALE_SMOOTH), 0, 0, null);
				FileOutputStream out = new FileOutputStream(outputDir
						+ outputFileName);
				// JPEGImageEncoder可适用于其他图片类型的转换
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
				encoder.encode(tag);
				out.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return "ok";
	}

	/**
	 * 如果目录不是以/或者\结尾，结尾处加入/
	 */
	private String getDir(String dir) {
		if (!(dir.endsWith("/") || dir.endsWith("\\"))) {
			dir = dir + "/";
		}
		return dir;
	}

	public void setInputDir(String inputDir) {

		this.inputDir = getDir(inputDir);
	}

	public void setOutputDir(String outputDir) {
		this.outputDir = getDir(outputDir);
	}

	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

	public void setOutputWidth(int outputWidth) {
		this.outputWidth = outputWidth;
	}

	public void setOutputHeight(int outputHeight) {
		this.outputHeight = outputHeight;
	}

	public void setWidthAndHeight(int width, int height) {
		this.outputWidth = width;
		this.outputHeight = height;
	}
}