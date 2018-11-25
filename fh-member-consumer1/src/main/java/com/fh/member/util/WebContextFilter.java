package com.fh.member.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Servlet Filter implementation class WebContextFilter
 */
public class WebContextFilter implements Filter {

    /**
     * Default constructor. 
     */
    public WebContextFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 将请求与当前线程绑定
		WebContext.setRequest((HttpServletRequest) request);
		try{
			// 继续执行请求
			chain.doFilter(request, response);
		}finally{
			//解除绑定
			WebContext.remove();
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
