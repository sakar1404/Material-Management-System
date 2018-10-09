package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Employees;

/**
 * Servlet implementation class ProductsView
 */
@WebServlet("/ProductsView")
public class ProductsView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsView() {
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
		Employees E=(Employees)(ses.getValue("SEMPLOYEE"));
		out.println("<html>");
		out.println("<head>");
		out.println("<link href='asset/css/bootstrap.min.css' rel='stylesheet' type='text/css'>");
		out.println("<title>Employee</title>");
		out.println("</head>");
		out.println("<body>");

		String nav="<i>Employee: "+E.getEmployeename()+"["+E.getEmployeeid()+"]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ ltime+"</i>";
		out.println("<html><body><center>");
		out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/Category.js'></script>");
		out.println("<form action='ProductSubmit' method='post' enctype='multipart/form-data'>");
		out.println("<table class='table table-bordered' style='width:75%'><h2><b><i>Product Register</i></b></h2>");
		out.println("<input value="+E.getEmployeeid()+" type='hidden'  name='employeeid'>");
		out.println("<tr><td><b><i>Category :</b></i></td><td><select class='form-control' id='categoryid' name='categoryid'></select></td></tr>");
		out.println("<tr><td><b><i>Sub Category :</b></i></td><td><select class='form-control' id='subcategoryid' name='subcategoryid'><option>-Select-</option></select></td></tr>");
		out.println("<tr><td><b><i>Product Name:</b></i></td><td><input class='form-control' type='text' name='productname'></td></tr>");
		out.println("<tr><td><b><i>Model No.:</b></i></td><td><input class='form-control' type='text' name='modelno'></td></tr>");
		out.println("<tr><td><b><i>Model Name:</b></i></td><td><input class='form-control' type='text' name='modelname'></td></tr>");
		out.println("<tr><td><b><i>Rate:</b></i></td><td><input class='form-control' type='number' name='rate'></td></tr>");
		out.println("<tr><td><b><i>Stock:</b></i></td><td><input class='form-control' type='number' name='stock'></td></tr>");
		out.println("<tr><td><b><i>Inventory level:</b></i></td><td><input class='form-control' type='number' name='inventorylevel'></td></tr>");
		out.println("<tr><td><b><i>Photograph:</b></i></td><td><input class='form-control' type='file' name='photograph'></td></tr>");
		out.println("</table>");
		out.println("<input class='btn btn-success' type='submit'> <input class='btn btn-danger' type='reset'>");
		out.println("</form></center></body></html>");
		out.flush();
		}
		catch(Exception e)
		{
			response.sendRedirect("EmployeeLogin");
		}
		
	}

}
