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
 * Servlet implementation class Employeeview
 */
@WebServlet("/Employeeview")
public class Employeeview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employeeview() {
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
		out.println("<script src='asset/statecity.js'></script>");
		out.println("<html><body><center>");
		out.println("<form action='EmployeeSubmit' method='post' enctype='multipart/form-data'>");
		out.println("<table class='table table-bordered' style='width:75%; font-size:12px;' ><h2><b><i>Employee Register</i></b></h2>");
		out.println("<tr><td><b><i>Name:</b></i></td><td><input class='form-control'  type='text' name='efn' placeholder='First Name'>&nbsp;<input class='form-control' type='text' name='eln' placeholder='Last Name'></td></tr>");
		out.println("<tr><td><b><i>Father's Name:</b></i></td><td><input type='text' class='form-control' name='efan'></td></tr>");
		out.println("<tr><td><b><i>Birth Date:</b></i></td><td><input type='date' class='form-control' name='edob'></td></tr>");
		out.println("<tr><td><b><i>Gender:</b></i></td><td><input type='radio' name='eg' value='Male'>Male <input type='radio' name='eg' value='Female'>Female</td></tr>");
		out.println("<tr><td><b><i>Permanent<br>Address:</b></i></td><td><textarea class='form-control' name='epa' rows='3' cols='25'></textarea></td></tr>");
		out.println("<tr><td><b><i>State:</b></i></td><td><select name='epst' class='form-control' id='epst'></select></td></tr>");
		out.println("<tr><td><b><i>City:</b></i></td><td><select name='epct' class='form-control' id='epct'><option>-City-</option></select></td></tr>");
		
		out.println("<tr><td><b><i>Current<br>Address:</b></i></td><td><textarea name='epca' class='form-control' rows='3' cols='25'></textarea></td></tr>");
		out.println("<tr><td><b><i>State:</b></i></td><td><select name='ecst' class='form-control' id='ecst'></select></td></tr>");
		out.println("<tr><td><b><i>City:</b></i></td><td><select name='ecct' class='form-control' id='ecct'><option>-City-</option></select></td></tr>");
		
		out.println("<tr><td><b><i>Contact Number:</b></i></td><td><input type='number' class='form-control' name='ecn' ></td></tr>");
		out.println("<tr><td><b><i>Mobile Number:</b></i></td><td><input type='number' class='form-control' name='embn' pattern='[0-9]{10}'></td></tr>");
		out.println("<tr><td><b><i>Email:</b></i></td><td><input type='email' class='form-control' name='eem'></td></tr>");
		
		out.println("<tr><td><b><i>Qualification:</b></i></td><td><textarea name='equa' rows='3' class='form-control' cols='25'></textarea></td></tr>");
		out.println("<tr><td><b><i>Designation:</b></i></td><td><input type='text' class='form-control' name='ed'></td></tr>");
		out.println("<tr><td><b><i>Basic Salary:</b></i></td><td><input type='number' class='form-control' name='ebs' pattern='[0-9]+'></td></tr>");
		
		out.println("<tr><td><b><i>Password:</b></i></td><td><input class='form-control' type='password' name='epwd'></td></tr>");
		
		out.println("<tr><td><b><i>Photograph:</b></i></td><td><input type='file' class='form-control' name='eph'></td></tr>");
		
		out.println("</table>");
		out.println("<input class='btn btn-success' type='submit'> <input class='btn btn-danger'  type='reset'>");
		out.println("</form></center></body></html>");
		out.flush();
	 	
	}

}
