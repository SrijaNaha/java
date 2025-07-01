package SRC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
protected Connection conn;

public DBConnection() 
{
try 
{
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BDS", "root",  "srija1706@#"  );
System.out.println("Database connection established.");
} 

catch (ClassNotFoundException | SQLException e) 
{
System.out.println("MySQL JDBC Driver not found.");
e.printStackTrace();
} 
}


public void CloseDBConnection() {
try 
{
if (conn != null && !conn.isClosed()) 
{
conn.close();
System.out.println("Database connection closed.");
}
} 

catch (SQLException e) 
{
System.out.println("Error!! Failed to close database connection.");
e.printStackTrace();
}
}
}
