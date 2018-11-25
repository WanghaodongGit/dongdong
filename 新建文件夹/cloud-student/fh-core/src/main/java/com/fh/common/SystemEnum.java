/** 
 * <pre>项目名称:shop-admin 
 * 文件名称:SystemEnum.java 
 * 包名:com.fh.shop.admin.common 
 * 创建日期:2018年10月19日上午10:59:33 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.fh.common;

/** 
 * <pre>项目名称：shop-admin    
 * 类名称：SystemEnum    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2018年10月19日 上午10:59:33    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2018年10月19日 上午10:59:33    
 * 修改备注：       
 * @version </pre>    
 */
public enum SystemEnum {
	
	SUCCESS(200, "OK"),
	ERROR(-1, "ERROR");

	private int code;
	
	private String msg;
	
	private SystemEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}


	public String getMsg() {
		return msg;
	}

	
}
