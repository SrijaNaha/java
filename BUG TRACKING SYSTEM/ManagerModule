package SRC;

import java.sql.*;
import java.util.*;

public class ManagerModule extends DBConnection
{
Scanner sc = new Scanner(System.in);
public ManagerModule()
{
super();
}

public void UpdateProfile()
{
String choice;
do
{
PreparedStatement stmt = null;
try
{
System.out.println("Enter  Manager Code: ");
int Code = sc.nextInt();
sc.nextLine();
System.out.println("Enter new Email: ");
String Email = sc.nextLine();
System.out.println("Enter new Mobile No.: ");
long Mobile = sc.nextLong();
sc.nextLine();
System.out.println("Enter new Password: ");
String Pass = sc.nextLine();

stmt = conn.prepareStatement("UPDATE Employee SET empEmail = ?, mobileNo = ?, empPassword = ? WHERE empCode = ? AND Role = 'Manager'");
stmt.setString(1,Email);
stmt.setLong(2,Mobile);
stmt.setString(3,Pass);
stmt.setInt(4,Code);

int i = stmt.executeUpdate();
if(i>0)
{
System.out.println("Manager Profile Updated.");
}
else
{
System.out.println("Error in updating Manager Profile.");
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
System.out.println("Update Another Profile? (Yes/No): ");
choice = sc.nextLine().trim();
}while(choice.equalsIgnoreCase("Yes"));
}




public class Project
{
public void AddProject()
{
String choice;
do
{
PreparedStatement stmt = null;
try
{
System.out.println("Enter Project ID: ");
int id = sc.nextInt();
sc.nextLine();
System.out.println("Enter Project Name: ");
String Name = sc.nextLine();
System.out.println("Enter Start Date: ");
String SDate = sc.nextLine();
System.out.println("Enter End Date: ");
String EDate = sc.nextLine();
System.out.println("Enter Project Description: ");
String Desc = sc.nextLine();
stmt = conn.prepareStatement("INSERT INTO Project VALUES(?,?,?,?,?)");
stmt.setInt(1,id);
stmt.setString(2,Name);
stmt.setString(3,SDate);
stmt.setString(4,EDate);
stmt.setString(5,Desc);
int i = stmt.executeUpdate();
if(i>0)
{
System.out.println("Project Added Successfully.");
}
else
{
System.out.println("Error in adding Project!!");
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
System.out.println("Add Another Project? (Yes/No): ");
choice = sc.nextLine().trim();
}while(choice.equalsIgnoreCase("Yes"));
}





public void ViewProject() 
{
Statement sm = null;
ResultSet rs = null;
try
{
sm = conn.createStatement();
rs = sm.executeQuery("SELECT * FROM Project");
System.out.println("---------------Project Details-----------------");
while (rs.next()) 
{
System.out.println("Project ID: " + rs.getInt("projectID"));
System.out.println("Name: " + rs.getString("projectName"));
System.out.println("Start Date: " + rs.getString("SDate"));
System.out.println("End Date: " + rs.getString("EDate"));
System.out.println("Description: " + rs.getString("projectDec"));
System.out.println("----------------------------------------------------------------------------------------------");
}
} 
catch (Exception e) 
{
System.out.println("Error in viewing Project Details: " + e.getMessage());
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


public void DeleteProject()
{
String choice;
do
{
PreparedStatement stmt = null;
try 
{
System.out.print("Enter Project ID to delete: ");
int id = sc.nextInt();
sc.nextLine();
stmt = conn.prepareStatement("DELETE FROM Project WHERE projectID = ?");
stmt.setInt(1, id);
int i = stmt.executeUpdate();
if(i>0)
{
System.out.println("Project Deleted Successfully.");
}
else
{
System.out.println("Error in Deleting Project!!");
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
System.out.println("Delete Another Project? (Yes/No): ");
choice = sc.nextLine().trim();
}while(choice.equalsIgnoreCase("Yes"));
}



public void UpdateProject()
{
String choice;
do
{
PreparedStatement stmt = null;
try 
{
System.out.print("Enter Project ID to update: ");
int id = sc.nextInt(); 
sc.nextLine();
System.out.print("Enter new Project Name: ");
String Name = sc.nextLine();
System.out.print("Enter new End Date: ");
String EDate = sc.nextLine();
System.out.print("Enter new Description: ");
String Desc = sc.nextLine();

stmt = conn.prepareStatement("UPDATE Project SET projectName = ?, EDate = ?, projectDec = ? WHERE projectID = ?");
stmt.setString(1,Name);
stmt.setString(2, EDate);
stmt.setString(3, Desc);
stmt.setInt(4, id);
int i = stmt.executeUpdate();
                
if(i>0)
{
System.out.println("Project Updated Successfully.");
}
else
{
System.out.println("Error in Updating Project!!");
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
System.out.println("Update Another Project? (Yes/No): ");
choice = sc.nextLine().trim();
}while(choice.equalsIgnoreCase("Yes"));
}
}
 

public class Bug 
{
public void AddBug() 
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
System.out.print("Enter Tester Code: ");
int TCode = sc.nextInt();
System.out.print("Enter Employee Code: ");
int ECode = sc.nextInt();
sc.nextLine();
System.out.print("Enter Status: ");
String Status = sc.nextLine();
System.out.print("Enter Description: ");
String Desc = sc.nextLine();
stmt = conn.prepareStatement("INSERT INTO BugReport VALUES (?, ?, ?, ?, ?, ?, ?)");
stmt.setInt(1, BNo);
stmt.setInt(2, BCode);
stmt.setInt(3, id);
stmt.setInt(4, TCode);
stmt.setInt(5, ECode);
stmt.setString(6, Status);
stmt.setString(7, Desc);

int i = stmt.executeUpdate();
if(i>0)
{
System.out.println("Bug Added Successfully.");
}
else
{
System.out.println("Error in Adding Bug!!");
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
System.out.println("Add Another Bug? (Yes/No): ");
choice = sc.nextLine().trim();
}while(choice.equalsIgnoreCase("Yes"));
}



public void ViewBugs() 
{
Statement sm = null;
ResultSet rs = null;
try 
{
sm = conn.createStatement();
rs = sm.executeQuery("SELECT * FROM BugReport");
System.out.println("--------Bug Records--------");
while (rs.next()) 
{
System.out.println("Bug No: " + rs.getInt("bugNo"));
System.out.println("Bug Code: " + rs.getInt("bugCode"));
System.out.println("Project ID: " + rs.getInt("projectID"));
System.out.println("Tester Code: " + rs.getInt("TCode"));
System.out.println("Employee Code: " + rs.getInt("ECode"));
System.out.println("Status: " + rs.getString("status"));
System.out.println("Bug Description: " + rs.getString("bugDes"));
System.out.println("---------------------------------------------------");
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

 public void UpdateBug()
 {
String choice;
do
{
PreparedStatement stmt = null;
try 
{
System.out.print("Enter Bug No. to update: ");
int BNo = sc.nextInt(); 
sc.nextLine();
System.out.print("Enter new Status: ");
String Status = sc.nextLine();
System.out.print("Enter new Description: ");
String Desc = sc.nextLine();

stmt = conn.prepareStatement("UPDATE BugReport SET status = ?, bugDes = ? WHERE bugNo = ?");
stmt.setString(1, Status);
stmt.setString(2, Desc);
stmt.setInt(3, BNo);
int i = stmt.executeUpdate();
if(i>0)
{
System.out.println("Bug Updated Successfully.");
}
else
{
System.out.println("Error in Updating Bug!!");
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
System.out.println("Update Another Bug? (Yes/No): ");
choice = sc.nextLine().trim();
}while(choice.equalsIgnoreCase("Yes"));
}
      



public void DeleteBug()
{
String choice;
do
{
PreparedStatement stmt = null;
try 
{
System.out.print("Enter Bug No to delete: ");
int BNo = sc.nextInt();
sc.nextLine();
stmt = conn.prepareStatement("DELETE FROM BugReport WHERE bugNo = ?");
stmt.setInt(1, BNo);
int i = stmt.executeUpdate();
if(i>0)
{
System.out.println("Bug Deleted Successfully.");
}
else
{
System.out.println("Error in Deleting Bug!!");
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
System.out.println("Delete Another Bug? (Yes/No): ");
choice = sc.nextLine().trim();
}while(choice.equalsIgnoreCase("Yes"));
}                  
}
}







