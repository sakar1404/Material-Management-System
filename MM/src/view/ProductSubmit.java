package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;
import controller.ProductController;
import model.Products;

/**
 * Servlet implementation class ProductSubmit
 */
@WebServlet("/ProductSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
maxFileSize=1024*1024*10,
maxRequestSize=1024*1024*50)
public class ProductSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Products P=new Products();
		P.setEmployeeid(Integer.parseInt(request.getParameter("employeeid")));
		P.setCategoryid(Integer.parseInt(request.getParameter("categoryid")));
		P.setSubcategoryid(Integer.parseInt(request.getParameter("subcategoryid")));
		P.setProductname(request.getParameter("productname"));
		P.setModelno(request.getParameter("modelno"));
		P.setModelname(request.getParameter("modelname"));
		P.setRate(Integer.parseInt(request.getParameter("rate")));
		P.setStock(Integer.parseInt(request.getParameter("stock")));
		P.setInventorylevel(Integer.parseInt(request.getParameter("inventorylevel")));
		Part Part=request.getPart("photograph");
        FileUpload F=new FileUpload(Part,"C:\\Users\\Sakar\\eclipse-workspace\\MM\\WebContent\\pimages");
        P.setPhotograph(F.filename);
        boolean st=ProductController.addNewRecord(P);
        out.println("<html>");
        if(st)
        { out.println("Record Submitted..<br><a href='ProductsView'>Add More Products</a>");}
        else
        {out.println("Fail to Submit Record..<br><a href='ProductsView'>Add More Products</a>");}
        out.println("</html>");  
        out.flush();       
        
	}

}
