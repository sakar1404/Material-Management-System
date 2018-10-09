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
 * Servlet implementation class IssueView
 */
@WebServlet("/IssueView")
public class IssueView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueView() {
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
		out.println("<script src='asset/Issue.js'></script>");
		out.println("<form action='IssueSubmit' method='post'>");
		out.println("<table class='table table-bordered' style='width:75%'><h2><b><i>Issue</i></b></h2>");
		out.println("<input value="+E.getEmployeeid()+" type='hidden'  name='employeeid'>");
		out.println("<tr><td><b><i>Category :</b></i></td><td><select class='form-control' id='categoryid' name='categoryid'><option>-Select-</option></select></td></tr>");
		out.println("<tr><td><b><i>Sub Category :</b></i></td><td><select class='form-control' id='subcategoryid' name='subcategoryid'><option>-Select-</option></select></td></tr>");
		out.println("<tr><td><b><i>Product :</b></i></td><td><select class='form-control' id='productid' name='productid'><option>-Select-</option></select></td></tr>");
		out.println("<tr><td><b><i>Issue to:</b></i></td><td><select class='form-control' id='employeeid' name='issueto'><option>-Select-</option></select></td></tr>");
		out.println("<tr><td><b><i>Purpose:</b></i></td><td><textarea class='form-control' name='purpose' rows='3' cols='25'></textarea></td></tr>");
		out.println("<tr><td><b><i>Quantity:</b></i></td><td><input class='form-control' type='number' name='quantity' id='quantity'>"
				+ "<br><span id='valid'></span>"
				+ "</td></tr>");
		out.println("</table>");
		out.println("<input class='btn btn-success' type='submit' id='btn'> <input class='btn btn-danger' type='reset'>");
		out.println("</form></body></center></html>");
		out.flush();
		}
		catch(Exception e)
		{
			response.sendRedirect("EmployeeLogin");
		}
	}
	}

