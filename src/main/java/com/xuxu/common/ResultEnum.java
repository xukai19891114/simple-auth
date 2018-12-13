package com.xuxu.common;

public enum ResultEnum {
	//系统枚举值
	SUCCESS(1,"操作成功"),
	FAIL(-1,"操作失败");
	
	private Integer code;
	
	private String msg;
	
	private ResultEnum(Integer code , String msg){
		this.code=code;
		this.msg=msg;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
