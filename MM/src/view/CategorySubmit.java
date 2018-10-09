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
 * Servlet implementation class CategorySubmit
 */
@WebServlet("/CategorySubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
maxFileSize=1024*1024*10,
maxRequestSize=1024*1024*50)
public class CategorySubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategorySubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Category C=new Category();
		C.setCategoryname(request.getParameter("categoryname"));
		Part P=request.getPart("categoryicon");
        FileUpload F=new FileUpload(P,"C:\\Users\\Sakar\\eclipse-workspace\\MM\\WebContent\\cimages");
        C.setCategoryicon(F.filename);
        boolean st=CategoryController.addNewRecord(C);
        out.println("<html>");
        if(st)
        { out.println("Record Submitted..<br><a href='CategoryView'>Add More Category</a>");}
        else
        {out.println("Fail to Submit Record..<br><a href='CategoryView'>Add More Category</a>");}
        out.println("</html>");  
        out.flush();       
        
 	}
	}


