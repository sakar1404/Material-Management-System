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

import controller.EmployeeController;
import model.Employees;

/**
 * Servlet implementation class FinalEditDeleteEmployee
 */
@WebServlet("/FinalEditDeleteEmployee")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
maxFileSize=1024*1024*10,
maxRequestSize=1024*1024*50)
public class FinalEditDeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalEditDeleteEmployee() {
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
    	   Employees E=new Employees();
    	 String btn=request.getParameter("btn");
    	 if(btn.equalsIgnoreCase("Edit"))
    	 {
    	E.setEmployeeid(Integer.parseInt(request.getParameter("eid")));	 
        E.setEmployeename(request.getParameter("efn")+" "+request.getParameter("eln"));
 		E.setFname(request.getParameter("efan"));
 		E.setDob(request.getParameter("edob"));
 		E.setGender(request.getParameter("eg"));
 		E.setPermanentaddress(request.getParameter("epa"));
 		if(request.getParameter("epst").equals("-State-") || request.getParameter("epct").equals("-City-"))
 		{E.setPstate(request.getParameter("oldepstate"));
 		E.setPcity(request.getParameter("oldepcity"));}
 		else
 		{E.setPstate(request.getParameter("epst"));
 		E.setPcity(request.getParameter("epct"));}
 		
 		E.setCurrentaddress(request.getParameter("epca"));
 		if(request.getParameter("ecst").equals("-State-") || request.getParameter("ecct").equals("-City-"))
 		{E.setCstate(request.getParameter("oldecstate"));
 		E.setCcity(request.getParameter("oldeccity"));}
 		else
 		{E.setCstate(request.getParameter("ecst"));
 		E.setCcity(request.getParameter("ecct"));
 			
 		}
 		
 		E.setContactno(request.getParameter("ecn"));
 		E.setMobileno(request.getParameter("embn"));
 		E.setEmailid(request.getParameter("eem"));
 		E.setQualification(request.getParameter("equa"));
 		E.setDesignation(request.getParameter("ed"));
         E.setBasicsalary(request.getParameter("ebs"));
    	EmployeeController.editRecord(E);
    	
    		 
    	 }
    	 else if(btn.equalsIgnoreCase("Delete"))
    	 {  int eid=Integer.parseInt(request.getParameter("eid"));
    	    EmployeeController.deleteRecord(eid);
    		 
    		 }
    	 else if(btn.equalsIgnoreCase("Edit Picture"))
    	 {  int eid=Integer.parseInt(request.getParameter("eid"));
    	 Part P=request.getPart("eph");
         FileUpload F=new FileUpload(P,"C:\\Users\\Sakar\\eclipse-workspace\\MM\\WebContent\\eimages");
      
         EmployeeController.editPicture(eid,F.filename);
 		 
 		 } 
        response.sendRedirect("EmployeeList");
    	   
       }catch(Exception e)
       {out.println(e);}		
	}

}
