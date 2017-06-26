package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	  public void doFilter(ServletRequest request, ServletResponse response,
			              FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
			            HttpServletRequest servletRequest = (HttpServletRequest) request;
			            HttpServletResponse servletResponse = (HttpServletResponse) response;
			            HttpSession session = servletRequest.getSession();
			    
			           // 获得用户请求的URI
			            String path = servletRequest.getRequestURI();
			            //System.out.println(path);
			            
			            String nickname = (String) session.getAttribute("nickname");
			    

			            
			            // 登陆页面无需过滤
			            if(path.indexOf("/login.jsp") > -1) {
			                chain.doFilter(servletRequest, servletResponse);
			                return;
			            }
			    
			            if (nickname == null) {
			                // 跳转到登陆页面 
			               servletResponse.sendRedirect("login.jsp");
			            } else {
			                // 已经登陆,继续此次请求
			                chain.doFilter(request, response);
			            }
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException  {
		// TODO Auto-generated method stub

	}

}
