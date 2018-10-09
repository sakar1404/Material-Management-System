package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CategoryController;
import model.Admin;

/**
 * Servlet implementation class CategoryList
 */
@WebServlet("/CategoryList")
public class CategoryList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryList() {
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
		try{
			ResultSet rs=CategoryController.displayAll();
			if(rs.next())
			{
		out.println("<table class='table table-bordered' style='width:75%' border=1>");
		out.println("<h2><b><i>Category List</b></i></h2><br><br>");
        out.println("<tr><th>Category ID</th><th>Category Name</th><th>Category Icon</th><th>Update</th></tr>");
		do{
			out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td><img src='/MM/cimages/"+rs.getString(3)+"' width='45' height='45'></td><td><a href=DisplayCategoryById?categoryid="+rs.getString(1)+"><button class='btn btn-info btn-xs'>Edit/Delete</button></a></td></tr>");	
		}while(rs.next());
		out.println("</table>");
			}
			else
			{
				out.println("No Records found...");
			}
		
		}
		catch(Exception e)
		{
			out.println(e);
		}
		out.println("</center></body></html>");
		out.flush();
	}

}
