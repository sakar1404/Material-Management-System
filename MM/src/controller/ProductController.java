package controller;

import java.sql.Connection;
import java.sql.ResultSet;

import model.Products;

public class ProductController {
	
	public static ResultSet getProductQuantity() {
		try {
			Connection cn = DbHelper.openConnection();
			String query = "select productid, stock, inventorylevel from products";
			ResultSet rs = DbHelper.executeQuery(cn, query);
			return rs;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	
	public static boolean addNewRecord(Products P)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="insert into products(employeeid,categoryid,subcategoryid,productname,modelno,modelname,rate,stock,inventorylevel,photograph)values("+P.getEmployeeid()+","+P.getCategoryid()+","+P.getSubcategoryid()+",'"+P.getProductname()+"','"+P.getModelno()+"','"+P.getModelname()+"',"+P.getRate()+","+P.getStock()+","+P.getInventorylevel()+",'"+P.getPhotograph()+"') ";
	  System.out.println(query);
	 boolean st=DbHelper.executeUpdate(cn, query);
	 return(st);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:addNewRecord()"+e);
		}
	return(false);
		}
	
	public static boolean editRecord(Products P)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="update products set employeeid='"+P.getEmployeeid()+"',categoryid='"+P.getCategoryid()+"',subcategoryid='"+P.getSubcategoryid()+"',productname='"+P.getProductname()+"',modelno='"+P.getModelno()+"',modelname='"+P.getModelname()+"',rate='"+P.getRate()+"',stock='"+P.getStock()+"',inventorylevel='"+P.getInventorylevel()+"' where productid="+P.getProductid();
	   System.out.println(query);
	  boolean st=DbHelper.executeUpdate(cn, query);
	 return(st);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:editRecord()"+e);
		}
	return(false);
		
	}

	public static boolean deleteRecord(int productid)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="delete from products where productid="+productid;
	 boolean st=DbHelper.executeUpdate(cn, query);
	 return(st);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:deleteRecord()"+e);
		}
	return(false);
		
	}
	public static boolean editPicture(int productid,String pic)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="update products set photograph='"+pic+"' where productid="+productid;
	 boolean st=DbHelper.executeUpdate(cn, query);
	 return(st);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:editPicture()"+e);
		}
	return(false);
		
	}
	public static ResultSet displayAll()
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query=" select (select E.employeename from employees E where E.employeeid=P.employeeid),(select C.categoryname from category C where C.categoryid=P.categoryid),(select S.subcategoryname from subcategory S where S.subcategoryid=P.subcategoryid),P.productid,P.productname,P.modelno,P.modelname,P.rate,P.stock,P.inventorylevel,P.photograph from products P";
	 ResultSet rs=DbHelper.executeQuery(cn, query);
	 return(rs);
	  }
	catch(Exception e)
		{
		System.out.println("Error:displayAll()"+e);
		}
	return(null);
		}
	
	
	public static ResultSet displayById(int productid)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="select (select E.employeename from employees E where E.employeeid=P.employeeid) as employee,(select C.categoryname from category C where C.categoryid=P.categoryid) as category,(select S.subcategoryname from subcategory S where S.subcategoryid=P.subcategoryid) as subcategory,P.productid,P.productname,P.modelno,P.modelname,P.rate,P.stock,P.inventorylevel,P.photograph,P.employeeid,P.categoryid,P.subcategoryid from products P where P.productid="+productid;
	  System.out.println(query); 
	 ResultSet rs=DbHelper.executeQuery(cn, query);
	 return(rs);
	}
	catch(Exception e)
		{
		System.out.println("Error:displayById()"+e);
		}
	return(null);
	}
}

