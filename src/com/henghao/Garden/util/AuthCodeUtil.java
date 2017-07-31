package com.henghao.Garden.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * function 验证码工具类
 * 
 * date 2017.03.10
 * 
 * @author 严彬荣
 */
public class AuthCodeUtil {

	/**
	 * 创建AuthCodeUtil类的单例
	 **/
	private volatile static AuthCodeUtil instance;

	private AuthCodeUtil() {
	}

	public static AuthCodeUtil getInstance() {
		if (instance == null) {
			synchronized (AuthCodeUtil.class) {
				if (instance == null)
					instance = new AuthCodeUtil();
			}
		}
		return instance;
	}

	public void getAuthCode(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws IOException {
		int width = 63;
		int height = 37;
		Random random = new Random();
		// 设置response头信息
		// 禁止缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		// 生成缓冲区image类
		BufferedImage image = new BufferedImage(width, height, 1);
		// 产生image类的Graphics用于绘制操作
		Graphics g = image.getGraphics();
		// Graphics类的样式
		g.setColor(this.getRandColor(200, 250));
		g.setFont(new Font("Times New Roman", 0, 28));
		g.fillRect(0, 0, width, height);
		// 绘制干扰线
		for (int i = 0; i < 40; i++) {
			g.setColor(this.getRandColor(130, 200));
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int x1 = random.nextInt(12);
			int y1 = random.nextInt(12);
			g.drawLine(x, y, x + x1, y + y1);
		}

		// 绘制字符
		StringBuffer PcCode = null;
		for (int i = 0; i < 4; i++) {
			// 生成随机字符
			String rand = String.valueOf(random.nextInt(10));
			PcCode = new StringBuffer(rand);
			// 设置随机字符颜色
			g.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
			// 绘制字符
			g.drawString(rand, 13 * i + 6, 28);
		}
		// 将字符保存到session中用于前端的验证
		session.setAttribute("PcCode", PcCode.toString());
		g.dispose();
		// 返回验证码图片
		ImageIO.write(image, "JPEG", response.getOutputStream());
		response.getOutputStream().flush();
	}

	// 创建颜色
	public Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
}
