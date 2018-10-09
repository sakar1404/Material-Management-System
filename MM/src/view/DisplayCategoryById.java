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
 * Servlet implementation class DisplayCategoryById
 */
@WebServlet("/DisplayCategoryById")
public class DisplayCategoryById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayCategoryById() {
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
			ResultSet rs=CategoryController.displayById(Integer.parseInt(request.getParameter("categoryid")));
			if(rs.next())
			{
				out.println("<form action='FinalEditDeleteCategory' method='post' enctype='multipart/form-data'>");
				out.println("<table class='table table-bordered' style='width:75%'><tr><td>");
				out.println("<table class='table table-bordered' style='width:75%'><h2><b><i>Category Register</i></b></h2>");
				out.println("<tr><td><b><i>Category Id:</b></i></td><td><input class='form-control' type='text' name='categoryid' value='"+rs.getString(1)+"'></td></tr>");
				out.println("<tr><td><b><i>Category Name:</b></i></td><td><input class='form-control' type='text' name='categoryname' value='"+rs.getString(2)+"'></td></tr>");
				out.println("</table>");
				out.println("<input class='btn btn-success' type='submit' value='Edit' name='btn'> <input class='btn btn-danger' type='submit' value='Delete' name='btn'>");
				out.println("</td><td valign='top'>");
    			out.println("<img src=/MM/cimages/"+rs.getString(3)+" width=200 height=200><br><br>");
    			out.println("<input class='form-control' type='file' name='categoryicon'><br><br>");
    			out.println("<input class='btn btn-success' type='submit' value='Edit Picture' name='btn'></td></tr></table>");
    			
    			out.println("</form></center></body></html>");	
			}
			else
			{
				out.print("Not Found....");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error:"+e);
		}
		}
	}

