package DataBase;

import org.testng.annotations.Test;

import java.sql.Connection;
import  java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectingMySQL 
{
	
	@Test
	public void testDB() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		System.out.println("Driver Loaded");
		
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium", "root", "Oracle@2020");
		
		System.out.println("DB connected to mysql db");
		
		Statement smt = con.createStatement();
		
		ResultSet rs = smt.executeQuery("select * from seleniumuser");
		
		while(rs.next())
		{
			String firstname = rs.getString("firstname");
			
			System.out.println("DataBAse record is:"+firstname);
			
			String email = rs.getString("email");
			
			System.out.println("DataBAse record is:"+email);
		}
		con.close();
		System.out.println("***********************");
	}

}
