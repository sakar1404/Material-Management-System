package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.Employees;

/**
 * Servlet implementation class EmployeeHome
 */
@WebServlet("/EmployeeHome")
public class EmployeeHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession ses=request.getSession();
		try{
		String ltime=ses.getValue("LTIME").toString();
		Employees E=(Employees)(ses.getValue("SEMPLOYEE"));
	
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("    <meta charset='utf-8'>");
		out.println("    <meta http-equiv='X-UA-Compatible' content='IE=edge'>");
		out.println("    <meta name='viewport' content='width=device-width, initial-scale=1'>");
		out.println("    <meta name='description' content=''>");
		out.println("    <meta name='author' content=''>");
		out.println("    <link rel='icon' type='image/png' sizes='16x16' href='admin/assets/images/favicon.png'>");
		out.println("    <title>EmployeeHome</title>");
		out.println("    <link href='admin/assets/plugins/bootstrap/css/bootstrap.min.css' rel='stylesheet'>");
		out.println("    <link href='admin/main/css/style.css' rel='stylesheet'>");
		out.println("    <link href='admin/main/css/colors/blue.css' id='theme' rel='stylesheet'></head>");
		out.println("<body class='fix-header fix-sidebar card-no-border'>");
		out.println("    <div class='preloader'>");
		out.println("        <svg class='circular' viewBox='25 25 50 50'>");
		out.println("            <circle class='path' cx='50' cy='50' r='20' fill='none' stroke-width='2' stroke-miterlimit='10' /> </svg>");
		out.println("    </div>");
		out.println("    <div id='main-wrapper'>");
		out.println("        <header class='topbar' style='background-color:#6d6696;'>");
		out.println("            <nav class='navbar top-navbar navbar-expand-md navbar-light'>");
		out.println("                 <div class='navbar-header'>");
		out.println("                    <a class='navbar-brand' href='#'>");
		out.println("  <b>");
	//	out.println("                            <img src='admin/assets/images/logo-icon.png' alt='homepage' class='dark-logo' />");
	//	out.println("                            <img src='admin/assets/images/logo-light-icon.png' alt='homepage' class='light-logo' />");
		out.println("                        </b><span>");
		out.println(" <img src='logo.png' alt='homepage' class='dark-logo' />");
		out.println(" <img src='logo.png' class='light-logo' alt='homepage' /></span> </a>");
		out.println("                </div>");
		out.println("        </header>");
		out.println("        <aside class='left-sidebar'>");
		out.println("            <div class='scroll-sidebar'>");
		out.println("                <div class='user-profile'>");
		out.println("                    <div class='profile-img'><img src='finance.png' alt='user' />");
		out.println("                            <div class='notify setpos'> <span class='heartbit'></span> <span class='point'></span> </div>");
		out.println("                    </div>");
		out.println("                    <div class='profile-text'>");
		out.println("                        <h5>Employee</h5>");
		out.println("                        <a href='EmployeeLogin' class='' data-toggle='tooltip' title='Logout'><i class='mdi mdi-power'></i></a>");
		out.println("                        <div class='dropdown-menu animated flipInY'>");
		out.println("                        <a href='EmployeeLogin' class='dropdown-item'><i class='fa fa-power-off'></i> Logout</a>");
		out.println("                        </div>");
		out.println("                    </div>");
		out.println("                </div>");
		out.println("                <nav class='sidebar-nav'>");
		out.println("                    <ul id='sidebarnav'>");
		out.println("                         <li class='nav-devider'></li>");
		
		out.println("<li> <a class='has-arrow waves-effect waves-dark' href='#' aria-expanded='false'><i class='mdi mdi-bullseye'></i><span class='hide-menu'>Product</span></a>");
		out.println("<ul aria-expanded='false' class='collapse'>");
		out.println("<li><a href=ProductsView target=mw>New Product</a></li>");
		out.println("<li><a href=ProductList target=mw>Display Product</a></li>");
		out.println("</ul></li>");
		
		out.println("<li> <a class='has-arrow waves-effect waves-dark' href='#' aria-expanded='false'><i class='mdi mdi-bullseye'></i><span class='hide-menu'>Purchase</span></a>");
		out.println("<ul aria-expanded='false' class='collapse'>");
		out.println("<li><a href=PurchaseView target=mw>New Purchase</a></li>");
		out.println("<li><a href=PurchaseList target=mw>Display Purchase</a></li>");
		out.println("</ul></li>");
		
		out.println("<li> <a class='has-arrow waves-effect waves-dark' href='#' aria-expanded='false'><i class='mdi mdi-bullseye'></i><span class='hide-menu'>Issue</span></a>");
		out.println("<ul aria-expanded='false' class='collapse'>");
		out.println("<li><a href=IssueView target=mw>New Issue</a></li>");
		out.println("<li><a href=IssueList target=mw>Display Issue</a></li>");
		out.println("</ul></li>");
		
		
		
		
		
		
		out.println("<li><a class='has-arrow waves-effect waves-dark' href='EmployeeLogin'><i class='mdi mdi-bullseye'></i><span class='hide-menu'>Logout</span></a></li>");
		out.println("                    </ul>");
		out.println("                </nav>");
		out.println("            </div>");
		out.println("        </aside>");
		out.println("<div class='page-wrapper'>");
		out.println("            <div class='row page-titles'>");
		out.println("                <div class='col-md-12 align-self-center'>");
		out.println(" <h3 class='text-themecolor'><center>Employee Home</center></h3>");
		
		//Prepare Session Navigation
		String nav="<center><i>Employee: "+E.getEmployeename()+"["+E.getEmployeeid()+"]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ ltime+"</i>";
		out.println(nav+"</center>");
		}
		catch(Exception e)
		{
			response.sendRedirect("EmployeeLogin");
		}
		out.println("                </div>");
		out.println("            </div>");
		out.println("            <div class='container-fluid'>");
		out.println("                <div class='row'>");
		out.println("                    <div class='col-12'>");
		out.println("                        <div class='card'>");
		out.println("                            <div class='card-body'>");
		out.println(" <iframe name='mw' style='width:100%; height:1000px;' frameborder='0'></iframe>");
		out.println("                                </div>");
		out.println("                        </div>");
		out.println("                    </div>");
		out.println("                </div>");
		out.println("            </div>");
		out.println("            <footer class='footer'>");
		out.println("                © 2018  Admin");
		out.println("            </footer>");
		out.println("        </div>");
		out.println("    </div>");
		out.println("    <script src='admin/assets/plugins/jquery/jquery.min.js'></script>");
		out.println("    <script src='admin/assets/plugins/bootstrap/js/popper.min.js'></script>");
		out.println("    <script src='admin/assets/plugins/bootstrap/js/bootstrap.min.js'></script>");
		out.println("    <script src='admin/main/js/jquery.slimscroll.js'></script>");
		out.println("    <script src='admin/main/js/waves.js'></script>");
		out.println("    <script src='admin/main/js/sidebarmenu.js'></script>");
		out.println("    <script src='admin/assets/plugins/sticky-kit-master/dist/sticky-kit.min.js'></script>");
		out.println("    <script src='admin/assets/plugins/sparkline/jquery.sparkline.min.js'></script>");
		out.println("    <script src='admin/main/js/custom.min.js'></script>");
		out.println("    <script src='admin/assets/plugins/styleswitcher/jQuery.style.switcher.js'></script>");
		out.println("</body>");
		out.println("</html>");
	
		
	}

}
