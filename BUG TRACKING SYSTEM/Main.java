package SRC;

import java.sql.*;
import java.util.Scanner;

public class Main extends DBConnection 
{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);
DBConnection db = new DBConnection();
int attemptCount = 0;
final int MAX_ATTEMPTS = 3;

while (true) 
{
System.out.println("\n---- Welcome to Bug Tracking System ----");
System.out.println("Powered By DebugHive Technologies");

System.out.print("Enter Employee Code: ");
int empCode = sc.nextInt();
sc.nextLine();
System.out.print("Enter Password: ");
String password = sc.nextLine();

boolean LoginSuccess = false;
PreparedStatement stmt = null;
ResultSet rs = null;
try 
{
stmt = db.conn.prepareStatement("SELECT empPassword, Role FROM Employee WHERE empCode = ?");
stmt.setInt(1, empCode);
rs = stmt.executeQuery();

if (rs.next()) 
{
String Correct = rs.getString("empPassword");
String role = rs.getString("Role");
if (Correct.equals(password)) 
{
System.out.println("Login Successful. Role: " + role);
LoginSuccess = true;

switch (role.toLowerCase()) 
{
case "admin":
AdminModule admin = new AdminModule();
adminMenu(sc, admin);
break;

case "manager":
ManagerModule manager = new ManagerModule();
managerMenu(sc, manager);
break;

case "developer":
case "tester":
EmployeeModule employee = new EmployeeModule();
employeeMenu(sc, employee, empCode, role);
break;

default:
System.out.println("Unrecognized role.");
}
} 

else 
{
System.out.println("Incorrect Password. Please enter a valid Password!");
}
} 
else 
{
System.out.println("Employee Code not found.");
}
} 

catch (SQLException e) 
{
System.out.println("Login error: " + e.getMessage());
e.printStackTrace();
}
finally 
{
try {
if (rs != null) rs.close();
if (stmt != null) stmt.close();
} 
catch (SQLException e) 
{
e.printStackTrace();
}
}

if (!LoginSuccess) 
{
attemptCount++;
if (attemptCount >= MAX_ATTEMPTS) 
{
System.out.println("Maximum login attempts exceeded. Exiting the system!!");
break;
} 
else 
{
System.out.println("Invalid credentials. Attempts left: " + (MAX_ATTEMPTS - attemptCount));
}
continue;
}

         
System.out.print("\nDo you want to try logging in again? (Yes/No): ");
String retry = sc.nextLine();
if (!retry.equalsIgnoreCase("Yes"))
{
System.out.println("Exiting system...");
System.out.println("Project By Srija Naha. Developed as a part of IIT KANPUR Summer Training Program.");
break;
}
}

try 
{
db.CloseDBConnection();
} 
catch (Exception e) 
{
System.out.println("Error closing DB connection.");
}
sc.close();
}

 // Admin Menu
private static void adminMenu(Scanner sc, AdminModule admin) {
while (true) 
{
System.out.println("\n-- Admin Panel --");
System.out.println("1. Manage Managers");
System.out.println("2. Manage Employees");
System.out.println("3. View All Projects");
System.out.println("4. View All Bug Reports");
System.out.println("5. Logout");
System.out.print("Enter Choice: ");
int choice = sc.nextInt();
sc.nextLine();

AdminModule.Manager mgr = admin.new Manager();
AdminModule.Employee emp = admin.new Employee();

switch (choice) 
{
case 1:
System.out.println("1.Add  \n2.View  \n3.Delete  \n4.Update");
int ManOpt = sc.nextInt();
sc.nextLine();
if (ManOpt == 1) mgr.AddManager();
else if (ManOpt == 2) mgr.ViewManager();
else if (ManOpt == 3) mgr.DeleteManager();
else if (ManOpt == 4) mgr.UpdateManager();
break;

case 2:
System.out.println("1.Add \n2.View  \n3.Delete  \n4.Update");
int EmpOpt = sc.nextInt();
sc.nextLine();
if (EmpOpt == 1) emp.AddEmployee();
else if (EmpOpt == 2) emp.ViewEmployee();
else if (EmpOpt == 3) emp.DeleteEmployee();
else if (EmpOpt == 4) emp.UpdateEmployee();
break;

case 3:
admin.ViewProjects();
break;

case 4:
admin.ViewBugReports();
break;

case 5:
return;
default:
System.out.println("Invalid option!!");
}
}
}

//  Manager Menu
private static void managerMenu(Scanner sc, ManagerModule mgr) {
ManagerModule.Project project = mgr.new Project();
ManagerModule.Bug bug = mgr.new Bug();

while (true) 
{
System.out.println("\n-- Manager Panel --");
System.out.println("1. Update Profile");
System.out.println("2. Manage Projects");
System.out.println("3. Manage Bugs");
System.out.println("4. Logout");
System.out.print("Enter Choice: ");
int choice = sc.nextInt();
sc.nextLine();
switch (choice)
{
case 1:
mgr.UpdateProfile();
break;

case 2:
System.out.println("1.Add \n2.View  \n3.Delete  \n4.Update");
int PrOpt = sc.nextInt();
sc.nextLine();
if (PrOpt == 1) project.AddProject();
else if (PrOpt == 2) project.ViewProject();
else if (PrOpt == 3) project.DeleteProject();
else if (PrOpt == 4) project.UpdateProject();
break;

case 3:
System.out.println("1.Add \n2.View  \n3.Delete  \n4.Update");
int BugOpt = sc.nextInt();
sc.nextLine();
if (BugOpt == 1) bug.AddBug();
else if (BugOpt == 2) bug.ViewBugs();
else if (BugOpt == 3) bug.UpdateBug();
else if (BugOpt == 4) bug.DeleteBug();
break;

case 4:
return;

default:
System.out.println("Invalid option.");
}
}
}

// Employee Menu
private static void employeeMenu(Scanner sc, EmployeeModule employee, int empCode, String role) 
{
if (role.equalsIgnoreCase("tester"))
{
while (true) 
{
System.out.println("\n-- Tester Panel --");
System.out.println("1. Add Bug Report");
System.out.println("2. Logout");
System.out.print("Enter Choice: ");
int choice = sc.nextInt();
sc.nextLine();
switch (choice) 
{
case 1:
employee.AddBugReport(empCode);
break;

case 2:
return;

default:
System.out.println("Invalid option.");
}
}
} 

else 
{
while (true) 
{
System.out.println("\n-- Developer Panel --");
System.out.println("1. Update Profile");
System.out.println("2. View Bugs");
System.out.println("3. Bug Details");
System.out.println("4. Update Bug Status");
System.out.println("5. Logout");
System.out.print("Choose: ");
int choice = sc.nextInt();
sc.nextLine();
switch (choice) 
{
case 1:
employee.UpdateProfile(empCode);
break;
case 2:
employee.ViewBugs(empCode);
break;

case 3:
employee.BugDetails();
break;
case 4:
employee.UpdateBugStatus(empCode); 
break;            
case 5:
return;
default:
System.out.println("Invalid option.");
}
}
}
}
}


