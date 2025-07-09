import java.util.*;

public class Assignment3
{
public static void main(String [] args)
{
Scanner ob = new Scanner(System.in);
System.out.println("Enter the number: ");
int num = ob.nextInt();
int original = num;
 int sum = 0;
while(num>0)
{
int a = num%10;
num = num/10;
sum = sum + a;
}

System.out.println("The sum of digits of " + original + " is " + sum);
}
}
