package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GroupDao;
import dao.impl.GroupDaoImpl;

/**
 * Servlet implementation class AddGroupServlet
 */
@WebServlet("/AddGroupServlet")
public class AddGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGroupServlet() {
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
		String gname = request.getParameter("gname");
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("uid");
		GroupDao gd = new GroupDaoImpl();
		PrintWriter out = response.getWriter();
		if (gd.AddGroup(gname ,uid)) {
			out.print("<script> alert(\"添加成功！\"); </script>");
			out.print("<script>window.location.href='GetAllGroupServlet?doflag=3'</script>");
		} else {
			out.print("<script> alert(\"添加失败！\"); </script>");
			out.print("<script>window.location.href='GetAllGroupServlet?doflag=3'</script>");

		}
	}
}
