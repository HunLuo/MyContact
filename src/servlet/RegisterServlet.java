package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GroupDao;
import dao.UserDao;
import dao.impl.GroupDaoImpl;
import dao.impl.UserDaoImpl;
import model.User;
import util.MD5;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8"); 
		request.setCharacterEncoding("utf-8");
		 String  username = request.getParameter("registeruser"); 
		 String  password = request.getParameter("registerpwd"); 
		 String  nickname = request.getParameter("truename"); 
		 MD5 md5 = new MD5();
		 password= md5.makeMD5(password);
		User user = new User(username,password,nickname);
		UserDao userdao = new UserDaoImpl();
		PrintWriter out = response.getWriter();
		if(!userdao.isUserExist(username)){
			boolean result  = userdao.setUser(user);
			user =  userdao.getUser(username, password);
			if(result){
				user =  userdao.getUser(username, password);
				int uid = user.getUid();
				GroupDao groupdao = new GroupDaoImpl();
				groupdao.AddGroup("家人",uid);
				groupdao.AddGroup("朋友",uid);
				groupdao.AddGroup("同学",uid);
				out.print("<script> alert(\"注册成功！\"); </script>");
				out.print("<script>window.location.href='login.jsp'</script>");
				
			}
			else{
				
				out.print("<script> alert(\"注册失败！\"); </script>");
				out.print("<script>window.location.href='login.jsp'</script>");
			}
		}
		else{
			out.print("<script> alert(\"用户已存在！\"); </script>");

			out.print("<script>window.location.href='login.jsp'</script>");
		}
		
		 
	}

}
