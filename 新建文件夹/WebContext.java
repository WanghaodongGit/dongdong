package com.fh.shop.api.util;

import javax.servlet.http.HttpServletRequest;

public class WebContext {
	
	private static ThreadLocal<HttpServletRequest> resultLocal = new ThreadLocal<HttpServletRequest>();
	
	public static void setRequest(HttpServletRequest request){
		resultLocal.set(request);
	}
	
	public static HttpServletRequest getRequest(){
		return resultLocal.get();
	}
	
	public static void remove(){
		resultLocal.remove();
	}
	
}
