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

import controller.CategoryController;
import model.Category;

/**
 * Servlet implementation class FinalEditDeleteCategory
 */
@WebServlet("/FinalEditDeleteCategory")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
maxFileSize=1024*1024*10,
maxRequestSize=1024*1024*50)
public class FinalEditDeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalEditDeleteCategory() {
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
			Category C=new Category();
			String btn=request.getParameter("btn");
	    	 if(btn.equalsIgnoreCase("Edit"))
	    	 {
	    	C.setCategoryid(Integer.parseInt(request.getParameter("categoryid")));
	    	C.setCategoryname(request.getParameter("categoryname"));
	    	CategoryController.editRecord(C);
	    	 }
	    	else if(btn.equalsIgnoreCase("Delete"))
	    	 {  int categoryid=Integer.parseInt(request.getParameter("categoryid"));
	    	    CategoryController.deleteRecord(categoryid);
	    		 
	    		 }
	    	 else if(btn.equalsIgnoreCase("Edit Picture"))
	    	 {  int categoryid=Integer.parseInt(request.getParameter("categoryid"));
	    	 Part P=request.getPart("categoryicon");
	         FileUpload F=new FileUpload(P,"C:\\Users\\Sakar\\eclipse-workspace\\MM\\WebContent\\cimages");
	      
	         CategoryController.editPicture(categoryid,F.filename);
	 		 
	 		 } 
	        response.sendRedirect("CategoryList");
			
		}
		
		catch(Exception e)
		{System.out.println(e);}
	}

}
