package com.henghao.Garden.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * function 系统测试类
 * 
 * date 2017.02.28
 * 
 * @author 严彬荣
 */
@Controller
public class Test {

	@ResponseBody
	@RequestMapping(value = "/test", produces = "application/json;charset=utf-8")
	public String testController(String name) {
		String welcome = "欢迎使用";
		System.out.println(name);
		return welcome;
	}
}
