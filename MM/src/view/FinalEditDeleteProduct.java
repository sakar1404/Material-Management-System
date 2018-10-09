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
 * Servlet implementation class FinalEditDeleteProduct
 */
@WebServlet("/FinalEditDeleteProduct")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
maxFileSize=1024*1024*10,
maxRequestSize=1024*1024*50)
public class FinalEditDeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalEditDeleteProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html>");
       try{		
    	   Products P=new Products();
    	 String btn=request.getParameter("btn");
    	 if(btn.equalsIgnoreCase("Edit"))
    	 {
    	P.setProductid(Integer.parseInt(request.getParameter("productid")));
    	if(request.getParameter("employeeid").equals("-Select-"))
 		{P.setEmployeeid(Integer.parseInt(request.getParameter("oldemployeeid")));
 		}
 		else
 		{P.setEmployeeid(Integer.parseInt(request.getParameter("employeeid")));
 		}
    	if(request.getParameter("categoryid").equals("-Select-"))
 		{P.setCategoryid(Integer.parseInt(request.getParameter("oldcategoryid")));
 		}
 		else
 		{P.setCategoryid(Integer.parseInt(request.getParameter("categoryid")));
 		}
    	if(request.getParameter("subcategoryid").equals("-Select-"))
 		{P.setSubcategoryid(Integer.parseInt(request.getParameter("oldsubcategoryid")));
 		}
 		else
 		{P.setSubcategoryid(Integer.parseInt(request.getParameter("subcategoryid")));
 		}
    	P.setProductname(request.getParameter("productname"));
    	P.setModelno(request.getParameter("modelno"));
    	P.setModelname(request.getParameter("modelname"));
    	P.setRate(Integer.parseInt(request.getParameter("rate")));
    	P.setStock(Integer.parseInt(request.getParameter("stock")));
    	P.setInventorylevel(Integer.parseInt(request.getParameter("inventorylevel")));
    	ProductController.editRecord(P);
    	 }
    	 else if(btn.equalsIgnoreCase("Delete"))
    	 {  int productid=Integer.parseInt(request.getParameter("productid"));
    	    ProductController.deleteRecord(productid);
    	 }
    	 else if(btn.equalsIgnoreCase("Edit Picture"))
    	 {  int productid=Integer.parseInt(request.getParameter("productid"));
    	 Part Part=request.getPart("photograph");
         FileUpload F=new FileUpload(Part,"C:\\Users\\Sakar\\eclipse-workspace\\MM\\WebContent\\pimages");
      
         ProductController.editPicture(productid, F.filename);
 		 
 		 } 
        response.sendRedirect("ProductList");
    	   
       }catch(Exception e)
       {out.println(e);}		
	}

}
