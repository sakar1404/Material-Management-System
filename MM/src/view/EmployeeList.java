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

import controller.EmployeeController;
import model.Admin;

/**
 * Servlet implementation class EmployeeList
 */
@WebServlet("/EmployeeList")
public class EmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeList() {
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
			ResultSet rs=EmployeeController.displayAll();
			if(rs.next())
			{
		out.println("<table class='table table-bordered'  style='font-size:12px; width:75%;'>");
		out.println("<h2><b><i>Employee List</b></i></h2><br><br>");
        out.println("<tr><th>Employee</th><th>Gender<br>BirthDate</th><th>Permanent<br>Address</th><th>Current<br>Address</th><th>Contact<br>Information</th><th>Qualification<br>Designation</th><th>Update</th></tr>");
		do{
			out.println("<tr><td>Id:"+rs.getString(1)+"<br>"+"<img src=/MM/eimages/"+rs.getString(19)+" width=45 height=45><br>"+rs.getString(2)+"<br>F'Name:"+rs.getString(3)+"</td><td>"+rs.getString(5)+"<br>"+rs.getString(4)+"</br></td><td>"+rs.getString(6)+"<br>"+rs.getString(8)+","+rs.getString(7)+"</td><td>"+rs.getString(9)+"<br>"+rs.getString(11)+","+rs.getString(10)+"</td><td>Ph:"+rs.getString(12)+"<br>Mob:"+rs.getString(13)+"<br>Mail:"+rs.getString(14)+"</td><td>"+rs.getString(15)+"<br>"+rs.getString(16)+"</br>"+rs.getString(17)+"</td><td><a href=DisplayEmployeeById?eid="+rs.getString(1)+"><button class='btn btn-info btn-xs'>Edit/Delete</button></a></td></tr>");	
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
