import java.util.*;

public class Assignment3
{
public static void main(String [] args)
{
Scanner ob = new Scanner(System.in);
System.out.println("Enter the number: ");
int num = ob.nextInt();

int original = num;
int reverse = 0;

while(num!=0)
{
int a = num%10;
reverse = (reverse*10) + a;
num = num/10;
}

if(original == reverse)
{
System.out.println("The number is a palindrome");
}
else
{
System.out.println("The number is not a palindrome");
}
}
}
