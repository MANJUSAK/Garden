<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-cn" style="font-size: 16px;">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<!-- 使用最新的IE兼容模式渲染此网页 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<!-- 在双核浏览器下，默认使用webkit内核，由360浏览器提出 -->
<meta name="renderer" content="webkit">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>园林大数据平台</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="管理员注册">
<link rel="shortcut icon" type="text/css"
	href="<%=basePath%>img/logo.ico">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/common.css" />
<style>
header .header-navs {
	background-color: #0065AB;
}
</style>
</head>
<body>
	<header>
		<div class="header-topbar">
			<div class="ht-box">
				<div class="logo">
					<div class="logo-img">
						<a href="<%=basePath%>news/register.html"><img
							src="<%=basePath%>img/log_2.png" /></a>
					</div>
					<div class="logo-text">
						<div class="lt-content">
							<div class="lt-topbar">
								<h2>园林大数据平台</h2>
							</div>
							<div class="lt-inner">
								<p>Garden large data platform</p>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
		<div class="header-navs"></div>
	</header>

	<section class="login-section">
		<div class="ls-box">
			<div class="ls-left">
				<form action="<%=basePath%>role/register" method="post"
					onsubmit="return validate();">
					<div class="ls-left-topbar" id="ls-left-topbar_left">
						<div class="ls-lt-container">
							<div style="width: 100px; height: 15px;"></div>
							<div class="ls-title">
								<span style="">用户注册</span>
							</div>

							<div style="width: 100px; height: 5px;"></div>
							<div class="ls-lt-item ">
								<div class="ls-item-icon ls-item-icon1">
									<i class="fa fa-user"></i>
								</div>
								<div class="ls-item-input">
									<input type="text" placeholder="设置管理员账号" id="userName"
										name="userName" />
								</div>
							</div>
							<span class="hint" id="userNameTip"></span>
							<div class="ls-lt-item">
								<div class="ls-item-icon ls-item-icon3">
									<i class="fa fa-unlock-alt"></i>
								</div>
								<div class="ls-item-input">
									<input type="text" placeholder="请输入手机号" id="phone" name="tel" />
								</div>
							</div>
							<span class="hint" id="phoneTip"></span>
							<div class="ls-lt-item">
								<div class="ls-item-icon ls-item-icon2">
									<i class="fa fa-unlock-alt"></i>
								</div>
								<div class="ls-item-input">
									<input type="password" placeholder="请输入密码" id="password"
										name="passWord" />
								</div>
							</div>
							<span class="hint" id="passwordTip"></span>
							<div class="ls-lt-item">
								<div class="ls-item-icon ls-item-icon2">
									<i class="fa fa-unlock-alt"></i>
								</div>
								<div class="ls-item-input">
									<input type="password" placeholder="确认密码" id="confirmPassword" />
								</div>
							</div>
							<span class="hint" id="confirmPasswordTip"> <font
								face="微软雅黑" size=3 color="red">${tip }</font>
							</span>
							<div style="width: 200px; height: 10px;"></div>
							<div class="ls-submit" id="lsSubmit">
								<button type="submit">注册</button>
							</div>
							<div class="ls-left-footer">
								<span></span>已有账号<span><a
									href="<%=basePath%>news/login.html">立即登录</a></span>
							</div>
						</div>
					</div>
				</form>

				<div class="ls-left-inner"></div>
			</div>
			<div class="ls-right">
				<div class="lr-box">
					<div class="lr-logo">
						<div class="llo-img">
							<img src="<%=basePath%>img/log_2.png" />
						</div>
						<div class="llo-right">
							<div class="llo-title">
								<h3>贵州恒昊慧筑大数据有限公司</h3>
							</div>
							<div class="llo-text">
								<p>Guizhou Henghao Softwear Technology Co.Ltd.</p>
							</div>
						</div>
					</div>
					<div class="lr-footer">
						<p>
							<font size="2">贵州恒昊软件科技有限公司（英文寓意：“Good soft”） 是中国科学院浙 江数
								字内容研究院下属产业技术单位，于2013年北京3.1大数据招商引资落户贵阳国家高新区，专注
								基于物联网、云计算、大数据及信息化方面软 硬件产品开发、 技术服务及外包、嵌入式软件开发的高新技术企业。并成 功开
								发多个大数据平台， 公司旨在通过中国科学院数字内容研究院 核心技 术基础上开发应用，为用户提供 全面数据应用解决方案，
								提升行业信息化 水平和管理效能。</font>
						</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<footer style="margin-top: 0;">
		<div class="footer-box">
			<div class="fb-topbar">
				<p>Copynight @2016.Rights Reserved.鲁ICP备151212117号</p>
			</div>
			<div class="fb-content">
				<ul>
					<li><span><img src="<%=basePath%>img/footer5.jpg" /></span> <a
						href="#0">网站备案信息</a></li>
					<li><span><img src="<%=basePath%>img/footer6.jpg" /></span> <a
						href="#0">中国互联网举报中心</a></li>
					<li><span><img src="<%=basePath%>img/footer1.jpg" /></span> <a
						href="#0">网络举报APP下载</a></li>
					<li><span><img src="<%=basePath%>img/footer2.jpg" /></span> <a
						href="#0">诚信网站</a></li>
					<li><span><img src="<%=basePath%>img/footer3.jpg" /></span> <a
						href="#0">企业信用信息</a></li>
					<li><span><img src="<%=basePath%>img/footer4.png" /></span> <a
						href="#0">防网络诈骗</a></li>
				</ul>
			</div>
		</div>
	</footer>
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/login_regExp.js"></script>
</body>
</html>