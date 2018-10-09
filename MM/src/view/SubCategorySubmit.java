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
 * Servlet implementation class SubCategorySubmit
 */
@WebServlet("/SubCategorySubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
maxFileSize=1024*1024*10,
maxRequestSize=1024*1024*50)
public class SubCategorySubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubCategorySubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		SubCategory S=new SubCategory();
		S.setSubcategoryname(request.getParameter("subcategoryname"));
		S.setCategoryid(Integer.parseInt(request.getParameter("categoryid")));
		Part P=request.getPart("subcategoryicon");
        FileUpload F=new FileUpload(P,"C:\\Users\\Sakar\\eclipse-workspace\\MM\\WebContent\\scimages");
        S.setSubcategoryicon(F.filename);
        boolean st=SubCategoryController.addNewRecord(S);
        out.println("<html>");
        if(st)
        { out.println("Record Submitted..<br><a href='SubCategoryView'>Add More Sub Category</a>");}
        else
        {out.println("Fail to Submit Record..<br><a href='SubCategoryView'>Add More Sub Category</a>");}
        out.println("</html>");  
        out.flush();       
        
	}

}
