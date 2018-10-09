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

import controller.ProductController;
import model.Employees;

/**
 * Servlet implementation class DisplayProductById
 */
@WebServlet("/DisplayProductById")
public class DisplayProductById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayProductById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try{
			HttpSession ses=request.getSession();
			String ltime=ses.getValue("LTIME").toString();
			Employees E=(Employees)(ses.getValue("SEMPLOYEE"));
			out.println("<html>");
			out.println("<head>");
			out.println("<link href='asset/css/bootstrap.min.css' rel='stylesheet' type='text/css'>");
			out.println("<title>Employee</title>");
			out.println("</head>");
			out.println("<body>");

			String nav="<i>Employee: "+E.getEmployeename()+"["+E.getEmployeeid()+"]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+ ltime+"</i>";
			}
			catch(Exception e)
			{
				response.sendRedirect("EmployeeLogin");
			}
		out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/Employee.js'></script>"); 
		out.println("<script src='asset/Category.js'></script>"); 
		out.println("<html><body><center>");
		try{
			ResultSet rs=ProductController.displayById(Integer.parseInt(request.getParameter("productid")));
			if(rs.next())
			{	out.println("<form action='FinalEditDeleteProduct' method='post' enctype='multipart/form-data'>");
			out.println("<table class='table table-bordered' style='width:75%'><tr><td>");
			out.println("<table class='table table-bordered' style='width:75%'><h2><b><i>Product Register</i></b></h2>");
  		out.println("<tr><td><b><i>Employee:["+rs.getString(1)+"]<input class='form-control' type=hidden  name='oldemployeeid' value='"+rs.getString(12)+"'></b></i></td><td><select class='form-control' id='employeeid' name='employeeid'></td></tr>");
  		out.println("<tr><td><b><i>Category:["+rs.getString(2)+"]<input class='form-control' type=hidden  name='oldcategoryid' value='"+rs.getString(13)+"'></b></i></td><td><select class='form-control' id='categoryid' name='categoryid'></select></td></tr>");
  		out.println("<tr><td><b><i>Sub Category:["+rs.getString(3)+"]<input class='form-control' type=hidden  name='oldsubcategoryid' value='"+rs.getString(14)+"'></b></i></td><td><select class='form-control' id='subcategoryid' name='subcategoryid'><option>-Select-</option></select></td></tr>");
  		out.println("<tr><td><b><i>Product Id:</b></i></td><td><input class='form-control' type='text' name='productid' value='"+rs.getString(4)+"'></td></tr>");
  		out.println("<tr><td><b><i>Product Name:</b></i></td><td><input class='form-control' type='text' name='productname' value='"+rs.getString(5)+"'></td></tr>");
		out.println("<tr><td><b><i>Model No.:</b></i></td><td><input class='form-control' type='text' name='modelno' value='"+rs.getString(6)+"'></td></tr>");
		out.println("<tr><td><b><i>Model Name:</b></i></td><td><input class='form-control' type='text' name='modelname' value='"+rs.getString(7)+"'></td></tr>");
		out.println("<tr><td><b><i>Rate:</b></i></td><td><input class='form-control' type='number' name='rate' value='"+rs.getString(8)+"'></td></tr>");
		out.println("<tr><td><b><i>Stock:</b></i></td><td><input class='form-control' type='number' name='stock' value='"+rs.getString(9)+"'></td></tr>");
		out.println("<tr><td><b><i>Inventory level:</b></i></td><td><input class='form-control' type='number' name='inventorylevel' value='"+rs.getString(10)+"'></td></tr>");
		out.println("</table>");
		 	
		out.println("<input class='btn btn-success' type='submit' value='Edit' name='btn'> <input class='btn btn-danger' type='Submit' value='Delete' name='btn'>");
		out.println("</td><td valign='top'>");
		out.println("<img src='/MM/pimages/"+rs.getString(11)+"' width=200 height=200><br><br>");
		out.println("<input class='form-control' type='file' name='photograph'><br><br>");
		out.println("<input class='btn btn-success' type='submit' value='Edit Picture' name='btn'></td></tr></table>");
		
		out.println("</form></center></body></html>");	 
			}
			else
			{out.print("Not Found....");}
			
		}catch(Exception e)
		{System.out.println(e);}
	}

}
