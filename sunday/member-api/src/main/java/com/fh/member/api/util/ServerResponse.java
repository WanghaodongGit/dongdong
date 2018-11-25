/** 
 * <pre>项目名称:shop-admin 
 * 文件名称:ServerRespones.java 
 * 包名:com.fh.shop.admin.util 
 * 创建日期:2018年10月18日下午6:51:05 
 * Copyright (c) 2018, lw951119@163.com All Rights Reserved.</pre> 
 */  
package com.fh.member.api.util;

/** 
 * <pre>项目名称：shop-admin    
 * 类名称：ServerRespones    
 * 类描述：    
 * 创建人：李柯爽   lw951119@163.com 
 * 创建时间：2018年10月18日 下午6:51:05    
 * 修改人：李柯爽    lw951119@163.com
 * 修改时间：2018年10月18日 下午6:51:05    
 * 修改备注
 * @version </pre>    
 */
public class ServerResponse {

	private int code;
	
	private String msg;
	
	private Object data;
	
	public ServerResponse(){
		
	}
	
	private ServerResponse(int code,String msg,Object data){
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public static ServerResponse success(Object data){
		return new ServerResponse(SystemEnum.SUCCESS.getCode(),SystemEnum.SUCCESS.getMsg(),data);
	}
	
	public static ServerResponse success(){
		return new ServerResponse(SystemEnum.SUCCESS.getCode(),SystemEnum.SUCCESS.getMsg(),null);
	}
	
	public static ServerResponse error(SystemEnum systemEnum){
		return new ServerResponse(systemEnum.getCode(),systemEnum.getMsg(),null);
	}
	
	public static ServerResponse error(int i, String s){
		return new ServerResponse(SystemEnum.ERROR.getCode(),SystemEnum.ERROR.getMsg(),null);
	}
	

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public Object getData() {
		return data;
	}
	
	
}
