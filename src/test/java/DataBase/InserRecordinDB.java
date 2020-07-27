package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class InserRecordinDB 
{

	@Test
	public void testInsertinDB() throws ClassNotFoundException, SQLException
	{
		
		//Register JDBC Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		System.out.println("Driver Loaded");
		
		
		//Open a Connection
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium", "root", "Oracle@2020");
		
		System.out.println("DB connected to mysql db");
		
		//Execute a statement
		Statement run = con.createStatement();
		
		String s= "insert into seleniumuser values('Ashray','akku@gmail.com')";
		
		run.executeUpdate(s);
		
		ResultSet rs = run.executeQuery("select * from seleniumuser");
		
		while(rs.next()) 
		{
			//Retrieve by column name
			String firstname = rs.getString("firstname");
			
			System.out.println("DataBAse record is:"+firstname);
			
			String email = rs.getString("email");
			
			System.out.println("DataBAse record is:"+email);
		}
		
		String u = "UPDATE seleniumuser SET email = 'akarsh@gmail.com' WHERE firstname='Akarsh'";
		
		run.executeUpdate(u);
		
		String d = "delete from seleniumuser where firstname='Akarsh'";
		
		run.execute(d);
		
		con.close();

	}
}


