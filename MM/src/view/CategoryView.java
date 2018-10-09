package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;

/**
 * Servlet implementation class CategoryView
 */
@WebServlet("/CategoryView")
public class CategoryView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try{
			HttpSession ses=request.getSession();
			String ltime=ses.getValue("LTIME").toString();
			Admin A=(Admin)(ses.getValue("SADMIN"));
			out.println("<html>");
			out.println("<head>");
			out.println("<link href='asset/css/bootstrap.min.css' rel='stylesheet' type='text/css'>");
			out.println("<title>Admin</title>");
			out.println("</head>");
			out.println("<body>");

			String nav="<i>Admin: "+A.getName()+"["+A.getAdminid()+"]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ ltime+"</i>";
			
			}
			catch(Exception e)
			{
				response.sendRedirect("AdminLogin");
			}
		
		
		out.println("<html><body><center>");
		out.println("<form action='CategorySubmit' method='post' enctype='multipart/form-data'>");
		out.println("<table class='table table-bordered' style='width:75%'><h4><b><i>Category Register</i></b></h4>");
		out.println("<tr><td><b><i>Category Name:</b></i></td><td><input class='form-control' type='text' name='categoryname'></td></tr>");
		out.println("<tr><td><b><i>Icon:</b></i></td><td><input class='form-control' type='file' name='categoryicon'></td></tr>");
		out.println("</table>");
		out.println("<input class='btn btn-success btn-xs' type='submit'> <input class='btn btn-danger btn-xs' type='reset'>");
		out.println("</form></center></body></html>");
		out.flush();
	}

}
