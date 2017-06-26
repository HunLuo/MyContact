package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ContactDao;
import dao.GroupDao;
import dao.impl.ContactDaoImpl;
import dao.impl.GroupDaoImpl;
import model.Contact;
import model.Group;

/**
 * Servlet implementation class UpdateContactServlet
 */
@WebServlet("/UpdateContactServlet")
public class UpdateContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			int id = Integer.parseInt(request.getParameter("id"));
			ContactDao cd  = new ContactDaoImpl();
			Contact contact = cd.FindContactByid(id);
//			System.out.println(contact.getName());
//			System.out.println(contact.getAdress());
//			System.out.println(contact.getCompany());
//			System.out.println(contact.getEmail());
			GroupDao gd = new GroupDaoImpl();
			HttpSession session = request.getSession();
			int uid = (int)session.getAttribute("uid");
			List<Group> grouplist =  gd.GetAllGroup(uid);
			request.setAttribute("grouplist", grouplist);
			request.setAttribute("contact", contact);
			session.setAttribute("updateid", id);
			request.getRequestDispatcher("updateContact.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		int gid = Integer.parseInt(request.getParameter("gid"));
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("uid");
		int id = (int) session.getAttribute("updateid");
		
		Contact contact = new Contact(id,name, sex, phone, telphone, email, qq, company, adress, uid, gid);
		ContactDao cd = new ContactDaoImpl();
		PrintWriter out = response.getWriter();
		if (cd.UpdateContact(contact)) {
			out.print("<script> alert(\"修改成功！\"); </script>");
			out.print("<script>window.location.href='SelectAllServlet'</script>");
		} else {
			out.print("<script> alert(\"修改失败！\"); </script>");
			out.print("<script>window.location.href='SelectAllServlet'</script>");

		}
	}

}
