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
 * Servlet implementation class ProductList
 */
@WebServlet("/ProductList")
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductList() {
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
        	ResultSet rs=ProductController.displayAll();
        	if(rs.next())
			{
		out.println("<table class='table table-bordered' style='width:95%; font-size:12px;'>");
		out.println("<h2><b><i>Product List</b></i></h2><br><br>");
		out.println("<tr><th>Employee</th><th>Category</th><th>Product</th><th>Model</th><th>Rate</th><th>Stock</th><th>Inventory Level</th><th>Update</th></tr>");
		do{
			out.println("<tr><td>Employee:"+rs.getString(1)+"</td><td>Category:"+rs.getString(2)+"<br>"+"Sub Category:"+rs.getString(3)+"</td><td>Product Id:"+rs.getString(4)+"<br>Product Name:"+rs.getString(5)+"<br><img src="
					+ "'pimages/"+rs.getString(11)+"' width=45 height=45></td><td>Model No."+rs.getString(6)+"<br>Model Name:"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td><td><a href=DisplayProductById?productid="+rs.getString(4)+"><button class='btn btn-info btn-xs'>Edit/Delete</button></a></td></tr>");	
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
