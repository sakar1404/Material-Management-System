package controller;

import java.sql.Connection;
import java.sql.ResultSet;

import model.Admin;

public class AdminController {

	public static Admin checkLogin(int adminid,String password)
	{
		try{
			Connection cn=DbHelper.openConnection();
			String query="select * from admin where adminid='"+adminid+"' and password='"+password+"'";
			ResultSet rs=DbHelper.executeQuery(cn, query);
			Admin A=new Admin();
            if(rs.next())
            {
           	 A.setAdminid(rs.getInt(1));
           	 A.setName(rs.getString(2));
           	 return A;
            }
           
            return null;
	}catch(Exception e)
		{
			System.out.println(e);
		return null;}
		
	}
}
