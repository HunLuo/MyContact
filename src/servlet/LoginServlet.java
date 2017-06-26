package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import util.MD5;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8"); 
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		String loginname = (String) request.getParameter("loginname");
		String loginpwd = (String) request.getParameter("loginpwd");
		User user ;
		MD5 md5 = new MD5();
		loginpwd= md5.makeMD5(loginpwd);
		UserDao userdao = new UserDaoImpl();
		String code = request.getParameter("code").toUpperCase();
		HttpSession session = request.getSession();
		String vcode =(String)session.getAttribute("vcode");
		PrintWriter out = response.getWriter();
		user = userdao.getUser(loginname, loginpwd);
		
		
		
		
		
		
		if(!vcode.equals(code)){
			out.print("<script> alert(\"验证码不正确！ \"); </script>");
			out.print("<script>window.location.href='login.jsp'</script>");
		}
	else if (user != null) {
			request.setAttribute("user", user);
			
			session.setAttribute("uid", user.getUid());
			session.setAttribute("uname", loginpwd);
			session.setAttribute("nickname", user.getNickname());
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} 
		
		
		else
		{
			
			out.print("<script> alert(\"登陆失败！请检查用户名和密码\"); </script>");
			out.print("<script>window.location.href='login.jsp'</script>");
				
				

			}
		}

	}


