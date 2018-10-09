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
 * Servlet implementation class DisplayEmployeeById
 */
@WebServlet("/DisplayEmployeeById")
public class DisplayEmployeeById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayEmployeeById() {
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
	       try{
	    ResultSet rs=EmployeeController.displayById(Integer.parseInt(request.getParameter("eid")));
	    	 if(rs.next())
	    	 {   
	    		 out.println("<form action='FinalEditDeleteEmployee' method='post' enctype='multipart/form-data'>");
	    		  out.println("<table class='table table-bordered' style='width:75%'><tr><td>");
	    		 out.println("<table class='table table-bordered' style='width:75%'><h2><b><i>Employee Register</i></b></h2>");
	    			out.println("<tr><td><b><i>Employee Id:</b></i></td><td><input class='form-control' type='text' name='eid' value='"+rs.getString(1)+"'></td></tr>");
	    		    String n[]=rs.getString(2).split(" ");
	    		    		
	    			out.println("<tr><td><b><i>Name:</b></i></td><td><input class='form-control' type='text' name='efn' placeholder='First Name' value='"+n[0]+"'> <input class='form-control' type='text' name='eln' placeholder='Last Name' value='"+n[1]+"'></td></tr>");
	    			out.println("<tr><td><b><i>Father's Name:</b></i></td><td><input class='form-control' type='text' name='efan' value='"+rs.getString(3)+"'></td></tr>");
	    			out.println("<tr><td><b><i>Birth Date:</b></i></td><td><input class='form-control' type='date' name='edob' value='"+rs.getString(4)+"'></td></tr>");
                   if(rs.getString(5).equals("Male")) 
                   out.println("<tr><td><b><i>Gender:</b></i></td><td><input type='radio' name='eg' value='Male' checked>Male <input type='radio' name='eg' value='Female'>Female</td></tr>");
                   else
                	  out.println("<tr><td><b><i>Gender:</b></i></td><td><input type='radio' name='eg' value='Male' >Male <input type='radio' name='eg' value='Female' checked>Female</td></tr>");
	
                   out.println("<tr><td><b><i>Permanent<br>Address:</b></i></td><td><textarea class='form-control' name='epa' rows='3' cols='25'>"+rs.getString(6)+"</textarea></td></tr>");
	    			out.println("<tr><td><b><i>State:["+rs.getString(7)+"]<input class='form-control' type=hidden  name='oldepstate' value='"+rs.getString(20)+"'></b></i></td><td><select class='form-control' name='epst' id='epst'></select></td></tr>");
	     			out.println("<tr><td><b><i>City:["+rs.getString(8)+"]<input class='form-control' type=hidden  name='oldepcity' value='"+rs.getString(21)+"'></b></i></td><td><select class='form-control' name='epct' id='epct'><option>-City-</option></select></td></tr>");
	    			
	    			out.println("<tr><td><b><i>Current<br>Address:</b></i></td><td><textarea class='form-control' name='epca' rows='3' cols='25'>"+rs.getString(9)+"</textarea></td></tr>");
	    			out.println("<tr><td><b><i>State:["+rs.getString(10)+"]<input class='form-control' type=hidden  name='oldecstate' value='"+rs.getString(22)+"'></b></i></td><td><select class='form-control' id='ecst' name='ecst'></select></td></tr>");
	    			out.println("<tr><td><b><i>City:["+rs.getString(11)+"]<input class='form-control' type=hidden  name='oldeccity' value='"+rs.getString(23)+"'></b></i></td><td><select class='form-control' id='ecct' name='ecct'><option>-City-</option></select></td></tr>");
	    			
	    			out.println("<tr><td><b><i>Contact Number:</b></i></td><td><input class='form-control' type='text' name='ecn' value='"+rs.getString(12)+"'></td></tr>");
	    			out.println("<tr><td><b><i>Mobile Number:</b></i></td><td><input class='form-control' type='text' name='embn' value='"+rs.getString(13)+"'></td></tr>");
	    			out.println("<tr><td><b><i>Email:</b></i></td><td><input class='form-control' type='email' name='eem' value='"+rs.getString(14)+"'></td></tr>");
	    			
	    			out.println("<tr><td><b><i>Qualification:</b></i></td><td><textarea class='form-control' name='equa' rows='3' cols='25'>"+rs.getString(15)+"</textarea></td></tr>");
	    			out.println("<tr><td><b><i>Designation:</b></i></td><td><input class='form-control' type='text' name='ed' value='"+rs.getString(16)+"'></td></tr>");
	    			out.println("<tr><td><b><i>Basic Salary:</b></i></td><td><input class='form-control' type='text' name='ebs' value='"+rs.getString(17)+"'></td></tr>");
	    		 	out.println("</table>");
	    		 	    		 	
	    			out.println("<input class='btn btn-success' type='submit' value='Edit' name='btn'> <input class='btn btn-danger' type='Submit' value='Delete' name='btn'>");
	    			out.println("</td><td valign='top'>");
	    			out.println("<img src=/MM/eimages/"+rs.getString(19)+" width=200 height=200><br><br>");
	    			out.println("<input class='form-control' type='file' name='eph'><br><br>");
	    			out.println("<input class='btn btn-success' type='submit' value='Edit Picture' name='btn'></td></tr></table>");
	    			
	    			out.println("</form></center></body></html>");	 
	    		  
	    	 }
	    	 else
	    	 {out.print("Not Found....");
	    		 }
	    	 
	}catch(Exception e){System.out.println(e);}
		
	}

}
