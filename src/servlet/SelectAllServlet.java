package servlet;

import java.io.IOException;
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
 * Servlet implementation class BookSelectServlet
 */
@WebServlet("/SelectAllServlet")
public class SelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		ContactDao cd =new ContactDaoImpl();
		GroupDao gd = new GroupDaoImpl();
		HttpSession session = request.getSession();
		int uid = (int)session.getAttribute("uid");
		List<Contact> contactlist= cd.SelectAll(uid);
		for(Contact c:contactlist){
			c.setGname(gd.GetGroupName(c.getGid(), uid));
		}
		request.setAttribute("contactlist", contactlist);
		
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
