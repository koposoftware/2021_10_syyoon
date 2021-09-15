package kr.co.hana.interceptor;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.hana.login.vo.LoginVO;

@SuppressWarnings("deprecation")
public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request, HttpServlet response, Object handler) throws Exception{
		HttpSession session = request.getSession();
		LoginVO loginVO = (LoginVO)session.getAttribute("loginVO");
		
		if(loginVO==null) {
			
			String uri = request.getRequestURI();
			uri = uri.substring(request.getContextPath().length());

			session.setAttribute("dest", uri);
			return false;
		}
		
		return true;
	}

}
