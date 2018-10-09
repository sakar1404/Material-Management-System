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
 * Servlet implementation class PurchaseReportByProduct
 */
@WebServlet("/PurchaseReportByProduct")
public class PurchaseReportByProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseReportByProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
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
		
		out.print(""
				+ "<table class='table table-bordered'>");
		out.println("<tr><td><b><i>Category :</b></i></td><td><select id='categoryid' class='form-control' name='categoryid'></select></td></tr>");
		out.println("<tr><td><b><i>Sub Category :</b></i></td><td><select id='subcategoryid' class='form-control' name='subcategoryid'><option>-Select-</option></select></td></tr>");
		out.println("<tr><td><b><i>Product :</b></i></td><td><select id='productid' class='form-control' name='productid'><option>-Select-</option></select></td></tr>");
		out.println( "</table>"
				+"<div id='result'></div>"
				+ "</body>"
				+ "<script src='asset/jquery-2.2.1.min.js'></script>"
				+ "<script src='asset/PurchaseReport.js'></script>"
				+ "<script src='asset/Category.js'></script>"
				+ "</html>");
	}

}
