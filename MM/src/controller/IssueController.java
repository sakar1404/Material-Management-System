package controller;

import java.sql.Connection;
import java.sql.ResultSet;

import model.Issue;

public class IssueController {
	public static boolean addNewRecord(Issue I)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="insert into issue(employeeid,categoryid,subcategoryid,productid,issuedate,issueto,purpose,quantity)values("+I.getEmployeeid()+","+I.getCategoryid()+","+I.getSubcategoryid()+",'"+I.getProductid()+"',curdate() ,'"+I.getIssueto()+"','"+I.getPurpose()+"','"+I.getQuantity()+"')";
	  String query1=" update products set stock=stock - '"+I.getQuantity()+"' where productid='"+I.getProductid()+"'";
	 boolean st=DbHelper.executeUpdate(cn, query);
	 boolean st1=DbHelper.executeUpdate(cn, query1);
	 return(st1);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:addNewRecord()"+e);
		}
	return(false);
		
	}
	
	public static ResultSet displayAll()
	{ 
		try{
	  Connection cn=DbHelper.openConnection();
	  String query=" select (select E.employeename from employees E where E.employeeid=I.employeeid),(select C.categoryname from category C where C.categoryid=I.categoryid),(select S.subcategoryname from subcategory S where S.subcategoryid=I.subcategoryid),(select P.productname from products P where P.productid=I.productid),I.issuedate,(select E.employeename from employees E where E.employeeid=I.issueto),I.purpose,I.quantity,I.productid from issue I";
	 ResultSet rs=DbHelper.executeQuery(cn, query);
	 return(rs);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:displayAll()"+e);
		}
	return(null);
		
	}
	public static ResultSet DisplayIssueByEmployeeId(String employeeid) {
		try {
			Connection cn=DbHelper.openConnection();
			ResultSet rs=DbHelper.executeQuery(cn, "Select (select E.employeename from employees E where E.employeeid=I.employeeid) as employee,(select C.categoryname from category C where C.categoryid=I.categoryid) as category,(select S.subcategoryname from subcategory S where S.subcategoryid=I.subcategoryid) as subcategory,(select PR.productname from products PR where PR.productid=I.productid) as product,I.issuedate,(select E.employeename from employees E where E.employeeid=I.issueto) as issueto,I.purpose,I.quantity from issue I where I.employeeid="+employeeid);
			return(rs);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public static ResultSet DisplayIssueByDate(String fromdate,String todate) {
		try {
			Connection cn=DbHelper.openConnection();
			ResultSet rs=DbHelper.executeQuery(cn, "Select I.employeeid,(select C.categoryname from category C where C.categoryid=I.categoryid) as category,(select S.subcategoryname from subcategory S where S.subcategoryid=I.subcategoryid) as subcategory,(select PR.productname from products PR where PR.productid=I.productid) as product,I.issuedate,(select E.employeename from employees E where E.employeeid=I.issueto) as issueto,I.purpose,I.quantity from issue I where I.issuedate between '"+fromdate+"' and '"+todate+"'");
			return(rs);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public static ResultSet DisplayIssueByProductId(int productid) {
		try {
			Connection cn=DbHelper.openConnection();
			String query= "Select (select E.employeename from employees E where E.employeeid= I.employeeid) as employee ,(select C.categoryname from category C where C.categoryid= I.categoryid) as category,(select S.subcategoryname from subcategory S where S.subcategoryid= I.subcategoryid) as subcategory,(select P.productname from products P where P.productid= I.productid) as products,I.issuedate(select E.employeename from employees E where E.employeeid= I.issueto) as issueto,I.purpose,I.quantity from issue I where I.productid="+productid;
			ResultSet rs=DbHelper.executeQuery(cn,query);
			System.out.println(query);
			return(rs);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public static ResultSet displayIssueDaily(String employeeid) {
		try {
			Connection cn=DbHelper.openConnection();
			String query="Select (select E.employeename from employees E where E.employeeid=I.employeeid) as employee,(select C.categoryname from category C where C.categoryid=I.categoryid) as category,(select S.subcategoryname from subcategory S where S.subcategoryid=I.subcategoryid) as subcategory,(select PR.productname from products PR where PR.productid=I.productid) as product,I.issuedate,(select E.employeename from employees E where E.employeeid=I.issueto) as issueto,I.purpose,I.quantity from issue I where I.issuedate=curdate() and I.employeeid="+employeeid; 
			System.out.println(query);
			ResultSet rs=DbHelper.executeQuery(cn,query);
			return(rs);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
}
