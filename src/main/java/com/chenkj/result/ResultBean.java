package com.chenkj.result;

import java.io.Serializable;

public class ResultBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int SUCCESS = 0;
	public static final int FAIL = -1;
	private String msg = "success";
	private int code = SUCCESS;
	private T data;
	public ResultBean(){
		super();
	}
	public ResultBean(T data){
		super();
		this.data = data;
		this.code = SUCCESS;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.code = FAIL;
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
