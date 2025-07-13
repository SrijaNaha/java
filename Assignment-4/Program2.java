import java.util.*;
class Employee
{
int empID;
String empName;
int deptID;
String bloodGroup;
float salary;

public void setEmployeeDetails()
{
Scanner sc = new Scanner(System.in);
System.out.println("Enter Employee Id: ");
empID = sc.nextInt();
sc.nextLine();
System.out.println("Enter Employee Name: ");
empName = sc.nextLine();
System.out.println("Enter Department Id: ");
deptID = sc.nextInt();
sc.nextLine();
System.out.println("Enter Blood Group: ");
bloodGroup = sc.nextLine();
System.out.println("Enter Salary: ");
salary = sc.nextFloat();
}

public void printEmployeeDetails()
{
System.out.println("Employee Details:");
System.out.println("Employee Id: " + empID);
System.out.println("Employee Name: " + empName);
System.out.println("Department Id: "+ deptID);
System.out.println("Blood Group: " + bloodGroup);
System.out.println("Employee Salary: "+ salary);
}
}

 public class Assignment4
{
public static void main(String [] args)
{
Employee E1 = new Employee();
E1.setEmployeeDetails();
E1.printEmployeeDetails();
}
}
