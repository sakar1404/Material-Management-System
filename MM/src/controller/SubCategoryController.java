package controller;

import java.sql.Connection;
import java.sql.ResultSet;

import model.SubCategory;

public class SubCategoryController {
	public static boolean addNewRecord(SubCategory S)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="insert into subcategory(categoryid,subcategoryname,subcategoryicon)values('"+S.getCategoryid()+"','"+S.getSubcategoryname()+"','"+S.getSubcategoryicon()+"')";
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
	public static boolean editRecord(SubCategory S)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="update subcategory set categoryid='"+S.getCategoryid()+"',subcategoryname='"+S.getSubcategoryname()+"' where subcategoryid="+S.getSubcategoryid();
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
	public static boolean deleteRecord(int subcategoryid)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="delete from subcategory where subcategoryid="+subcategoryid;
	 boolean st=DbHelper.executeUpdate(cn, query);
	 return(st);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:deleteRecord()"+e);
		}
	return(false);
		
	}
	public static boolean editPicture(int subcategoryid,String pic)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="update subcategory set subcategoryicon='"+pic+"' where subcategoryid="+subcategoryid;
	 boolean st=DbHelper.executeUpdate(cn, query);
	 return(st);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:editPictures()"+e);
		}
	return(false);
		
	}

	public static ResultSet displayAll()
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query=" select (select C.categoryname from category C where C.categoryid=S.categoryid),S.subcategoryid,S.subcategoryname,S.subcategoryicon from subcategory S";
	 ResultSet rs=DbHelper.executeQuery(cn, query);
	 return(rs);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:displayAll()"+e);
		}
	return(null);
		
	}
	public static ResultSet DisplayByCategory(int categoryid) {
		try{
			Connection cn=DbHelper.openConnection();
			ResultSet rs=DbHelper.executeQuery(cn, "Select * from subcategory where categoryid="+categoryid);
			return(rs);
			
			
		}catch(Exception e){
		 System.out.println("DisplayByCategory():"+e);	
		}
		return(null);
	}
	public static ResultSet displayById(int subcategoryid)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="select (select C.categoryname from category C where C.categoryid=S.categoryid),S.subcategoryid,S.subcategoryname,S.subcategoryicon,S.categoryid from subcategory S where S.subcategoryid="+subcategoryid;
	   
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
