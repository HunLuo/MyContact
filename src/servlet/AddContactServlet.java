package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ContactDao;
import dao.impl.ContactDaoImpl;
import model.Contact;

/**
 * Servlet implementation class AddContectServlet
 */
@WebServlet("/AddContactServlet")
public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddContactServlet() {
		super();
		// TODO Auto-generated constructor stub
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
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String telphone = request.getParameter("telphone");
		String email = request.getParameter("email");
		String qq = request.getParameter("qq");
		String company = request.getParameter("company");
		String adress = request.getParameter("adress");
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("uid");
		PrintWriter out = response.getWriter();
		String s = request.getParameter("gid");
		if (s==null||s.equals("")) {
	
		
			out.print("<script> alert(\"请先添加一个分组！\"); </script>");
			out.print("<script>window.location.href='addGroup.jsp'</script>");
		} else {
			int gid = Integer.parseInt(s);
			
			
			Contact contact = new Contact(name, sex, phone, telphone, email, qq, company, adress, uid, gid);
			ContactDao cd = new ContactDaoImpl();
			
			if (cd.AddContect(contact)) {
				out.print("<script> alert(\"添加成功！\"); </script>");
				out.print("<script>window.location.href='SelectAllServlet'</script>");
			} else {
				out.print("<script> alert(\"添加失败！\"); </script>");
				out.print("<script>window.location.href='SelectAllServlet'</script>");

			}
		}
	}

}
