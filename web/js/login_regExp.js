/* 注释说明：
 * 注册的页面字段发生改变，固正则中没有用到的字段注释掉
 * 期中使用的注释为 “//”
 **/
//企业注册
function validate() {
	// var yesNo = 0;
	var result = false;
	// 用户名
	var userName = document.getElementById("userName").value;

	var passwd = document.getElementById('password').value;
	var confirmPasswd = document.getElementById('confirmPassword').value;
	var phone = document.getElementById('phone').value;

	// 密码验证
	if (passwd == '') {
		document.getElementById('passwordTip').innerHTML = '<img src="img/err.png"/><font color="red">密码不能为空！</font>';
		result = false;
	} else if (passwd.length < 6 || passwd.length > 12) {
		document.getElementById('passwordTip').innerHTML = '<img src="img/err.png"/><font color="red">密码的长度必须在6~12之间！</font>';
		result = false;
	} else {
		document.getElementById('passwordTip').innerHTML = '<img src="img/ok.png"/>';
		result = true;
	}
	if (confirmPasswd == '') {
		document.getElementById('confirmPasswordTip').innerHTML = '<img src="img/err.png"/><font color="red">确认密码不能为空！</font>';
		result = false;
	} else if (passwd != confirmPasswd) {
		document.getElementById('confirmPasswordTip').innerHTML = '<img src="img/err.png"/><font color="red">两次密码输入不一致！</font>';
		result = false;
	} else {
		document.getElementById('confirmPasswordTip').innerHTML = '<img src="img/ok.png"/>';
		result = true;
	}
	if (!/^(13|14|15|17|18)\d{9}/.test(phone)) {
		document.getElementById('phoneTip').innerHTML = '<img src="img/err.png"/><font color="red">必须填写正确的电话号码！</font>';
		result = false;
	} else {
		document.getElementById('phoneTip').innerHTML = '<img src="img/ok.png"/>';
	}

	// 用户名
	if (userName == '') {
		document.getElementById('userNameTip').innerHTML = '<img src="img/err.png"/><font color="red">用户名不能为空！</font>';
		result = false;
	} else if (userName.length < 3 || userName.length > 10) {
		document.getElementById('userNameTip').innerHTML = '<img src="img/err.png"/><font color="red">用户名的长度必须在3~10之间！</font>';
		result = false;
	} else {
		document.getElementById('userNameTip').innerHTML = '<img src="img/ok.png"/>';
		// result = true;
	}
	return result;

}