package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import util.MD5;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String newpwd = request.getParameter("newpwd"); 
		String oldpwd = request.getParameter("oldpwd"); 
		User user = new User();
		MD5 md5 = new MD5();
		oldpwd= md5.makeMD5(oldpwd);
		newpwd= md5.makeMD5(newpwd);
		UserDao userdao = new UserDaoImpl();
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("uid");
		PrintWriter out = response.getWriter();
		user = userdao.getUserById(uid);
		String pwd = user.getUserpwd();
		if(!pwd.equals(oldpwd)){
			out.print("<script> alert(\"密码错误！\"); </script>");
			out.print("<script>window.location.href='changePassword.jsp'</script>");
		}else{
			if(userdao.changePassword(uid, newpwd)){
				out.print("<script> alert(\"修改成功！\"); </script>");
				out.print("<script>window.location.href='LogoutServlet'</script>");
			}else{
				out.print("<script> alert(\"修改失败！\"); </script>");
				out.print("<script>window.location.href='changePassword.jsp'</script>");
			}
		}
	}

}
