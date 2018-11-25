/** 
 * <pre>项目名称:shop-admin 
 * 文件名称:SystemEnum.java 
 * 包名:com.fh.shop.admin.util 
 * 创建日期:2018年10月19日下午2:05:17 
 * Copyright (c) 2018, lw951119@163.com All Rights Reserved.</pre> 
 */  
package com.fh.member.api.util;

/** 
 * <pre>项目名称：shop-admin    
 * 类名称：SystemEnum    
 * 类描述：    
 * 创建人：李柯爽   lw951119@163.com 
 * 创建时间：2018年10月19日 下午2:05:17    
 * 修改人：李柯爽    lw951119@163.com
 * 修改时间：2018年10月19日 下午2:05:17    
 * 修改备注
 * @version </pre>    
 */
public enum SystemEnum {
	
	SUCCESS(200,"ok"),
	ERROR(-1,"error"),
	SMS_MOBILE_NULL(1000,"手机号不能为空"),
	SMS_MOBILE_INVALID(1001,"手机号不合法"),

	USERNAME_NULL(2001,"用户名为空"),
	USERNAME_EXISTS(2001,"用户名已存在"),
	REG_ERROR(2000,"验证码错误");


	private int code;
	private String msg;
	private SystemEnum(int code, String msg){
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
