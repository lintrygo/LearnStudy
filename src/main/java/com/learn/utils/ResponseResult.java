package com.learn.utils;


import java.io.Serializable;


public class ResponseResult implements Serializable {
	
	private static final long serialVersionUID = 7285065610386199394L;

	private int code;
	private String message;
	private Object obj;
	
	public ResponseResult() {
		this.code = MsgStatus.FAILED;
	}
	public ResponseResult(int code,String message){
		this.code=code;
		this.message=message;
	}
	public ResponseResult(int code,String message,Object obj){
		this.code=code;
		this.message=message;
		this.obj=obj;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}
