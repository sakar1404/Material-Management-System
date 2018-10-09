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

import controller.AdminController;
import model.Admin;

/**
 * Servlet implementation class CheckAdminLogin
 */
@WebServlet("/CheckAdminLogin")
public class CheckAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Admin A =AdminController.checkLogin(Integer.parseInt(request.getParameter("adminid")), (request.getParameter("password")));
        
        if(A==null)
        {
        	out.println("Invalid User ID/Password");
        }
        else
        {
        	HttpSession ses=request.getSession();
          	 ses.putValue("SADMIN", A);
          	 ses.putValue("LTIME", new java.util.Date());
          	 response.sendRedirect("AdminHome");
        }
	}

}
