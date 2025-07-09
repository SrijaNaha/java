import java.util.*;

public class Assignment3
{
public static void main(String [] args)
{
Scanner ob = new Scanner(System.in);
System.out.println("Enter the value of y: ");
int y = ob.nextInt();
System.out.println("Enter the value of x: ");
int x = ob.nextInt();
int prod = y;

for(int i = 1; i<x; i++)
{
prod = prod*y;
}

System.out.println("The result is: " + (prod));

}
}
