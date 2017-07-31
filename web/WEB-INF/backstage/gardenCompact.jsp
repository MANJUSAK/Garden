<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
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
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/common.css" />
<link rel="stylesheet" href="<%=basePath%>css/user_background.css" />
<link rel="shortcut icon" type="text/css"
	href="<%=basePath%>img/logo.ico">
</head>
<!--
		用户管理，批量操作,页面user_background.css简称为UB
	-->
<body>
	<header>
	<div class="header-topbar">
		<div class="ht-box">
			<div class="logo">
				<div class="logo-img">
					<a href="<%=basePath%>checkCompact/garden"><img
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
			<div class="logo_R">
				欢迎您：&nbsp;&nbsp;<span class="logo_R_name">${userInfo.userName }</span>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;<span
					class="logo_R_quit"><a href="<%=basePath%>loginOut">退出</a></span>
			</div>
		</div>
	</div>
	<div class="header-navs">
		<div class="UBnav_center">
			<ul class="UBnav_center_ul">
				<li class="UBnav_center_li"><a
					href="<%=basePath%>checkCompact/build">施工建设合同</a></li>
				<li class="UBnav_center_li"><a class="UBnav_center_aBg"
					href="<%=basePath%>checkCompact/garden">园林绿化合同</a></li>
				<li class="UBnav_center_li"><a
					href="<%=basePath%>checkCompact/engineering">园林工程合同</a></li>
				<li class="UBnav_center_li"><a
					href="<%=basePath%>checkCompact/landscape">景观风景合同</a></li>
			</ul>

		</div>

	</div>
	</header>
	<!--合同审核中间部分内容-->
	<div class="UB_contont">
		<form action="<%=basePath%>checkCompact/updateGarden" method="post">
			<div class="UB_centert">
				<!--仅设置使用边框-->
				<div class="UB_border">
					<div class="UB_centert_one">
						<div class="UBc_one_1">
							<input type="checkbox" class="UBc1_input"
								onclick="UBc1_inputs();" />
						</div>
						<div class="UBc_one_2">
							<span>合同编号</span>
						</div>
						<div class="UBc_one_3">
							<span>项目名称</span>
						</div>
						<div class="UBc_one_4">
							<span>录入时间</span>
						</div>
						<div class="UBc_one_5">
							<span>审核状态</span>
						</div>
						<div class="UBc_one_6">
							<span>合同图片</span>
						</div>
					</div>
					<div style="clear: none;">
						<font color="red">${status }</font>
					</div>
					<c:forEach items="${result.data }" var="r">
						<div style="clear: none;"></div>
						<div class="UB_centert_two">
							<div class="UBc_two_1">
								<input type="checkbox" class="UBc2_input" name="ids"
									value="${r.id }" />
							</div>
							<div class="UBc_two_2">
								<a>${r.compactId }</a>
							</div>
							<div class="UBc_two_3">
								<a>${r.projectName }</a>
							</div>
							<div class="UBc_two_4">
								<a>${r.dates }</a>
							</div>
							<div class="UBc_two_5">
								<a>${r.checking }</a>
							</div>
							<div class="UBc_two_6">
								<div class="UBc_two_6_imgZong">
									<c:forEach items="${r.url }" var="u">
										<img class="UBc_two6_img" src="${result.path }${u }" />
									</c:forEach>
								</div>
							</div>
						</div>
						<%-- <input type="hidden" name="name" value="${r.sendName }" />
						<input type="hidden" name="tel" value="${r.sendTel }" />
						<input type="hidden" name="dates" value="${r.dates }" />
						<input type="hidden" name="document" value="${r.document }" />
						<input type="hidden" name="genre" value="${r.genre }" /> --%>
					</c:forEach>
					<div class="UB_centert_two">
						<font color="red" size="4">${result.result }</font>
					</div>
				</div>
			</div>
			<!--通过按钮和不同过按钮-->
			<div class="UBc_C_censor">
				<!--控制向右对齐-->
				<div class="UBc_right">
					<select onclick="UBc_right_selVal();" class="UBc_right_select"
						name="result">
						<option value="审核通过">通过审核</option>
						<option value="审核未通过">不通过审核</option>
					</select> <input type="submit" class="UBc_censor_bon" value="提交审核" />
				</div>
				<!--不通过填写理由-->
				<div class="UBc_C_censor_one">
					<p>&nbsp;&nbsp;审核不同过的理由：</p>
					<textarea placeholder="请输入理由" class="UBc_Cc_one_text"
						name="comment"></textarea>
				</div>
				<!--不通过填写理由 结束-->
			</div>
			<!--通过按钮和不同过按钮 结束-->
		</form>
	</div>
	<!--合同审核中间部分内容 结束-->
	<footer style="margin-top: 0;">
	<div class="footer-box">
		<div class="fb-topbar">

			<p>Copynight @2016.Rights Reserved.鲁ICP备151212117号</p>
		</div>
		<div class="fb-content">
			<ul>
				<li><span><img src="<%=basePath%>img/footer5.jpg" /></span> <a>网站备案信息</a></li>
				<li><span><img src="<%=basePath%>img/footer6.jpg" /></span> <a>中国互联网举报中心</a></li>
				<li><span><img src="<%=basePath%>img/footer1.jpg" /></span> <a>网络举报APP下载</a></li>
				<li><span><img src="<%=basePath%>img/footer2.jpg" /></span> <a>诚信网站</a></li>
				<li><span><img src="<%=basePath%>img/footer3.jpg" /></span> <a>企业信用信息</a></li>
				<li><span><img src="<%=basePath%>img/footer4.png" /></span> <a>防网络诈骗</a></li>
			</ul>
		</div>
	</div>
	</footer>

	<!--点击图片，图片显示，出现 蒙层-->
	<div class="UB_mengceng">

		<div class="UB_mengceng">
			<div class="UB_mengcheng_center">
				<img class="UB_mc_center_img" src="" />
				<div class="UB_mc_center_absolute">
					<img src="<%=basePath%>img/err_err.png" />
				</div>
			</div>
		</div>
	</div>
	<!--点击图片，图片显示，出现 蒙层-->

</body>
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/user_background.js"></script>
</html>
