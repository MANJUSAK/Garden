package com.henghao.Garden.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * function get提交编码过滤器工具类
 * 
 * date 2017.02.28
 * 
 * @author 严彬荣
 */
public class GetRequestFilter implements Filter {
	private FilterConfig filterConfig = null;
	private String encoding = null;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest reqs = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		System.out.println("调用url地址：" + request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ reqs.getRequestURI().toString());
		// // 设置请求字符编码
		// request.setCharacterEncoding(encoding);
		// // 设置响应字符编码
		// response.setCharacterEncoding(encoding);

		System.out.println("设置请求编码:" + reqs.getCharacterEncoding());

		// 如果是Get方式提交
		if ("get".equalsIgnoreCase(reqs.getMethod().trim().toString())) {
			System.out.println("当前请求为get方式");
			// 对请求进行包装,完成URL中参数的编码转换
			reqs = new CharacterEncodingRequest(reqs, encoding);
		} else {
			System.out.println("当前请求为post方式");
		}
		// 执行下一个过滤器
		filterChain.doFilter(reqs, res);
	}

	// 销毁
	public void destroy() {
		this.filterConfig = null;
		this.encoding = null;

	}

	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}

	/**
	 * 对Get方式传递的请求参数进行编码
	 */
	public class CharacterEncodingRequest extends HttpServletRequestWrapper {
		private String encoding = "UTF-8";

		public CharacterEncodingRequest(HttpServletRequest request) {
			super(request);
		}

		public CharacterEncodingRequest(HttpServletRequest request,
				String encoding) {
			super(request);
			this.encoding = encoding;
		}

		@Override
		public String getParameter(String name) {
			String param = super.getParameter(name);
			if (param == null) {
				param = null;
			} else {
				// 对URL中的参数进行编码转换
				try {
					param = new String(param.trim().getBytes("ISO-8859-1"),
							encoding);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return param;
		}

	}
}
