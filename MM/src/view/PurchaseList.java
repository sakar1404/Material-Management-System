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

import controller.PurchaseController;
import model.Employees;

/**
 * Servlet implementation class PurchaseList
 */
@WebServlet("/PurchaseList")
public class PurchaseList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseList() {
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
		}
		catch(Exception e)
		{
			response.sendRedirect("EmployeeLogin");
		}
		out.println("<html><body><center>");
        try{
        	ResultSet rs=PurchaseController.displayAll();
        	if(rs.next())
			{
		out.println("<table class='table table-bordered' style='width:88%; font-size:12px;'>");
		out.println("<h2><b><i>Purchase List</b></i></h2><br><br>");
		out.println("<tr><th>Employee</th><th>Category</th><th>Subcategory</th><th>Product</th><th>Invoice no<br>Date of Invoice</th><th>Firm name</th><th>Quantity</th><th>Batch number</th><th>Price</th><th>Total Amount</th></tr>");
		do{
			out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>Invoice no.:"+rs.getString(5)+"<br>Date of Invoice:"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getString(11)+"</td></tr>");	
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
