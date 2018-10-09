package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubCategoryView
 */
@WebServlet("/SubCategoryView")
public class SubCategoryView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubCategoryView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/Category.js'></script>");
	
		out.println("<form action='SubCategorySubmit' method='post' enctype='multipart/form-data'>");
		out.println("<table><caption><b><i>Sub-Category Register</i></b></caption>");
		out.println("<tr><td><b><i>Category ID:</b></i></td><td><select id='categoryid' name='categoryid'></select></td></tr>");
		out.println("<tr><td><b><i>Name:</b></i></td><td><input type='text' name='subcategoryname'></td></tr>");
		out.println("<tr><td><b><i>Icon:</b></i></td><td><input type='file' name='subcategoryicon'></td></tr>");
		out.println("</table>");
		out.println("<input type='submit'> <input type='reset'>");
		out.println("</form></html>");
		out.flush();
	}

}
