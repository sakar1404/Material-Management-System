package controller;

import java.sql.Connection;
import java.sql.ResultSet;

public class StateCityController {
	public static ResultSet GetAllStates()
	{ try{
		Connection cn=DbHelper.openConnection();
		ResultSet rs=DbHelper.executeQuery(cn, "Select * from states");
		return(rs);
		
		
	}catch(Exception e){
	 System.out.println("GetAllState():"+e);	
	}
	return(null);
		}
	public static ResultSet GetAllCities(int sid)
	{ try{
		Connection cn=DbHelper.openConnection();
		ResultSet rs=DbHelper.executeQuery(cn, "Select * from cities where stateid="+sid);
		return(rs);
		
		
	}catch(Exception e){
	 System.out.println("GetAllCities():"+e);	
	}
	return(null);
		}
}
