package com.xuxu.common;


import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @author 许凯
 *
 * 2018年4月12日
 */
public class JsonData {
	
	private boolean ret;
	
	private String msg;
	
	private Object data;
	
	
	
	public boolean isRet() {
		return ret;
	}

	public void setRet(boolean ret) {
		this.ret = ret;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public JsonData(boolean ret){
		this.ret = ret;
	}
	
	/**
	 * 成功情况下 只输入信息和json数据
	 * @param msg
	 * @param data
	 * @return
	 */
	public static JsonData success(String msg,Object data){
		JsonData jsonData = new JsonData(true);
		jsonData.msg = msg;
		jsonData.data=data;
		return jsonData;
	}
	
	/**
	 * 成功情况下 只输入数据
	 * @param data
	 * @return
	 */
	public static JsonData success(Object data){
		JsonData jsonData = new JsonData(true);
		jsonData.data=data;
		return jsonData;
	}
	
	/**
	 * 成功情况
	 * @return
	 */
	public static JsonData success(){
		JsonData jsonData = new JsonData(true);
		return jsonData;
	}
	
	/**
	 * 失败
	 * @param msg
	 * @param data
	 * @return
	 */
	public static JsonData fail(String msg){
		JsonData jsonData = new JsonData(false);
		jsonData.msg = msg;
		return jsonData;
	}
	
	public Map<String, Object> toMap(){
		HashMap<String,Object> map = new HashMap<String,Object>(16);
		map.put("ret", ret);
		map.put("msg", msg);
		map.put("data", data);
		return map;
	}
}


