package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GroupDao;
import dao.impl.GroupDaoImpl;
import model.Group;

/**
 * Servlet implementation class GetAllGroupServlet
 */
@WebServlet("/GetAllGroupServlet")
public class GetAllGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllGroupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String doflag = request.getParameter("doflag");
		GroupDao gd = new GroupDaoImpl();
		HttpSession session = request.getSession();
		int uid = (int)session.getAttribute("uid");
		List<Group> grouplist =  gd.GetAllGroup(uid);
		request.setAttribute("grouplist", grouplist);
		if(doflag.equals("1")){
			request.getRequestDispatcher("select.jsp").forward(request, response);
		}else if(doflag.equals("2")){
		
		request.getRequestDispatcher("addContact.jsp").forward(request, response);
		}
		else if(doflag.equals("3")){
			request.getRequestDispatcher("showGroup.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
