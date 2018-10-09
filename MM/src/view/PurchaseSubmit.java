package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.PurchaseController;
import model.Purchase;

/**
 * Servlet implementation class PurchaseSubmit
 */
@WebServlet("/PurchaseSubmit")
public class PurchaseSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Purchase P=new Purchase();
		
		P.setEmployeeid(Integer.parseInt(request.getParameter("employeeid")));
		P.setCategoryid(Integer.parseInt(request.getParameter("categoryid")));
		P.setSubcategoryid(Integer.parseInt(request.getParameter("subcategoryid")));
		P.setProductid(Integer.parseInt(request.getParameter("productid")));
		P.setInvoiceno(request.getParameter("invoiceno"));
		P.setFirmname(request.getParameter("firmname"));
		P.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		P.setBatchno(request.getParameter("batchno"));
		P.setPrice(Integer.parseInt(request.getParameter("price")));
		P.setTotalamount(Integer.parseInt(request.getParameter("quantity"))*Integer.parseInt(request.getParameter("price")));
		boolean st=PurchaseController.addNewRecord(P);
        out.println("<html>");
        if(st)
        { out.println("Record Submitted..<br><a href='PurchaseView'>Add More data</a>");}
        else
        {out.println("Fail to Submit Record..<br><a href='PurchaseView'>Add More data</a>");}
        out.println("</html>");  
        out.flush();       
		
	}

}
