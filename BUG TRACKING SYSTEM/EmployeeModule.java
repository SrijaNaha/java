package SRC;

import java.sql.*;
import java.util.*;



public class EmployeeModule extends DBConnection
{ 
Scanner sc = new Scanner(System.in);

public EmployeeModule() {
super();
}


public void AddBugReport(int testerCode) 
{
String choice;
do 
{
PreparedStatement stmt = null;
try
{
System.out.print("Enter Bug No: ");
int BNo = sc.nextInt();
System.out.print("Enter Bug Code: ");
int BCode = sc.nextInt();
System.out.print("Enter Project ID: ");
int id = sc.nextInt();
System.out.print("Enter Developer Code (assigned to): ");
int ECode = sc.nextInt();
sc.nextLine();
System.out.print("Enter Status: ");
String Status = sc.nextLine();
System.out.print("Enter Bug Description: ");
String Desc = sc.nextLine();

stmt = conn.prepareStatement("INSERT INTO BugReport VALUES (?, ?, ?, ?, ?, ?, ?)");
stmt.setInt(1, BNo);
stmt.setInt(2, BCode);
stmt.setInt(3, id);
stmt.setInt(4, testerCode);
stmt.setInt(5, ECode);
stmt.setString(6, Status);
stmt.setString(7, Desc);

int i = stmt.executeUpdate();
if(i>0)
{
System.out.println("New Bug Report Added Successfully.");
}
else
{
System.out.println("Error in Adding Bug Report!!");
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
System.out.print("Add another bug report? (Yes/No): ");
choice = sc.nextLine().trim();
} while (choice.equalsIgnoreCase("Yes"));
}


    
public void ViewBugs(int empCode) 
{
Statement sm = null;
ResultSet rs = null;
try 
{
sm = conn.createStatement();
rs = sm.executeQuery("SELECT * FROM BugReport WHERE ECode = " + empCode);

System.out.println("------Bug List Assigned------");
while (rs.next()) 
{
System.out.println("Bug No       : " + rs.getInt("bugNo"));
System.out.println("Bug Code     : " + rs.getInt("bugCode"));
System.out.println("Project ID   : " + rs.getInt("projectID"));
System.out.println("Tester Code  : " + rs.getInt("TCode"));
System.out.println("Status       : " + rs.getString("status"));
System.out.println("Bug Description  : " + rs.getString("bugDes"));
System.out.println("----------------------------------------");
}
}
catch (Exception e) 
{
System.out.println("Error in Viewing Bugs: " + e.getMessage());
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

    
public void BugDetails() 
{
String choice;
do 
{
PreparedStatement stmt = null;
ResultSet rs = null;
try 
{
System.out.print("Enter the Bug Code to view details: ");
int BCode = sc.nextInt();
sc.nextLine();

stmt = conn.prepareStatement("SELECT bugCode, bugCatgory, bugSeverty FROM BugType WHERE bugCode = ?" );
               
stmt.setInt(1, BCode);
rs = stmt.executeQuery();
if (rs.next()) 
{
System.out.println("Bug Code    : " + rs.getInt("bugCode"));
System.out.println("Bug Type    : " + rs.getString("bugCatgory"));
System.out.println("Bug Severity    : " + rs.getString("bugSeverty"));
} 
else 
{
System.out.println("No bug type found for entered code: " + BCode + " Please enter a valid code." );
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
if (rs != null) rs.close();
} 
catch (SQLException e) 
{
e.printStackTrace();
}
}
System.out.print("View another bug detail? (Yes/No): ");
choice = sc.nextLine().trim();
} while (choice.equalsIgnoreCase("Yes"));
} 



public void UpdateProfile(int empCode) 
{
String choice;
do 
{
PreparedStatement stmt = null;
try 
{
System.out.print("Enter new Email: ");
String Email = sc.nextLine();
System.out.print("Enter new Mobile No: ");
long Mobile = sc.nextLong();
sc.nextLine();
System.out.print("Enter new Password: ");
String Pass = sc.nextLine();

stmt = conn.prepareStatement("UPDATE Employee SET empEmail = ?, mobileNo = ?, empPassword = ? WHERE empCode = ?");
stmt.setString(1, Email);
stmt.setLong(2, Mobile);
stmt.setString(3, Pass);
stmt.setInt(4, empCode);
int i = stmt.executeUpdate();
if(i>0)
{
System.out.println("Employee Profile Updated Successfully.");
}
else
{
System.out.println("Error in Updating Employee Profile.");
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
System.out.print("Update profile again? (Yes/No): ");
choice = sc.nextLine().trim();
}while (choice.equalsIgnoreCase("Yes"));
}



public void UpdateBugStatus(int empCode) 
{
String choice;
do
{
PreparedStatement stmt = null;
PreparedStatement ps = null;
ResultSet rs = null;
try 
{
 System.out.print("Enter Bug No to update status: ");
 int BNo = sc.nextInt();
 sc.nextLine();

stmt = conn.prepareStatement("SELECT * FROM BugReport WHERE bugNo = ? AND ECode = ?");
            
stmt.setInt(1, BNo);
stmt.setInt(2, empCode);
rs = stmt.executeQuery();

if (rs.next()) 
{
System.out.print("Enter new Status (Pending/Resolved): ");
String Status = sc.nextLine();
System.out.print("Enter updated Bug Description: ");
String Desc = sc.nextLine();

 ps = conn.prepareStatement("UPDATE BugReport SET status = ?, bugDes = ? WHERE bugNo = ?");
 ps.setString(1, Status);
 ps.setString(2, Desc);
 ps.setInt(3, BNo);

 int i = ps.executeUpdate();
if(i>0)
{
System.out.println("Bug Status Updated Successfully.");
}
else
{
System.out.println("Error in Updating Bug Status!!");
}
}
else 
{
System.out.println("Bug not found or not assigned to you.");
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
if (rs != null) rs.close();
if (stmt != null) stmt.close();
if (ps != null) ps.close();
} 
catch (SQLException e) 
{
e.printStackTrace();
}
}
System.out.print("Update another bug status? (Yes/No): ");
choice = sc.nextLine().trim();
} while (choice.equalsIgnoreCase("Yes"));
} 
}
