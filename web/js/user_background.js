tuHeight();

function tuHeight() {
	// 获取高度和款度，然后赋值为高即可
}

/** **** 点击全选和不全选 **** */
function UBc1_inputs() {
	if ($('.UBc1_input').is(':checked')) {
		$(".UBc2_input").prop('checked', true);
	} else {
		$(".UBc2_input").prop('checked', false);
	}
	UBc2_inputs();
};
/** **** 点击全选和不全选 结束 **** */

/** ********** 选中前面的CheckBox按钮， 整行的背景发生改变************ */
UBc2_inputs();

function UBc2_inputs() {
	var UBc2_inputs = $(".UBc2_input");
	for (var i = 0; i < UBc2_inputs.length; i++) {
		if ($('.UBc2_input').eq(i).is(':checked')) {
			$('.UBc2_input').eq(i).parent().parent().css('background-color',
					'#DBF0E9');
		} else {
			$('.UBc2_input').eq(i).parent().parent().css('background-color',
					'#F9F9F9');
		}
	}
}
$('.UBc2_input').click(
		function() {
			var UBc2_inputs = $(".UBc2_input");
			for (var i = 0; i < UBc2_inputs.length; i++) {
				if ($('.UBc2_input').eq(i).is(':checked')) {
					$('.UBc2_input').eq(i).parent().parent().css(
							'background-color', '#DBF0E9');
				} else {
					$('.UBc2_input').eq(i).parent().parent().css(
							'background-color', '#F9F9F9');
				}
			}
			// 如果有其中一个没有选中，则第一行的不为选中不为
			for (var j = 0; j < UBc2_inputs.length; j++) {
				if ($('.UBc2_input').eq(j).not(':checked')) {
					$(".UBc1_input").prop('checked', false);
				}
			}
		});

/** ********** 选中前面的CheckBox按钮， 整行的背景发生改变************ */

/** ***************** 动态获取浏览器高度，设置高度为动态的 ****************** */
window.onresize = function() {
	outoWidth();
};
outoWidth();

function outoWidth() {
	$(".UB_mengcheng_center").css('height', $(window).height());
}

/** ***************** 动态获取浏览器高度，设置高度为动态的 ****************** */

/** *************** 点击图片,图片放大 和 关闭蒙层 *************** */

$(".UBc_two6_img").click(function() {
	var lujing;
	lujing = $(this).attr("src");
	$(".UB_mengceng").show();
	$(".UB_mc_center_img").prop("src", lujing);
});

// 点击关闭蒙层
$(".UB_mc_center_absolute").click(function() {
	$(".UB_mengceng").hide();
});
/** *************** 点击图片,图片放大 和 关闭蒙层 结束 *************** */

/** *********************** 选择通过和不通过时的显示和隐藏 ********************* */

function UBc_right_selVal() {

	var UBc_right_selectVal = $(".UBc_right_select").val();
	if (UBc_right_selectVal == "审核通过") {
		$(".UBc_C_censor_one").hide();
		$(".UBc_censor_bon").css({
			"background-color" : "#0096FD",
			"border" : "1px solid #1AA0FC"
		});
		$(".UBc_censor_bon").prop("disabled", false);
	}
	if (UBc_right_selectVal == "审核未通过") {
		$(".UBc_C_censor_one").show();
		$(".UBc_censor_bon").css({
			"background-color" : "#CCCCCC",
			"border" : "1px solid #DDDDDD"
		});
		$(".UBc_censor_bon").prop("disabled", true);

		// 判断输入框的值是否为空，当为空时，提交按钮为灰色，不为空时，提交按钮为蓝色
		$(".UBc_Cc_one_text").keydown(function() {
			var UBc_Cc_one_text1 = '';
			UBc_Cc_one_text1 += $.trim($(".UBc_Cc_one_text").val());
			if (UBc_Cc_one_text1.length == 0 || UBc_Cc_one_text1.length == 1) {
				console.log("空");
				$(".UBc_censor_bon").css({
					"background-color" : "#CCCCCC",
					"border" : "1px solid #DDDDDD"
				});
				$(".UBc_censor_bon").prop("disabled", true);
			}
			if (UBc_Cc_one_text1.length >= 2) {
				console.log("值");
				$(".UBc_censor_bon").css({
					"background-color" : "#0096FD",
					"border" : "1px solid #1AA0FC"
				});
				$(".UBc_censor_bon").prop("disabled", false);
			}
			console.log(UBc_Cc_one_text1.length);
		});
		// 在textarea输入值时，判断是否为空 结束
	}
};

/** *********************** 选择通过和不通过时的显示和隐藏 结束********************* */
