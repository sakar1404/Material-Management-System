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

import controller.SubCategoryController;
import model.SubCategory;

/**
 * Servlet implementation class FinalEditDeleteSubCategory
 */
@WebServlet("/FinalEditDeleteSubCategory")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
maxFileSize=1024*1024*10,
maxRequestSize=1024*1024*50)
public class FinalEditDeleteSubCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalEditDeleteSubCategory() {
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
    	   SubCategory S=new SubCategory();
    	 String btn=request.getParameter("btn");
    	 if(btn.equalsIgnoreCase("Edit"))
    	 {	
         S.setSubcategoryid(Integer.parseInt(request.getParameter("subcategoryid")));
    	if(request.getParameter("categoryid").equals("-Select-"))
 		{S.setCategoryid(Integer.parseInt(request.getParameter("oldcategoryid")));
 		}
 		else
 		{S.setCategoryid(Integer.parseInt(request.getParameter("categoryid")));
 		}	
 		S.setSubcategoryname(request.getParameter("subcategoryname"));
 		
    	SubCategoryController.editRecord(S);
     }
    	 else if(btn.equalsIgnoreCase("Delete"))
    	 {  int subcategoryid=Integer.parseInt(request.getParameter("subcategoryid"));
    	    SubCategoryController.deleteRecord(subcategoryid);
    		 
    		 }
    	 else if(btn.equalsIgnoreCase("Edit Picture"))
    	 {  int subcategoryid=Integer.parseInt(request.getParameter("subcategoryid"));
    	 Part P=request.getPart("subcategoryicon");
         FileUpload F=new FileUpload(P,"C:\\Users\\Sakar\\eclipse-workspace\\MM\\WebContent\\scimages");
      
         SubCategoryController.editPicture(subcategoryid,F.filename);
 		 
 		 } 
        response.sendRedirect("SubCategoryList");
    	   
       }catch(Exception e)
       {out.println(e);}		
	}

}
