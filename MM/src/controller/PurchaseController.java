package controller;

import java.sql.Connection;
import java.sql.ResultSet;

import model.Purchase;

public class PurchaseController {
	public static boolean addNewRecord(Purchase P)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="insert into purchase(employeeid,categoryid,subcategoryid,productid,invoiceno,dateofinvoice,firmname,quantity,batchno,price,totalamount)values("+P.getEmployeeid()+","+P.getCategoryid()+","+P.getSubcategoryid()+",'"+P.getProductid()+"','"+P.getInvoiceno()+"',curdate() ,'"+P.getFirmname()+"','"+P.getQuantity()+"','"+P.getBatchno()+"','"+P.getPrice()+"','"+P.getTotalamount()+"')";
	System.out.println(query);
	String query1=" update products set stock=stock + '"+P.getQuantity()+"' where productid='"+P.getProductid()+"'";
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
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query=" select (select E.employeename from employees E where E.employeeid=P.employeeid) as employee,(select C.categoryname from category C where C.categoryid=P.categoryid) as category,(select S.subcategoryname from subcategory S where S.subcategoryid=P.subcategoryid) as subcategory,(select PR.productname from products PR where PR.productid=P.productid) as product,P.invoiceno,P.dateofinvoice,P.firmname,P.quantity,P.batchno,P.price,P.totalamount,P.transactionid from purchase P";
	 ResultSet rs=DbHelper.executeQuery(cn, query);
	 return(rs);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:displayAll()"+e);
		}
	return(null);
	}
	
	public static ResultSet DisplayBySubCategory(int subcategoryid) {
		try{
			Connection cn=DbHelper.openConnection();
			ResultSet rs=DbHelper.executeQuery(cn, "Select * from products where subcategoryid="+subcategoryid);
			return(rs);
			
			
		}catch(Exception e){
		 System.out.println("DisplayBySubCategory():"+e);	
		}
		return(null);
	}
	
	public static ResultSet DisplayPurchasesByEmployeeId(String employeeid) {
		try {
			Connection cn=DbHelper.openConnection();
			ResultSet rs=DbHelper.executeQuery(cn, "Select (select E.employeename from employees E where E.employeeid=P.employeeid) as employee,(select C.categoryname from category C where C.categoryid=P.categoryid) as category,(select S.subcategoryname from subcategory S where S.subcategoryid=P.subcategoryid) as subcategory,(select PR.productname from products PR where PR.productid=P.productid) as product,P.transactionid,P.invoiceno,P.dateofinvoice,P.firmname,P.quantity,P.batchno,P.price,P.totalamount from purchase P where P.employeeid="+employeeid);
			return(rs);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public static ResultSet DisplayPurchaseByProductId(int productid) {
		try {
			Connection cn=DbHelper.openConnection();
			String query= "Select (select E.employeename from employees E where E.employeeid=P.employeeid) as employee,(select C.categoryname from category C where C.categoryid=P.categoryid) as category,(select S.subcategoryname from subcategory S where S.subcategoryid=P.subcategoryid) as subcategory,(select PR.productname from products PR where PR.productid=P.productid) as product,P.invoiceno,P.dateofinvoice,P.firmname,P.quantity,P.batchno,P.price,P.totalamount from purchase P where P.productid="+productid;
			ResultSet rs=DbHelper.executeQuery(cn,query);
			System.out.println(query);
			return(rs);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public static ResultSet DisplayPurchaseByDate(String fromdate,String todate) {
		try {
			Connection cn=DbHelper.openConnection();
			ResultSet rs=DbHelper.executeQuery(cn,"Select (select E.employeename from employees E where E.employeeid=P.employeeid) as employee,(select C.categoryname from category C where C.categoryid=P.categoryid) as category,(select S.subcategoryname from subcategory S where S.subcategoryid=P.subcategoryid) as subcategory,(select PR.productname from products PR where PR.productid=P.productid) as product,P.invoiceno,P.dateofinvoice,P.firmname,P.quantity,P.batchno,P.price,P.totalamount from purchase P where P.dateofinvoice between '"+fromdate+"' and '"+todate+"'");
			return(rs);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public static ResultSet displayPurchasesDaily(String employeeid) {
		try {
			Connection cn=DbHelper.openConnection();
			String query="Select (select E.employeename from employees E where E.employeeid=P.employeeid) as employee,(select C.categoryname from category C where C.categoryid=P.categoryid) as category,(select S.subcategoryname from subcategory S where S.subcategoryid=P.subcategoryid) as subcategory,(select PR.productname from products PR where PR.productid=P.productid) as product,P.invoiceno,P.dateofinvoice,P.firmname,P.quantity,P.batchno,P.price,P.totalamount from purchase P where P.dateofinvoice=curdate() and P.employeeid="+employeeid; 
			System.out.println(query);
			ResultSet rs=DbHelper.executeQuery(cn,query);
			return(rs);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
}
