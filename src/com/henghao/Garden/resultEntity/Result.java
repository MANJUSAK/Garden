package com.henghao.Garden.resultEntity;

/**
 * 结果集实体
 * 
 * @author 严彬荣
 */
public class Result {
	// 定义后台信息返回结果信息
	private String result;
	// 定义返回结果数字便于安卓端判断信息
	private int status;
	// 定义文件路径
	private String path;
	// 定义后台数据返回结果集
	private Object data;

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Result(String result, int status) {
		super();
		this.result = result;
		this.status = status;
	}

	public Result(String result, int status, Object data) {
		super();
		this.result = result;
		this.status = status;
		this.data = data;
	}

	public Result(String result, int status, String path, Object data) {
		super();
		this.result = result;
		this.status = status;
		this.path = path;
		this.data = data;
	}

	public Result(int status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
