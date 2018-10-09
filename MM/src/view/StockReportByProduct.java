package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StockReportByProduct
 */
@WebServlet("/StockReportByProduct")
public class StockReportByProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockReportByProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.print("<html>"
				+ "<body>");
				out.println("<tr><td><b><i>Category :</b></i></td><td><select id='categoryid' name='categoryid'></select></td></tr>");
				out.println("<tr><td><b><i>Sub Category :</b></i></td><td><select id='subcategoryid' name='subcategoryid'><option>-Select-</option></select></td></tr>");
				out.println("<tr><td><b><i>Product :</b></i></td><td><select id='productid' name='productid'><option>-Select-</option></select></td></tr>");
				out.println("<div id='result'></div>"
						+ "</body>"
						+ "<script src='asset/jquery-2.2.1.min.js'></script>"
						+ "<script src='asset/Stock.js'></script>"
						+ "<script src='asset/Category.js'></script>"
						+ "</html>");
		
	}

}
