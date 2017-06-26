package servlet;

import java.io.IOException;
import java.util.ArrayList;
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

/**
 * Servlet implementation class FindContactByName
 */
@WebServlet("/FindContactServlet")
public class FindContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindContactServlet() {
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
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String gid = request.getParameter("gid");
		GroupDao gd = new GroupDaoImpl();
		ContactDao cd = new ContactDaoImpl();
		HttpSession session = request.getSession();
		int uid = (int)session.getAttribute("uid");
		int way = Integer.parseInt(request.getParameter("way"));
		List<Contact> contactlist = new ArrayList<Contact>();
		for(Contact c:contactlist){
			c.setGname(gd.GetGroupName(c.getGid(), uid));
		}
		switch (way) {
		case 1:contactlist=cd.FindContactByname(name, uid);
			
			break;
		case 2:contactlist=cd.FindContactBysex(sex, uid);
			
			break;
		case 3:contactlist=cd.FindContactBygroup(gid, uid);
	
		break;
		default:
			break;
		}
		for(Contact c:contactlist){
			c.setGname(gd.GetGroupName(c.getGid(), uid));
		}
		request.setAttribute("contactlist", contactlist);
		request.getRequestDispatcher("show.jsp").forward(request, response);
		
	}

}
