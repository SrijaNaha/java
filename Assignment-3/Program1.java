import java.util.*;

public class Assignment3
{
public static void main(String [] args)
{
int i;
Scanner ob = new Scanner(System.in);
System.out.println("Enter the number whose factorial has to be calculated: ");
int num = ob.nextInt();
int prod = 1;

for(i=1; i<=num; i++)
{
prod = prod*i;
}

System.out.println("The factorial of " + num + " is " + prod);
}
}
