import java.util.*;

 class student
{
int rollno;
String name;
float mark1;
float mark2;
float mark3;
float total;
float average;
 
public void getdata()
{
Scanner sc = new Scanner(System.in);
System.out.println("Enter the name of the Student: ");
name = sc.nextLine();
System.out.println("Enter the roll no of the Student: ");
rollno = sc.nextInt();
System.out.println("Enter mark1: ");
mark1 = sc.nextFloat();
System.out.println("Enter mark2: ");
mark2 = sc.nextFloat();
System.out.println("Enter mark3: ");
mark3 = sc.nextFloat();
}


public void gettotal()
{
total = mark1 + mark2 + mark3;
average = total/3;
}

public void displaydata()
{
System.out.println(" Name of the Student: " + name);
System.out.println("Rollno of the Student: " + rollno);
System.out.println("Mark1: " + mark1);
System.out.println("Mark2: " + mark2);
System.out.println("Mark3: " + mark3);
System.out.println("Total marks: " + total);
System.out.println("Average marks: " + average);
}
}

public class Assignment4
{
public static void main(String [] args)
{
student s1 = new student();
s1.getdata();
s1.gettotal();
s1.displaydata();
}
}
