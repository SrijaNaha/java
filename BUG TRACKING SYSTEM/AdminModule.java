package SRC;

import java.sql.*;
import java.util.*;

public class AdminModule extends DBConnection
{
Scanner sc = new Scanner(System.in);

public AdminModule()
{
super();
}

public class Manager
{

public void AddManager()
{
String choice;
do
{
PreparedStatement stmt = null;
try
{
System.out.println("Enter the Manager code: ");
int Code = sc.nextInt();
sc.nextLine();
System.out.println("Enter the Manager name: ");
String Name = sc.nextLine();
System.out.println("Enter the Manager email id: ");
String Email= sc.nextLine();
System.out.println("Enter the Manager password: ");
String Pass = sc.nextLine();
System.out.println("Enter the Manager gender: ");
String Gender= sc.nextLine();
System.out.println("Enter the Manager Date of Birth: ");
String DOB = sc.nextLine();
System.out.println("Enter the Manager Phone no: ");
long Mobile = sc.nextLong();
sc.nextLine();
String Role = "Manager";
 stmt = conn.prepareStatement("INSERT INTO Employee VALUES (?,?,?,?,?,?,?,?)");
stmt.setInt(1,Code);
stmt.setString(2,Name);
stmt.setString(3,Email);
stmt.setString(4,Pass);
stmt.setString(5,Gender);
stmt.setString(6,DOB);
stmt.setLong(7,Mobile);
stmt.setString(8,Role);

int i = stmt.executeUpdate();
if(i>0)
{
System.out.println("Manager Account added successfully!!");
}
else
{
System.out.println("Error adding Manager!!");
}
}
catch(Exception e)
{
e.printStackTrace();
}
finally 
{
try
{
if (stmt != null) stmt.close();  
} 
catch (SQLException e) 
{
e.printStackTrace();
}
}
System.out.println("Add Another Manager Account? (Yes/No): ");
choice = sc.nextLine().trim();
}while(choice.equalsIgnoreCase("Yes"));
}

public void ViewManager()
{
Statement sm = null;
ResultSet rs = null;
try
{
sm = conn.createStatement();
rs = sm.executeQuery("SELECT * FROM Employee WHERE Role = 'Manager'");
System.out.println("---------Manager Details------------");
while(rs.next())
{
System.out.println("Manager Code: " + rs.getInt(1));
System.out.println("Manager Name: " + rs.getString(2));
System.out.println("Manager email id: " + rs.getString(3));
System.out.println("Manager gender: " + rs.getString(5));
System.out.println("Manager Date of Birth: " + rs.getString(6));
System.out.println("Manager Phone No: " + rs.getLong(7));
System.out.println("-----------------------------------------------------------------------------");
}
}

catch(Exception e)
{
System.out.println("Error in Viewing Manager details: " + e.getMessage());
e.printStackTrace();
}
finally 
{
try 
{
if (rs != null) rs.close();
if (sm != null) sm.close();
}
catch (SQLException e) 
{
e.printStackTrace();
}
}
}

public void DeleteManager() 
{
String choice;
do
{
PreparedStatement stmt = null;
try 
{
System.out.print("Enter Manager Code to delete: ");
int Code = sc.nextInt();
sc.nextLine();
stmt = conn.prepareStatement("DELETE FROM Employee WHERE empCode = ? AND Role = 'manager'");
stmt.setInt(1, Code);
int i = stmt.executeUpdate();

if(i>0)
{
System.out.println("Manager Account deleted successfully!!");
}
else
{
System.out.println("Error deleting Manager!!");
}
}
catch (Exception e)
{
e.printStackTrace();
}
finally 
{
try
{
if (stmt != null) stmt.close();  
} 
catch (SQLException e) 
{
e.printStackTrace();
}
}
System.out.println("Delete Another Manager Account? (Yes/No): ");
choice = sc.nextLine().trim();
}while(choice.equalsIgnoreCase("Yes"));
}


public void UpdateManager() 
{
String choice;
do
{
PreparedStatement stmt = null;
try
{
System.out.print("Enter Manager Code to update: ");
int Code = sc.nextInt(); 
sc.nextLine();
System.out.print("Enter new Email: ");
String Email = sc.nextLine();
System.out.print("Enter new Mobile No: ");
long Mobile = sc.nextLong();
sc.nextLine();
 stmt = conn.prepareStatement("UPDATE Employee SET empEmail = ?, mobileNo = ? WHERE empCode = ? AND Role = 'manager'" );
stmt.setString(1,Email );
stmt.setLong(2, Mobile);
stmt.setInt(3,Code );

int i = stmt.executeUpdate();
if(i>0)
{
System.out.println("Manager Account updated successfully!!");
}
else
{
System.out.println("Error updating Manager Account!!");
}
}
catch (Exception e) 
{
e.printStackTrace();
}
finally 
{
try
{
if (stmt != null) stmt.close();  
} 
catch (SQLException e) 
{
e.printStackTrace();
}
}
System.out.println("Update Another Manager Account? (Yes/No): ");
choice = sc.nextLine().trim();
}while(choice.equalsIgnoreCase("Yes"));
}
}



public class Employee
{
public void AddEmployee()
{
String choice;
do
{
PreparedStatement stmt = null;
try
{
System.out.println("Enter the Employee code: ");
int Code = sc.nextInt();
sc.nextLine();
System.out.println("Enter the Employee name: ");
String Name = sc.nextLine();
System.out.println("Enter the Employee email id: ");
String Email= sc.nextLine();
System.out.println("Enter the Employee password: ");
String Pass = sc.nextLine();
System.out.println("Enter the Employee gender: ");
String Gender= sc.nextLine();
System.out.println("Enter the Employee Date of Birth: ");
String DOB = sc.nextLine();
System.out.println("Enter the Employee Phone no: ");
long Mobile = sc.nextLong();
sc.nextLine();
System.out.println("Enter the Role of Empoyee(Developer/Tester): ");
String Role = sc.nextLine();
stmt = conn.prepareStatement("INSERT INTO Employee VALUES (?,?,?,?,?,?,?,?)");
stmt.setInt(1,Code);
stmt.setString(2,Name);
stmt.setString(3,Email);
stmt.setString(4,Pass);
stmt.setString(5,Gender);
stmt.setString(6,DOB);
stmt.setLong(7,Mobile);
stmt.setString(8,Role);

int i = stmt.executeUpdate();
if(i>0)
{
System.out.println("Employee Account added successfully!!");
}
else
{
System.out.println("Error adding Employee!!");
}
}
catch(Exception e)
{
e.printStackTrace();
}
finally 
{
try
{
if (stmt != null) stmt.close();  
} 
catch (SQLException e) 
{
e.printStackTrace();
}
}
System.out.println("Add Another Employee Account? (Yes/No): ");
choice = sc.nextLine().trim();
}while(choice.equalsIgnoreCase("Yes"));
}




public void ViewEmployee()
{
Statement sm = null;
ResultSet rs = null;
try
{
sm = conn.createStatement();
rs = sm.executeQuery("SELECT * FROM Employee WHERE Role = 'Developer' OR Role = 'Tester'");
System.out.println("----------Employee Details---------");
while(rs.next())
{
System.out.println(" Employee Code: " + rs.getInt(1));
System.out.println("Employee Name: " + rs.getString(2));
System.out.println("Employee email id: " + rs.getString(3));
System.out.println("Employee gender: " + rs.getString(5));
System.out.println("Employee Date of Birth: " + rs.getString(6));
System.out.println("Employee Phone No: " + rs.getLong(7));
System.out.println("-----------------------------------------------------------------------------");
}
}

catch(Exception e)
{
System.out.println("Error in Viewing Employee details" + e.getMessage());
e.printStackTrace();
}
finally 
{
try 
{
if (rs != null) rs.close();
if (sm != null) sm.close();
}
catch (SQLException e) 
{
e.printStackTrace();
}
}
}


public void DeleteEmployee() 
{
String choice;
do
{
PreparedStatement stmt = null;
try 
{
System.out.print("Enter Employee Code to delete: ");
int Code = sc.nextInt();
sc.nextLine();
stmt = conn.prepareStatement("DELETE FROM Employee WHERE empCode = ? AND (Role = 'Developer' OR Role = 'Tester')");
stmt.setInt(1, Code);
int i = stmt.executeUpdate();

if(i>0)
{
System.out.println("Employee Account deleted successfully!!");
}
else
{
System.out.println("Error deleting Employee!!");
}
}
catch (Exception e)
{
e.printStackTrace();
}
finally 
{
try
{
if (stmt != null) stmt.close();  
} 
catch (SQLException e) 
{
e.printStackTrace();
}
}
System.out.println("Delete Another Employee Account? (Yes/No): ");
choice = sc.nextLine().trim();
}while(choice.equalsIgnoreCase("Yes"));
}




public void UpdateEmployee()
{
String choice;
do
{
PreparedStatement stmt = null;
try
{
System.out.print("Enter Employee Code to update: ");
int Code = sc.nextInt(); 
sc.nextLine();
System.out.print("Enter new Email: ");
String Email = sc.nextLine();
System.out.print("Enter new Mobile No: ");
long Mobile = sc.nextLong();
sc.nextLine();
stmt = conn.prepareStatement("UPDATE Employee SET empEmail = ?, mobileNo = ? WHERE empCode = ? AND (Role = 'Developer' OR Role = 'Tester')" );
stmt.setString(1,Email );
stmt.setLong(2, Mobile);
stmt.setInt(3,Code );

int i = stmt.executeUpdate();
if(i>0)
{
System.out.println("Employee Account updated successfully!!");
}
else
{
System.out.println("Error updating Employee!!");
}
}
catch (Exception e) 
{
e.printStackTrace();
}
finally 
{
try
{
if (stmt != null) stmt.close();  
} 
catch (SQLException e) 
{
e.printStackTrace();
}
}
System.out.println("Update Another Employee Account? (Yes/No): ");
choice = sc.nextLine().trim();
}while(choice.equalsIgnoreCase("Yes"));
}
}


public void ViewProjects()
{
Statement sm = null;
ResultSet rs = null;
try
{
sm = conn.createStatement();
rs = sm.executeQuery("SELECT * FROM Project");
System.out.println("----------Project Details-----------");
while(rs.next())
{
System.out.println(" Project ID: " + rs.getInt(1));
System.out.println("Project Name: " + rs.getString(2));
System.out.println("Start Date: " + rs.getString(3));
System.out.println("End Date: " + rs.getString(4));
System.out.println("Project Description: " + rs.getString(5));
System.out.println("-----------------------------------------------------------------------------");
}
}

catch(Exception e)
{
System.out.println("Error in Viewing Project details" + e.getMessage());
e.printStackTrace();
}
finally 
{
try 
{
if (rs != null) rs.close();
if (sm != null) sm.close();
}
catch (SQLException e) 
{
e.printStackTrace();
}
}
}


public void ViewBugReports()
{
Statement sm = null;
ResultSet rs = null;
try
{
sm = conn.createStatement();
rs = sm.executeQuery("SELECT * FROM BugReport");
System.out.println("-----------Bug Report List---------------:");
while(rs.next())
{
System.out.println(" Bug No.: " + rs.getInt(1));
System.out.println("Bug Code: " + rs.getInt(2));
System.out.println("Project ID: " + rs.getInt(3));
System.out.println("Tester Code: " + rs.getInt(4));
System.out.println("Employee Code: " + rs.getInt(5));
System.out.println("Status: " + rs.getString(6));
System.out.println("Bug Description: " + rs.getString(7));
System.out.println("-----------------------------------------------------------------------------");
}
}

catch(Exception e)
{
System.out.println("Error in Viewing Bug Reports" + e.getMessage());
e.printStackTrace();
}
finally 
{
try 
{
if (rs != null) rs.close();
if (sm != null) sm.close();
}
catch (SQLException e) 
{
e.printStackTrace();
}
}
}
}


