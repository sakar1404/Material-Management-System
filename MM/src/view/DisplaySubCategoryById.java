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

import controller.SubCategoryController;
import model.Admin;

/**
 * Servlet implementation class DisplaySubCategoryById
 */
@WebServlet("/DisplaySubCategoryById")
public class DisplaySubCategoryById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplaySubCategoryById() {
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
		out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/Category.js'></script>"); 
		out.println("<html><body><center>");
		try{
			ResultSet rs=SubCategoryController.displayById(Integer.parseInt(request.getParameter("subcategoryid")));
			if(rs.next())
			{
				out.println("<form action='FinalEditDeleteSubCategory' method='post' enctype='multipart/form-data'>");
				out.println("<table class='table table-bordered' style='width:75%'><tr><td>");
				out.println("<table class='table table-bordered' style='width:75%'><h2><b><i>Sub Category Register</i></b></h2>");
				out.println("<tr><td><b><i>Category ID:["+rs.getString(1)+"]<input class='form-control' type=hidden  name='oldcategoryid' value='"+rs.getString(5)+"'></b></i></td><td><select class='form-control' name='categoryid' id='categoryid'></select></td></tr>");
				out.println("<tr><td><b><i>Sub-Category Id:</b></i></td><td><input class='form-control' type='text' name='subcategoryid' value='"+rs.getString(2)+"'></td></tr>");
				out.println("<tr><td><b><i>Sub-Category Name:</b></i></td><td><input class='form-control' type='text' name='subcategoryname' value='"+rs.getString(3)+"'></td></tr>");
				out.println("</table>");
				out.println("<input class='btn btn-success' type='submit' value='Edit' name='btn'> <input class='btn btn-danger' type='submit' value='Delete' name='btn'>");
				out.println("</td><td valign='top'>");
    			out.println("<img src='scimages/"+rs.getString(4)+"' width=200 height=200><br><br>");
    			out.println("<input class='form-control' type='file' name='subcategoryicon'><br><br>");
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
