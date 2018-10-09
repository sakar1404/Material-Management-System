package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.EmployeeController;
import model.Employees;

/**
 * Servlet implementation class CheckEmployeeLogin
 */
@WebServlet("/CheckEmployeeLogin")
public class CheckEmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckEmployeeLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Employees E =EmployeeController.checkLogin(Integer.parseInt(request.getParameter("employeeid")), (request.getParameter("password")));
        HttpSession ses=request.getSession();
        if(E!=null)
        {
       	 ses.putValue("SEMPLOYEE", E);
       	 ses.putValue("LTIME", new java.util.Date());
       	 response.sendRedirect("EmployeeHome");
        }
        else
        {
       	 out.println("Invalid User ID/Password");
        }
	}

}
