package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class SourceTarget 
{
	@Test
	public void testDB() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		System.out.println("Driver Loaded");
		
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium", "root", "Oracle@2020");
		
		System.out.println("DB connected to mysql db");
		
		Statement smt = con.createStatement();
		
		ResultSet rs = smt.executeQuery("SELECT \r\n" + 
				"    firstName\r\n" + 
				"FROM\r\n" + 
				"    seleniumuser\r\n" + 
				"UNION ALL \r\n" + 
				"SELECT \r\n" + 
				"    firstName\r\n" + 
				"    \r\n" + 
				"FROM\r\n" + 
				"    seleniumuser1; ");
		
		while(rs.next())
		{
			String firstname = rs.getString("firstname");
			
			System.out.println("DataBAse record is:"+firstname);
			
//			String email = rs.getString("email");
//			
//			System.out.println("DataBAse record is:"+email);
		}
		con.close();
		System.out.println("***********************");
	}

}
