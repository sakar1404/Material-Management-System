package controller;

import java.sql.Connection;
import java.sql.ResultSet;

import model.Employees;

public class EmployeeController {
	public static boolean addNewRecord(Employees E)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="insert into employees(employeename,fname,dob,gender,permanentaddress,pstate,pcity,currentaddress,cstate,ccity,contactno,mobileno,emailid,qualification,designation,basicsalary,password,photograph)values('"+E.getEmployeename()+"','"+E.getFname()+"','"+E.getDob()+"','"+E.getGender()+"','"+E.getPermanentaddress()+"','"+E.getPstate()+"','"+E.getPcity()+"','"+E.getCurrentaddress()+"','"+E.getCstate()+"','"+E.getCcity()+"','"+E.getContactno()+"','"+E.getMobileno()+"','"+E.getEmailid()+"','"+E.getQualification()+"','"+E.getDesignation()+"','"+E.getBasicsalary()+"','"+E.getPassword()+"','"+E.getPhotograph()+"')";
	 boolean st=DbHelper.executeUpdate(cn, query);
	 return(st);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:addNewRecord()"+e);
		}
	return(false);
		
	}
	public static boolean editRecord(Employees E)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="update employees set employeename='"+E.getEmployeename()+"',fname='"+E.getFname()+"',dob='"+E.getDob()+"',gender='"+E.getGender()+"',permanentaddress='"+E.getPermanentaddress()+"',pstate='"+E.getPstate()+"',pcity='"+E.getPcity()+"',currentaddress='"+E.getCurrentaddress()+"',cstate='"+E.getCstate()+"',ccity='"+E.getCcity()+"',contactno='"+E.getContactno()+"',mobileno='"+E.getMobileno()+"',emailid='"+E.getEmailid()+"',qualification='"+E.getQualification()+"',designation='"+E.getDesignation()+"',basicsalary='"+E.getBasicsalary()+"' where employeeid="+E.getEmployeeid();
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

	public static boolean deleteRecord(int eid)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="delete from employees where employeeid="+eid;
	 boolean st=DbHelper.executeUpdate(cn, query);
	 return(st);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:addNewRecord()"+e);
		}
	return(false);
		
	}
	public static boolean editPicture(int eid,String pic)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="update employees set photograph='"+pic+"' where employeeid="+eid;
	 boolean st=DbHelper.executeUpdate(cn, query);
	 return(st);
	  
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
	  String query=" select E.employeeid,E.employeename,E.fname,E.dob,E.gender,E.permanentaddress,(select S.statename from States S where S.stateid=E.pstate),(select C.cityname from cities C where C.cityid=E.pcity),E.currentaddress,(select S.statename from States S where S.stateid=E.cstate),(select C.cityname from cities C where C.cityid=E.ccity),E.contactno,E.mobileno,E.emailid,E.qualification,E.designation,E.basicsalary,E.password,E.photograph from employees E";
	 ResultSet rs=DbHelper.executeQuery(cn, query);
	 return(rs);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:displayAll()"+e);
		}
	return(null);
		
	}
	public static ResultSet displayById(int eid)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="select E.employeeid,E.employeename,E.fname,E.dob,E.gender,E.permanentaddress,(select S.statename from States S where S.stateid=E.pstate),(select C.cityname from cities C where C.cityid=E.pcity),E.currentaddress,(select S.statename from States S where S.stateid=E.cstate),(select C.cityname from cities C where C.cityid=E.ccity),E.contactno,E.mobileno,E.emailid,E.qualification,E.designation,E.basicsalary,E.password,E.photograph,E.pstate,E.pcity,E.cstate,E.ccity from employees E where E.employeeid="+eid;
	   
	 ResultSet rs=DbHelper.executeQuery(cn, query);
	 return(rs);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:displayById()"+e);
		}
	return(null);
		
	}
	public static Employees checkLogin(int employeeid,String password)
	{
		try{
			Connection cn=DbHelper.openConnection();
			String query="select * from employees where employeeid='"+employeeid+"' and password='"+password+"'";
			ResultSet rs=DbHelper.executeQuery(cn, query);
			Employees E=new Employees();
            if(rs.next())
            {
           	 E.setEmployeeid(rs.getInt(1));
           	 E.setEmployeename(rs.getString(2));
           	return E;
            }
            return null;
		
	}catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
		
	}
}
