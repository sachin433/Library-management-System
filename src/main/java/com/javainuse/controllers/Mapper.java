package com.javainuse.controllers;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.javainuse.model.*;
public class Mapper {

public Employee EmployeeAvailable(String id, String password) {

Employee emp = null;

  try{
//loading drivers for Postgres
 
Class.forName("org.postgresql.Driver");

//creating connection with the database 
    Connection con=DriverManager.getConnection
                   ("jdbc:postgresql://localhost:5432/postgres","postgres","root");

    Statement stmt = con.createStatement();
    String sql;
    //sql = "select * from Employee where BookName='"+name+"'";
    //System.out.print("Executing");
    sql = "Select * from employee where empid = '" + id + "' and password = '" + password + "'";
   // sql = "select * from employee;";
    ResultSet rs = stmt.executeQuery(sql);
     while(rs.next()){
    	 emp = new Employee();
    	emp.setEmpId(rs.getString("EmpId"));
    	emp.setEmpEmail(rs.getString("EmpEmail"));
        emp.setEmpName(rs.getString("EmpName"));
        emp.setPassword(rs.getString("Password"));
          }
    }
catch(Exception e)
{
     e.printStackTrace();
}
  return emp;
}

 
 

} 