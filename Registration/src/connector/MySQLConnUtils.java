package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
	
	 public static Connection getMySQLConnection()
	         throws ClassNotFoundException, SQLException {
	     // Note: Change the connection parameters accordingly.
	     String hostName = "localhost";
	     String dbName = "test";
	     String userName = "java";
	     String password = "volos1312!#!@";
	     return getMySQLConnection(hostName, dbName, userName, password);
	 }
	 
	 public static Connection getMySQLConnection(String hostName, String dbName,
	         String userName, String password) throws SQLException,
	         ClassNotFoundException {
	    
	     Class.forName("com.mysql.jdbc.Driver");
	  
	     // URL Connection for MySQL:
	     // Example: 
	     // jdbc:mysql://localhost:3306/simplehr
	     String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
	     System.out.println("Connecting database...");
	     try{
	     Connection conn = DriverManager.getConnection(connectionURL, userName,password);
	     System.out.println("CONNECTED...");
	     return conn;
	     } catch (SQLException e) {
	    	    throw new IllegalStateException("Cannot connect the database!", e);
	     }
	     
	 }
}
