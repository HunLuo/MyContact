package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GroupDao;
import dao.impl.GroupDaoImpl;

/**
 * Servlet implementation class DeleteGroupServlet
 */
@WebServlet("/DeleteGroupServlet")
public class DeleteGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteGroupServlet() {
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
		int gid = Integer.parseInt(request.getParameter("gid"));
		GroupDao cd  = new GroupDaoImpl();
		PrintWriter out = response.getWriter();
		if(cd.DeleteGroup(gid)){
					
				out.print("<script> alert(\"删除成功！\"); </script>");
				out.print("<script>window.location.href='GetAllGroupServlet?doflag=3'</script>");
		}
		else{
			out.print("<script> alert(\"删除失败！\"); </script>");
			out.print("<script>window.location.href='GetAllGroupServlet?doflag=3'</script>");
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
