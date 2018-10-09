package controller;

import java.sql.Connection;
import java.sql.ResultSet;

import model.Category;

public class CategoryController {
	public static boolean addNewRecord(Category C)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="insert into category(categoryname,categoryicon)values('"+C.getCategoryname()+"','"+C.getCategoryicon()+"')";
	 boolean st=DbHelper.executeUpdate(cn, query);
	 return(st);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:addNewRecord()"+e);
		}
	return(false);	
	}
	
	public static boolean editRecord(Category C)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="update category set categoryname='"+C.getCategoryname()+"' where categoryid="+C.getCategoryid();
	  boolean st=DbHelper.executeUpdate(cn, query);
	 return(st);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:editRecord()"+e);
		}
	return(false);
		
	}

	public static boolean editPicture(int categoryid,String pic)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="update category set categoryicon='"+pic+"' where categoryid="+categoryid;
	 boolean st=DbHelper.executeUpdate(cn, query);
	 return(st);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:editPicture()"+e);
		}
	return(false);
		
	}
	public static boolean deleteRecord(int categoryid)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="delete from category where categoryid="+categoryid;
	 boolean st=DbHelper.executeUpdate(cn, query);
	 return(st);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:deleteRecord()"+e);
		}
	return(false);
		
	}
	public static ResultSet displayAll()
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query=" select * from category";
	 ResultSet rs=DbHelper.executeQuery(cn, query);
	 return(rs);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:displayAll()"+e);
		}
	return(null);
	}
	public static ResultSet displayById(int categoryid)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="select C.categoryid,C.categoryname,C.categoryicon from category C where categoryid="+categoryid;
	   
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
