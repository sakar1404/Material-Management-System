package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.IssueController;
import model.Issue;

/**
 * Servlet implementation class IssueSubmit
 */
@WebServlet("/IssueSubmit")
public class IssueSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Issue I=new Issue();
		
		I.setEmployeeid(Integer.parseInt(request.getParameter("employeeid")));
		I.setCategoryid(Integer.parseInt(request.getParameter("categoryid")));
		I.setSubcategoryid(Integer.parseInt(request.getParameter("subcategoryid")));
		I.setProductid(Integer.parseInt(request.getParameter("productid")));
		I.setIssueto(request.getParameter("issueto"));
		I.setPurpose(request.getParameter("purpose"));
		I.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		boolean st=IssueController.addNewRecord(I);
        out.println("<html>");
        if(st)
        { out.println("Record Submitted..<br><a href='IssueView'>Add More data</a>");}
        else
        {out.println("Fail to Submit Record..<br><a href='IssueView'>Add More data</a>");}
        out.println("</html>");  
        out.flush();       
	}

}
