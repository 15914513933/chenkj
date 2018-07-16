package com.chenkj.result;

import java.io.Serializable;
import java.util.List;

public class ResultBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int SUCCESS = 0;
	public static final int FAIL = -1;
	private String msg = "success";
	private int code = SUCCESS;
	private T data;
	private long total = 0L;
	public ResultBean(){
		super();
	}
	public ResultBean(T data){
		super();
		this.data = data;
		this.code = SUCCESS;
		if(data instanceof List){
			total = ((List<?>)data).size();
		}
	}
	public ResultBean(T data,long total){
		super();
		this.data = data;
		this.code = SUCCESS;
		this.total = total;
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
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
	
}
